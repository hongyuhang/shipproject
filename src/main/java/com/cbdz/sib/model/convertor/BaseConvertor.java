package com.cbdz.sib.model.convertor;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author cuihe
 *
 */
public abstract  class BaseConvertor {
    public abstract  JSONObject convert(JSONObject x_json);

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
}
