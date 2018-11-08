package com.cbdz.sib.model.convertor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.AppUtils;
import com.cbdz.sib.common.Constant;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author cuihe
 *
 */
public abstract  class BaseConvertor {
    private static final BaseConvertor const_b1Convertor = new SConvertorB1();
    private static final BaseConvertor const_b3Convertor = new SConvertorB3();
    private static final BaseConvertor const_b7Convertor = new SConvertorB7();
    private static final BaseConvertor const_b8Convertor = new SConvertorB8();
    private static final BaseConvertor const_b9Convertor = new SConvertorB9();
    private static final BaseConvertor const_b11Convertor = new SConvertorB11();
    private static final BaseConvertor const_b13Convertor = new SConvertorB13();
    private static final BaseConvertor const_b14Convertor = new SConvertorB14();
    protected Method m_calcLongitude; // 经度
    protected Method m_calcLatitude; // 纬度
    protected Method m_calcUtcMonth; // UTC月
    protected Method m_calcUtcDay; // UTC日
    protected Method m_calcUtcHour; // UTC小时
    protected Method m_calcUtcMinute; // UTC分
    protected Method m_calcWindSpeed; // 风速
    protected Method m_calcDirection; // 方向
    protected Method m_calcAirTemperature; // 气温
    protected Method m_calcRelativeHumidity; // 相对湿度
    protected Method m_calcDewPoint; // 露点
    protected Method m_calcAirPressure; // 气压
    protected Method m_calcHorizontalVisibility; // 水平能见度
    protected Method m_calcWaterLevel; // 水位（含潮汐）
    protected Method m_calcSpeed; // 流速（含潮汐）、流速
    protected Method m_calcMeasuringLevel; // 测流深度
    protected Method m_calcWaveHeight; // 标识波高
    protected Method m_calcPeriod; // 波浪周期
    protected Method m_calcSeaState; // 海况
    protected Method m_calcWaterTemperature; // 水温
    protected Method m_calcSalinity; // 盐份
    protected Method m_calcPositionAccuracy; // 位置精度
    protected Method m_calcAirPressureTendency; // 气压趋势
    protected Method m_calcWaterLevelTrend; // 水位趋势
    protected Method m_calcPrecipitation; // 降水量（级别）
    protected Method m_calcIce; // 结冰
    protected Method m_calcMessageLinkageID; // 消息链接ID
    protected Method m_calcBit6Char5Len; // 5个6位ASCII字符
    protected Method m_calcBit6Char20Len; // 20个6位ASCII字符
    protected Method m_calcStatusOfSignal; // 信号状态
    protected Method m_calcSignalInService; // 在服务信号
    protected Method m_calcBerthLength; // 泊位长度
    protected Method m_calcWaterDepthAtBerth; // 泊位水深
    protected Method m_calcMooringPosition; // 泊位位置
    protected Method m_calcServicesAvailability; // 服务有效性
    protected Method m_calcSenderClassification; // 发送者分类
    protected Method m_calcRouteType; // 航线类型
    protected Method m_calcDuration; // 持续时间
    protected Method m_calcNoticeDescription; // 公告说明
    protected Method m_calcScaleFactor; // 比例因子
    protected Method m_calcPrecision; // 精度
    protected Method m_calcOrientation; // Orientation、左边界、右边界
    protected Method m_calcPointAngle; // 倾角


