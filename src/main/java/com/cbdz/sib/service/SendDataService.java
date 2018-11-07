package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.dao.DataSHistoryMapper;
import com.cbdz.sib.dao.MenuMapper;
import com.cbdz.sib.model.DataSHistory;
import com.cbdz.sib.model.Menu;
import com.cbdz.sib.model.convertor.BaseConvertor;
import com.cbdz.sib.model.sender.BaseSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SendDataService {
    @Autowired
    private DataSHistoryMapper g_mapper;
    @Autowired
    private MenuMapper g_mapperMenu;

    @Transactional
    public JSONObject sendData(String x_menuCd, JSONObject x_json) {
        long p_startms = System.currentTimeMillis();
        Date p_now = new Date();
        Menu p_menuInfo = g_mapperMenu.selectByPrimaryKey(x_menuCd);
        // 1 根据页面的菜单CODE，对页面数据进行转换
        JSONObject p_sendData = BaseConvertor.getSendData(x_json, p_menuInfo.getMsgCode(), p_menuInfo.getsType());

        // 2 取得目标服务并调用发送
        BaseSender p_sender = BaseSender.getInstance(p_menuInfo.getsType());
        JSONObject p_ret = p_sender.send(p_sendData);
        long p_endms = System.currentTimeMillis();
        // 3 登录历史数据
        DataSHistory p_data = new DataSHistory();
        p_data.setExecMs((int) (p_endms - p_startms)); // 执行时间
        p_data.setmCode(x_menuCd); // 菜单CODE
        p_data.setmName(p_menuInfo.getmName()); // 消息类型（等同于菜单名称）
        p_data.setMsgCode(p_menuInfo.getMsgCode()); // 安全消息CODE
        p_data.setRetCode(p_ret.getString("rst_code")); // 返回结果CODE(200:成功、以外:失败）
        p_data.setRetMsg(p_ret.getString("rst_message")); // 返回结果消息
        p_data.setPageJson(x_json.toJSONString()); // 页面JSON
        p_data.setsJson(p_sendData.toJSONString()); // 发送JSON
        p_data.setsTime(p_now); // 发送时间
        if (StringUtils.isEmpty(x_json.getString("destinationMmsi"))) {
            p_data.setsType("1"); // 广播
        } else {
            p_data.setsType("2"); // 寻址
            p_data.setMmsi(x_json.getString("destinationMmsi")); //
        }
        g_mapper.insert(p_data);

        // 5 返回页面
        return p_ret;
    }
}
