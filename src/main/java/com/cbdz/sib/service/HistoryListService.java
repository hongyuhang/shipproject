package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.dao.DataSHistoryMapper;
import com.cbdz.sib.dao.MenuMapper;
import com.cbdz.sib.model.DataSHistory;
import com.cbdz.sib.model.DataSHistoryExample;
import com.cbdz.sib.model.Menu;
import com.cbdz.sib.model.convertor.BaseConvertor;
import com.cbdz.sib.model.sender.BaseSender;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class HistoryListService {
    @Autowired
    private DataSHistoryMapper g_mapper;
    @Autowired
    private MenuMapper g_mapperMenu;

    @Transactional
    public JSONObject sendData(JSONObject x_json) {
        JSONObject p_ret = new JSONObject();
        DataSHistoryExample p_example = new DataSHistoryExample();
        DataSHistoryExample.Criteria p_where = p_example.createCriteria();
        // 发送时间
        // 安全消息类别
        if (StringUtil.isEmpty(x_json.getString("msg_code")))
        p_where.andMsgCodeEqualTo(x_json.getString("msg_code"));
        // 发送类型
        // 目标MMSI
        // 处理结果
        return null;
    }

}
