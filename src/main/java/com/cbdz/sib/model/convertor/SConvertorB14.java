package com.cbdz.sib.model.convertor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;

public class SConvertorB14 extends BaseConvertor {
    public JSONObject convert(JSONObject x_json) {
        JSONObject p_ret = new JSONObject();
        p_ret.put("messageLinkageID", super.calcMessageLinkageID(x_json.getInteger("messageLinkageID")));
        p_ret.put("textString", x_json.getString("textString"));
        return p_ret;
    }
}
