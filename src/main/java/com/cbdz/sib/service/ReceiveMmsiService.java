package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.dao.DataSHistoryMapper;
import com.cbdz.sib.dao.MenuMapper;
import com.cbdz.sib.dao.MmsiCurrentMapper;
import com.cbdz.sib.exception.errorcode.ErrorCode;
import com.cbdz.sib.model.DataSHistory;
import com.cbdz.sib.model.Menu;
import com.cbdz.sib.model.MmsiCurrent;
import com.cbdz.sib.model.convertor.BaseConvertor;
import com.cbdz.sib.model.sender.BaseSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReceiveMmsiService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MmsiCurrentMapper g_mapper;

    @Transactional
    public JSONObject receiveMmsi(JSONObject x_json) {
        List<MmsiCurrent> p_list = new ArrayList<MmsiCurrent>();
        try {
            JSONArray p_ary = x_json.getJSONArray("shipInfo");
            for (int i = 0; i < p_ary.size(); i++) {
                JSONObject p_jsonObj = p_ary.getJSONObject(i);
                MmsiCurrent p_tmp = JSONObject.toJavaObject(p_jsonObj, MmsiCurrent.class);
                p_list.add(p_tmp);
            }
        } catch (Exception e) {
            logger.error("ReceiveMmsiService.receiveMmsi() 转换JSON失败 ： " + x_json.toJSONString());
            return ErrorCode.RECEIVE_DATA_ERROR.getJson();
        }
        for (MmsiCurrent per : p_list) {
            g_mapper.insert(per);
        }
        return ErrorCode.SUCCESS.getJson();
    }
}
