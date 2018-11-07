package com.cbdz.sib.model.convertor;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;

public class SConvertorB3 extends BaseConvertor {
    public JSONObject convert(JSONObject x_json) {
        String[] p_fields = new String[]{
                "utcMonth",
                "utcDay",
                "positionLongitude1",
                "positionLatitude1",
                "fromUtcHour1",
                "fromUtcMinute1",
                "toUtcHour1",
                "toUtcMinute1",
                "currentDirectionPredicted1",
                "currentSpeedPredicted1",
                "positionLongitude2",
                "positionLatitude2",
                "fromUtcHour2",
                "fromUtcMinute2",
                "currentDirectionPredicted2",
                "currentSpeedPredicted2",
                "positionLongitude3",
                "positionLatitude3",
                "fromUtcHour3",
                "fromUtcMinute3",
                "toUtcHour3",
                "toUtcMinute3",
                "currentDirectionPredicted3",
                "currentSpeedPredicted3"
        };
        Method[] p_ms = new Method[]{
                m_calcUtcMonth,
                m_calcUtcDay,
                m_calcLongitude,
                m_calcLatitude,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcDirection,
                m_calcSpeed,
                m_calcLongitude,
                m_calcLatitude,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcDirection,
                m_calcSpeed,
                m_calcLongitude,
                m_calcLatitude,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcDirection,
                m_calcSpeed
        };
        return super.convertByArg(x_json, p_fields, p_ms);
    }
}
