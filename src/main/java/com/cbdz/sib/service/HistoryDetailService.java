package com.cbdz.sib.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.AppUtils;
import com.cbdz.sib.dao.DataSHistoryMapper;
import com.cbdz.sib.model.DataSHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryDetailService {
    @Autowired
    private DataSHistoryMapper g_mapper;
    @Autowired
    private PageItemService g_pageService;

    @Transactional
    public JSONObject getHistDetail(String x_seq) {
        // 根据SEQ取发送记录
        DataSHistory p_dbData = this.getSearchResult(x_seq);
        // 取发送记录的画面JSON
        JSONObject p_pageData = JSONObject.parseObject(p_dbData.getPageJson());
        // 画面初始设定取得
        Map<String, Object> p_pis = g_pageService.getPageItemByMenuCd(p_dbData.getmCode());

        // 用画面JSON覆盖初始设定
        List<Map<String, Object>> p_items = (List<Map<String, Object>>)p_pis.get("items");
        for (Map<String, Object> per : p_items) {
            per.put("val", AppUtils.getDefault(p_pageData.getString((String) per.get("id")), ""));
            per.put("disabled", true);
        }

        JSONObject p_ret = (JSONObject) JSONObject.toJSON(p_pis);
        // B.11区域通告的场合，需要整合子区域返回
        JSONArray p_subAreas = p_pageData.getJSONArray("subAreas");
        if (p_subAreas != null) {
            p_ret.put("subAreaData", p_subAreas);

            Map<String, Object> p_subDef = new HashMap<>();
            p_subDef.put("label", "子区域");
            p_subDef.put("modelId", "#myArea");
            p_subDef.put("disabled", true);
            p_ret.put("subArea", p_subDef);
        }
        return p_ret;
    }

    /**
     * 按照检索条件检索出历史数据
     * @param x_seq
     * @return
     */
    private DataSHistory getSearchResult(String x_seq) {
        return g_mapper.selectByPrimaryKey(Long.valueOf(x_seq));
    }
}
