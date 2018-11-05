package com.cbdz.sib.model.convertor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

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

    protected Method m_calcLongitude;
    protected Method m_calcLatitude;
    protected Method m_calcUtcDay;
    protected Method m_calcUtcHour;
    protected Method m_calcUtcMinute;
    protected Method m_calcWindSpeed;
    protected Method m_calcDirection;
    protected Method m_calcAirTemperature;
    protected Method m_calcRelativeHumidity;
    protected Method m_calcDewPoint;
    protected Method m_calcAirPressure;
    protected Method m_calcHorizontalVisibility;
    protected Method m_calcWaterLevel;
    protected Method m_calcSpeed;
    protected Method m_calcMeasuringLevel;
    protected Method m_calcWaveHeight;
    protected Method m_calcPeriod;
    protected Method m_calcSeaState;
    protected Method m_calcWaterTemperature;
    protected Method m_calcSalinity;
    protected Method m_calcPositionAccuracy;
    protected Method m_calcAirPressureTendency;
    protected Method m_calcWaterLevelTrend;
    protected Method m_calcPrecipitation;
    protected Method m_calcIce;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 主方法
     * @param x_json
     * @return
     */
    public abstract  JSONObject convert(JSONObject x_json);

    /**
     * 返回指定菜单CODE对应的转换实例
     * @param x_menuCd
     * @return
     */
    public static BaseConvertor getInstance(String x_menuCd) {
        if (StringUtils.equals(x_menuCd, "m1_1")) {
            return const_b1Convertor;
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


}
