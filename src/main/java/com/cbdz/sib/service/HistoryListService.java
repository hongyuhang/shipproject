package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.Constant;
import com.cbdz.sib.dao.DataSHistoryMapper;
import com.cbdz.sib.dao.MenuMapper;
import com.cbdz.sib.model.DataSHistory;
import com.cbdz.sib.model.DataSHistoryExample;
import com.cbdz.sib.model.Menu;
import com.cbdz.sib.model.MenuExample;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryListService {
    @Autowired
    private DataSHistoryMapper g_mapper;
    @Autowired
    private MenuMapper g_mapperMenu;

    @Transactional
    public JSONObject getHistList(JSONObject x_json) {
        JSONObject p_ret = new JSONObject();
        // 设定标题
        JSONArray p_cols = new JSONArray();
        String[] p_itemIdsInList = new String[]{"seq", "s_time", "m_name", "s_type", "mmsi", "ret_msg", "exec_ms"};
        String[] p_titlesInList = new String[]{"序号", "发送时间", "安全消息类别", "发送类型", "目标MMSI", "处理结果", "执行时间(ms)"};
        for (int i = 0; i < p_itemIdsInList.length; i++) {
            JSONObject p_tmp = new JSONObject();
            p_tmp.put("data", p_itemIdsInList[i]);
            p_tmp.put("title", p_titlesInList[i]);
            p_cols.add(p_tmp);
        }
        p_ret.put("columns", p_cols);

        // 设定数据
        List<DataSHistory> p_dbData = this.getSearchResult(x_json);
        Map<String, String> p_msgMap = this.getSendTypeKeyValue();
        JSONArray p_datas = new JSONArray();
        for (int i = 0; i < p_dbData.size(); i++) {
            DataSHistory p_per = p_dbData.get(i);

            JSONObject p_tmp = new JSONObject();
            p_tmp.put("seq", p_per.getSeq());
            p_tmp.put("s_time", p_per.getsTime());
            p_tmp.put("m_name", p_msgMap.get(p_per.getMsgCode()));
            if (StringUtils.equals(p_per.getsType(), Constant.Value.CONST_SEND_FLAG_BROADCAST)) {
                p_tmp.put("s_type", "广播");
            } else {
                p_tmp.put("s_type", "寻址");
            }
            p_tmp.put("mmsi", p_per.getMmsi());
            p_tmp.put("ret_msg", p_per.getRetMsg());
            p_tmp.put("exec_ms", p_per.getExecMs());
            p_datas.add(p_tmp);
        }
        p_ret.put("datas", p_datas);

        return p_ret;
    }

    /**
     * 安全消息类型CODE+名称
     * @return
     */
    private Map<String, String> getSendTypeKeyValue() {
        Map<String, String> p_ret = new HashMap<>();
        MenuExample p_example = new MenuExample();
        List<Menu> p_menus = g_mapperMenu.selectByExample(p_example);
        for (Menu per : p_menus) {
            p_ret.put(per.getMsgCode(), per.getmName());
        }
        return p_ret;
    }

    /**
     * 按照检索条件检索出历史数据
     * @param x_json
     * @return
     */
    private List<DataSHistory> getSearchResult(JSONObject x_json) {

        DataSHistoryExample p_example = new DataSHistoryExample();
        DataSHistoryExample.Criteria p_where = p_example.createCriteria();
        // 发送时间
        if (x_json.getDate("s_time_fr") != null) {
            p_where.andSTimeGreaterThanOrEqualTo(x_json.getDate("s_time_fr"));
        }
        if (x_json.getDate("s_time_to") != null) {
            p_where.andSTimeLessThanOrEqualTo(x_json.getDate("s_time_to"));
        }
        // 安全消息类别
        if (!StringUtil.isEmpty(x_json.getString("msg_code"))) {
            p_where.andMsgCodeEqualTo(x_json.getString("msg_code"));
        }
        // 发送类型
        if (!StringUtil.isEmpty(x_json.getString("s_type"))) {
            String[] p_sTypes = x_json.getString("s_type").split(",");
            List<String> p_listTmp = new ArrayList<String>();
            for (String per : p_sTypes) {
                p_listTmp.add(per);
            }
            p_where.andSTypeIn(p_listTmp);
        }
        // 目标MMSI
        if (!StringUtil.isEmpty(x_json.getString("mmsi"))) {
            p_where.andMmsiEqualTo(x_json.getString("mmsi"));
        }
        // 处理结果
        if (!StringUtil.isEmpty(x_json.getString("ret_code"))) {
            String p_codeTmp = x_json.getString("ret_code");
            if (StringUtils.equals(p_codeTmp, "1")) {
                p_where.andRetCodeEqualTo("200");
            } else if (StringUtils.equals(p_codeTmp, "2")) {
                p_where.andRetCodeNotEqualTo("200");
            }
        }

        // order by
        p_example.setOrderByClause("seq DESC");

        List<DataSHistory> p_datas = g_mapper.selectByExample(p_example);
        return p_datas;
    }
}