    public BaseConvertor() {
        try {
            m_calcLongitude            = BaseConvertor.class.getDeclaredMethod("calcLongitude", BigDecimal.class);
            m_calcLatitude             = BaseConvertor.class.getDeclaredMethod("calcLatitude", BigDecimal.class);
            m_calcUtcDay               = BaseConvertor.class.getDeclaredMethod("calcUtcDay", Integer.class);
            m_calcUtcHour              = BaseConvertor.class.getDeclaredMethod("calcUtcHour", Integer.class);
            m_calcUtcMinute            = BaseConvertor.class.getDeclaredMethod("calcUtcMinute", Integer.class);
            m_calcWindSpeed            = BaseConvertor.class.getDeclaredMethod("calcWindSpeed", Integer.class);
            m_calcDirection            = BaseConvertor.class.getDeclaredMethod("calcDirection", Integer.class);
            m_calcAirTemperature       = BaseConvertor.class.getDeclaredMethod("calcAirTemperature", BigDecimal.class);
            m_calcRelativeHumidity     = BaseConvertor.class.getDeclaredMethod("calcRelativeHumidity", Integer.class);
            m_calcDewPoint             = BaseConvertor.class.getDeclaredMethod("calcDewPoint", BigDecimal.class);
            m_calcAirPressure          = BaseConvertor.class.getDeclaredMethod("calcAirPressure", Integer.class);
            m_calcHorizontalVisibility = BaseConvertor.class.getDeclaredMethod("calcHorizontalVisibility", BigDecimal.class);
            m_calcWaterLevel           = BaseConvertor.class.getDeclaredMethod("calcWaterLevel", BigDecimal.class);
            m_calcSpeed                = BaseConvertor.class.getDeclaredMethod("calcSpeed", BigDecimal.class);
            m_calcMeasuringLevel       = BaseConvertor.class.getDeclaredMethod("calcMeasuringLevel", Integer.class);
            m_calcWaveHeight           = BaseConvertor.class.getDeclaredMethod("calcWaveHeight", BigDecimal.class);
            m_calcPeriod               = BaseConvertor.class.getDeclaredMethod("calcPeriod", Integer.class);
            m_calcSeaState             = BaseConvertor.class.getDeclaredMethod("calcSeaState", Integer.class);
            m_calcWaterTemperature     = BaseConvertor.class.getDeclaredMethod("calcWaterTemperature", BigDecimal.class);
            m_calcSalinity             = BaseConvertor.class.getDeclaredMethod("calcSalinity", BigDecimal.class);
            m_calcPositionAccuracy     = BaseConvertor.class.getDeclaredMethod("calcPositionAccuracy", Integer.class);
            m_calcAirPressureTendency  = BaseConvertor.class.getDeclaredMethod("calcAirPressureTendency", Integer.class);
            m_calcWaterLevelTrend      = BaseConvertor.class.getDeclaredMethod("calcWaterLevelTrend", Integer.class);
            m_calcPrecipitation        = BaseConvertor.class.getDeclaredMethod("calcPrecipitation", Integer.class);
            m_calcIce                  = BaseConvertor.class.getDeclaredMethod("calcIce", Integer.class);
            m_calcUtcMonth             = BaseConvertor.class.getDeclaredMethod("calcIce", Integer.class);
            m_calcMessageLinkageID     = BaseConvertor.class.getDeclaredMethod("calcMessageLinkageID", Integer.class);
            m_calcBit6Char5Len         = BaseConvertor.class.getDeclaredMethod("calcBit6Char5Len", String.class);
            m_calcBit6Char20Len        = BaseConvertor.class.getDeclaredMethod("calcBit6Char20Len", String.class);
            m_calcStatusOfSignal       = BaseConvertor.class.getDeclaredMethod("calcStatusOfSignal", Integer.class);
            m_calcSignalInService      = BaseConvertor.class.getDeclaredMethod("calcSignalInService", Integer.class);
            m_calcBerthLength          = BaseConvertor.class.getDeclaredMethod("calcBerthLength", Integer.class);
            m_calcWaterDepthAtBerth    = BaseConvertor.class.getDeclaredMethod("calcWaterDepthAtBerth", BigDecimal.class);
            m_calcMooringPosition      = BaseConvertor.class.getDeclaredMethod("calcMooringPosition", Integer.class);
            m_calcServicesAvailability = BaseConvertor.class.getDeclaredMethod("calcServicesAvailability", Integer.class);
            m_calcSenderClassification = BaseConvertor.class.getDeclaredMethod("calcSenderClassification", Integer.class);
            m_calcRouteType            = BaseConvertor.class.getDeclaredMethod("calcRouteType", Integer.class);
            m_calcDuration             = BaseConvertor.class.getDeclaredMethod("calcDuration", Integer.class);
            m_calcNoticeDescription    = BaseConvertor.class.getDeclaredMethod("calcNoticeDescription", Integer.class);
            m_calcScaleFactor          = BaseConvertor.class.getDeclaredMethod("calcScaleFactor", Integer.class);
            m_calcPrecision            = BaseConvertor.class.getDeclaredMethod("calcPrecision", Integer.class);
            m_calcOrientation          = BaseConvertor.class.getDeclaredMethod("calcOrientation", Integer.class);
            m_calcPointAngle           = BaseConvertor.class.getDeclaredMethod("calcPointAngle", BigDecimal.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 主方法
     * @param x_json
     * @return
     */
    protected abstract  JSONObject convert(JSONObject x_json);

    /**
     * 主方法
     * @param x_json
     * @param x_msgCode
     * @param x_sendType
     * @return
     */
    public static JSONObject getSendData(JSONObject x_json, String x_msgCode, String x_sendType) {
        JSONObject p_ret = new JSONObject();
        BaseConvertor p_convertor = getInstance(x_msgCode);
        JSONObject p_data = p_convertor.convert(x_json);
        p_ret.put("type", x_msgCode);
        p_ret.put("data", p_data);
        // 寻址发送时，需要写MMSI
        if (StringUtils.equals(x_sendType, Constant.Value.CONST_SEND_FLAG_ADDRESSING)) {
            p_ret.put("destinationMmsi", x_json.getString("destinationMmsi"));
        }
        return p_ret;
    }
    /**
     * 返回指定菜单CODE对应的转换实例
     * @param x_msgCode
     * @return
     */
    private static BaseConvertor getInstance(String x_msgCode) {
        if (StringUtils.equals(x_msgCode, "1")) {
            return const_b1Convertor;
        } else if (StringUtils.equals(x_msgCode, "3")) {
            return const_b3Convertor;
        } else if (StringUtils.equals(x_msgCode, "7")) {
            return const_b7Convertor;
        } else if (StringUtils.equals(x_msgCode, "8")) {
            return const_b8Convertor;
        } else if (StringUtils.equals(x_msgCode, "9")) {
            return const_b9Convertor;
        } else if (StringUtils.equals(x_msgCode, "11")) {
            return const_b11Convertor;
        } else if (StringUtils.equals(x_msgCode, "13")) {
            return const_b13Convertor;
        } else if (StringUtils.equals(x_msgCode, "14")) {
            return const_b14Convertor;
        }
        return null;
    }
    /**
     * 对给定JSON做指定字段的指定方法，并组成新的JSNO返回
     * @param x_json
     * @param x_fields
     * @param x_methods
     * @return
     */
    protected JSONObject convertByArg(JSONObject x_json, String[] x_fields, Method[] x_methods) {
        JSONObject p_ret = new JSONObject();
        for (int i = 0; i < x_fields.length; i++) {
            Method p_m = x_methods[i];
            Object p_argVal = null;
            Class p_classArg = p_m.getParameterTypes()[0];
            if (Integer.class.equals(p_classArg)) {
                p_argVal = x_json.getInteger(x_fields[i]);
            } else if (BigDecimal.class.equals(p_classArg)) {
                p_argVal = x_json.getBigDecimal(x_fields[i]);
            } else if (String.class.equals(p_classArg)) {
                p_argVal = x_json.getString(x_fields[i]);
            }
            Object p_convertedVal;
            try {
                p_convertedVal = p_m.invoke(this, p_argVal);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            p_ret.put(x_fields[i], p_convertedVal);
        }
        return p_ret;
    }
    /**
     * 计算经度
     * @param x_val
     * @return
     */
    protected BigDecimal calcLongitude(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return BigDecimal.valueOf(181);
        }
        BigDecimal p_int = new BigDecimal(x_val.intValue(), MathContext.DECIMAL32);
        BigDecimal p_dot = x_val.subtract(p_int).multiply(BigDecimal.valueOf(0.6)).setScale(3, RoundingMode.HALF_UP);
        return p_int.add(p_dot);
    }
    /**
     * 计算纬度
     * @param x_val
     * @return
     */
    protected BigDecimal calcLatitude(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return BigDecimal.valueOf(91);
        }
        BigDecimal p_int = new BigDecimal(x_val.intValue(), MathContext.DECIMAL32);
        BigDecimal p_dot = x_val.subtract(p_int).multiply(BigDecimal.valueOf(0.6)).setScale(3, RoundingMode.HALF_UP);
        return p_int.add(p_dot);
    }

    /**
     * 计算日期
     * @param x_val
     * @return
     */
    protected int calcUtcDay(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算小时
     * @param x_val
     * @return
     */
    protected int calcUtcHour(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 24;
        }
        return x_val;
    }
    /**
     * 计算分钟
     * @param x_val
     * @return
     */
    protected int calcUtcMinute(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 60;
        }
        return x_val;
    }
    /**
     * 计算风速
     * @param x_val
     * @return
     */
    protected int calcWindSpeed(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 127;
        }
        if (x_val > 126) {
            return 126;
        }
        return x_val;
    }
    /**
     * 计算方向
     * @param x_val
     * @return
     */
    protected int calcDirection(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 360;
        }
        return x_val;
    }
    /**
     * 计算气温
     * @param x_val
     * @return
     */
    protected int calcAirTemperature(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return -1024;
        }
        return x_val.movePointRight(1).intValue();
    }
    /**
     * 计算相对湿度
     * @param x_val
     * @return
     */
    protected int calcRelativeHumidity(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 101;
        }
        return x_val;
    }
    /**
     * 计算露点
     * @param x_val
     * @return
     */
    protected int calcDewPoint(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 501;
        }
        return x_val.movePointRight(1).intValue();
    }
    /**
     * 计算气压
     * @param x_val
     * @return
     */
    protected int calcAirPressure(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 511;
        }
        // 0 = 799hPa或更低
        // 402 = 1201hPa或更高
        // 1～401 = 800~1200hPa
        if (x_val < 800) {
            return 0;
        } else if (x_val > 1200) {
            return 402;
        } else {
            return x_val - 799;
        }
    }
    /**
     * 计算水平能见度
     * @param x_val
     * @return
     */
    protected int calcHorizontalVisibility(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 127;
        }
        return x_val.multiply(BigDecimal.TEN).intValue();
    }
    /**
     * 计算水位（含潮汐）
     * @param x_val
     * @return
     */
    protected int calcWaterLevel(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 4001;
        }
        return x_val.add(BigDecimal.TEN).multiply(BigDecimal.valueOf(100)).intValue();
    }
    /**
     * 计算表面流速（含潮汐）、流速
     * @param x_val
     * @return
     */
    protected int calcSpeed(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 255;
        }
        if (x_val.doubleValue() > 25.1) {
            return 251;
        }
        return x_val.multiply(BigDecimal.TEN).intValue();
    }

    /**
     * 计算测流深度
     * @param x_val
     * @return
     */
    protected int calcMeasuringLevel(Integer x_val) {
        if (x_val == null) {
            return 31;
        }
        return x_val;
    }
    /**
     * 计算标识波高
     * @param x_val
     * @return
     */
    protected int calcWaveHeight(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 255;
        }
        if (x_val.doubleValue() > 25.1) {
            return 251;
        }
        return x_val.multiply(BigDecimal.TEN).intValue();
    }
    /**
     * 计算波浪周期
     * @param x_val
     * @return
     */
    protected int calcPeriod(Integer x_val) {
        if (x_val == null) {
            return 63;
        }
        return x_val;
    }
    /**
     * 计算海况
     * @param x_val
     * @return
     */
    protected int calcSeaState(Integer x_val) {
        if (x_val == null) {
            return 13;
        }
        return x_val;
    }
    /**
     * 计算水温
     * @param x_val
     * @return
     */
    protected int calcWaterTemperature(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 501;
        }
        return x_val.multiply(BigDecimal.TEN).intValue();
    }
    /**
     * 计算盐份
     * @param x_val
     * @return
     */
    protected int calcSalinity(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 510;
        }
        return x_val.multiply(BigDecimal.TEN).intValue();
    }
    /**
     * 计算位置精度
     * @param x_val
     * @return
     */
    protected int calcPositionAccuracy(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算气压趋势
     * @param x_val
     * @return
     */
    protected int calcAirPressureTendency(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 3;
        }
        return x_val;
    }
    /**
     * 计算水位趋势
     * @param x_val
     * @return
     */
    protected int calcWaterLevelTrend(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 3;
        }
        return x_val;
    }
    /**
     * 计算降水量（级别）
     * @param x_val
     * @return
     */
    protected int calcPrecipitation(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 7;
        }
        return x_val;
    }
    /**
     * 计算结冰
     * @param x_val
     * @return
     */
    protected int calcIce(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 3;
        }
        return x_val;
    }
    /**
     * 计算UTC月
     * @param x_val
     * @return
     */
    protected int calcUtcMonth(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算消息链接ID
     * @param x_val
     * @return
     */
    protected int calcMessageLinkageID(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算6位ASCII字符
     * @param x_val
     * @param x_len
     * @return
     */
    private String calcBit6Char(String x_val, Integer x_len) {
        // 默认值
        if (StringUtils.isEmpty(x_val)) {
            return AppUtils.padLeft("", x_len, '@');
        }
        return x_val;
    }
    /**
     * 计算5个6位ASCII字符
     * @param x_val
     * @return
     */
    protected String calcBit6Char5Len(String x_val) {
        // 默认值
        if (StringUtils.isEmpty(x_val)) {
            return AppUtils.padLeft("", 5, '@');
        }
        return x_val;
    }
    /**
     * 计算20个6位ASCII字符
     * @param x_val
     * @return
     */
    protected String calcBit6Char20Len(String x_val) {
        // 默认值
        if (StringUtils.isEmpty(x_val)) {
            return AppUtils.padLeft("", 20, '@');
        }
        return x_val;
    }
    /**
     * 计算信号状态
     * @param x_val
     * @return
     */
    protected int calcStatusOfSignal(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算在服务信号
     * @param x_val
     * @return
     */
    protected int calcSignalInService(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算泊位长度
     * @param x_val
     * @return
     */
    protected int calcBerthLength(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        if (x_val > 511) {
            return 511;
        }
        return x_val;
    }

    /**
     * 计算泊位水深
     * @param x_val
     * @return
     */
    protected int calcWaterDepthAtBerth(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        if (x_val.doubleValue() > 25.5) {
            return 255;
        }
        return x_val.multiply(BigDecimal.TEN).intValue();
    }
    /**
     * 计算泊位长度
     * @param x_val
     * @return
     */
    protected int calcMooringPosition(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算服务有效性
     * @param x_val
     * @return
     */
    protected int calcServicesAvailability(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算可用服务类型
     * @param x_val
     * @return
     */
    protected int calcTypeOfServicesAvailable(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 发送者分类
     * @param x_val
     * @return
     */
    protected int calcSenderClassification(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 发送者分类
     * @param x_val
     * @return
     */
    protected int calcRouteType(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 持续时间、公告持续时间
     * @param x_val
     * @return
     */
    protected int calcDuration(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 公告说明
     * @param x_val
     * @return
     */
    protected int calcNoticeDescription(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 127;
        }
        return x_val;
    }
    /**
     * 比例因子
     * @param x_val
     * @return
     */
    protected int calcScaleFactor(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return BigDecimal.ONE.scaleByPowerOfTen(x_val).intValue();
    }
    /**
     * 精度
     * @param x_val
     * @return
     */
    protected int calcPrecision(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 4;
        }
        return x_val;
    }
    /**
     * Orientation
     * @param x_val
     * @return
     */
    protected int calcOrientation(Integer x_val) {
        // 默认值
        if (x_val == null) {
            return 0;
        }
        return x_val;
    }
    /**
     * 计算泊位水深
     * @param x_val
     * @return
     */
    protected int calcPointAngle(BigDecimal x_val) {
        // 默认值
        if (x_val == null) {
            return 720;
        }
        return x_val.multiply(BigDecimal.valueOf(2)).intValue();
    }

}
