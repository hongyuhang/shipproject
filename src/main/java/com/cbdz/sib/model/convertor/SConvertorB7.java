package com.cbdz.sib.model.convertor;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;

public class SConvertorB7 extends BaseConvertor {
    public JSONObject convert(JSONObject x_json) {
        String[] p_fields = new String[]{
                "messageLinkageID",
                "utcMonth",
                "utcDay",
                "utcHour",
                "utcMinute",
                "portName",
                "destination",
                "longitude",
                "latitude"
        };
//        protected Method m_calcLongitude; // 经度
//        protected Method m_calcLatitude; // 纬度
//        protected Method m_calcUtcMonth; // UTC月
//        protected Method m_calcUtcDay; // UTC日
//        protected Method m_calcUtcHour; // UTC小时
//        protected Method m_calcUtcMinute; // UTC分
//        protected Method m_calcWindSpeed; // 风速
//        protected Method m_calcDirection; // 方向
//        protected Method m_calcAirTemperature; // 气温
//        protected Method m_calcRelativeHumidity; // 相对湿度
//        protected Method m_calcDewPoint; // 露点
//        protected Method m_calcAirPressure; // 气压
//        protected Method m_calcHorizontalVisibility; // 水平能见度
//        protected Method m_calcWaterLevel; // 水位（含潮汐）
//        protected Method m_calcSpeed; // 流速（含潮汐）、流速
//        protected Method m_calcMeasuringLevel; // 测流深度
//        protected Method m_calcWaveHeight; // 标识波高
//        protected Method m_calcPeriod; // 波浪周期
//        protected Method m_calcSeaState; // 海况
//        protected Method m_calcWaterTemperature; // 水温
//        protected Method m_calcSalinity; // 盐份
//        protected Method m_calcPositionAccuracy; // 位置精度
//        protected Method m_calcAirPressureTendency; // 气压趋势
//        protected Method m_calcWaterLevelTrend; // 水位趋势
//        protected Method m_calcPrecipitation; // 降水量（级别）
//        protected Method m_calcIce; // 结冰
//        protected Method m_calcDestinationMmsi; // 发送对象
//        protected Method m_calcMessageLinkageID; // 消息链接ID
//        protected Method m_calcBit6Char5Len; // 5个6位ASCII字符
//        protected Method m_calcBit6Char20Len; // 20个6位ASCII字符
        Method[] p_ms = new Method[]{
                m_calcMessageLinkageID,
                m_calcUtcMonth,
                m_calcUtcDay,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcBit6Char20Len,
                m_calcBit6Char5Len,
                m_calcLongitude,
                m_calcLatitude
        };
        return super.convertByArg(x_json, p_fields, p_ms);
    }
}
