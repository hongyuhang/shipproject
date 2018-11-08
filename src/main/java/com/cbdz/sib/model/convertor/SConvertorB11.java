package com.cbdz.sib.model.convertor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.AppUtils;

import java.lang.reflect.Method;

public class SConvertorB11 extends BaseConvertor {
    public JSONObject convert(JSONObject x_json) {
        String[] p_fields = new String[]{
                "messageLinkageID",
                "noticeDescription",
                "utcMonth",
                "utcDay",
                "utcHour",
                "utcMinute",
                "duration"
        };
        Method[] p_ms = new Method[]{
                m_calcMessageLinkageID,
                m_calcNoticeDescription,
                m_calcUtcMonth,
                m_calcUtcDay,
                m_calcUtcHour,
                m_calcUtcMinute,
                m_calcDuration
        };
        JSONObject p_ret = super.convertByArg(x_json, p_fields, p_ms);
        // 子区域
        JSONArray p_ary = x_json.getJSONArray("subAreas");
        JSONArray p_aryRet = new JSONArray();
        if (p_ary != null) {
            for (int i = 0; i < p_ary.size(); i++) {
                JSONObject p_tmp = p_ary.getJSONObject(i);
                if (StringUtils.equals(p_tmp.getString("areaShape"), "0")) {
                    p_aryRet.add(this.calcSubAreaOn0(p_tmp));
                } else if (StringUtils.equals(p_tmp.getString("areaShape"), "1")) {
                    p_aryRet.add(this.calcSubAreaOn1(p_tmp));
                } else if (StringUtils.equals(p_tmp.getString("areaShape"), "2")) {
                    p_aryRet.add(this.calcSubAreaOn2(p_tmp));
                } else if (StringUtils.equals(p_tmp.getString("areaShape"), "3")
                    || StringUtils.equals(p_tmp.getString("areaShape"), "4")) {
                    p_aryRet.add(this.calcSubAreaOn34(p_tmp));
                } else if (StringUtils.equals(p_tmp.getString("areaShape"), "5")) {
                    p_aryRet.add(this.calcSubAreaOn5(p_tmp));
                }
            }
        }
        p_ret.put("subAreas", p_aryRet);
        return p_ret;
    }

    /**
     * 转换圆形或点状区域
     * @param x_json
     * @return
     */
    private JSONObject calcSubAreaOn0(JSONObject x_json) {
        String[] p_fields = new String[]{
                "scaleFactor",
                "longitude",
                "latitude",
                "precision"
        };
        Method[] p_ms = new Method[]{
                m_calcScaleFactor,
                m_calcLongitude,
                m_calcLatitude,
                m_calcPrecision
        };

        JSONObject p_ret = super.convertByArg(x_json, p_fields, p_ms);
        p_ret.put("areaShape", x_json.getInteger("areaShape"));
        if (x_json.getInteger("radius") == null) {
            p_ret.put("radius", 0);
        } else {
            p_ret.put("radius", x_json.getInteger("radius") * p_ret.getInteger("scaleFactor"));
        }
        return p_ret;
    }
    /**
     * 转换矩形区域
     * @param x_json
     * @return
     */
    private JSONObject calcSubAreaOn1(JSONObject x_json) {
        String[] p_fields = new String[]{
                "scaleFactor",
                "longitude",
                "latitude",
                "precision",
                "orientation"
        };
        Method[] p_ms = new Method[]{
                m_calcScaleFactor,
                m_calcLongitude,
                m_calcLatitude,
                m_calcPrecision,
                m_calcOrientation
        };

        JSONObject p_ret = super.convertByArg(x_json, p_fields, p_ms);
        p_ret.put("areaShape", x_json.getInteger("areaShape"));
        if (x_json.getInteger("dimensionE") == null) {
            p_ret.put("dimensionE", 0);
        } else {
            p_ret.put("dimensionE", x_json.getInteger("dimensionE") * p_ret.getInteger("scaleFactor"));
        }
        if (x_json.getInteger("dimensionN") == null) {
            p_ret.put("dimensionN", 0);
        } else {
            p_ret.put("dimensionN", x_json.getInteger("dimensionN") * p_ret.getInteger("scaleFactor"));
        }
        return p_ret;
    }
    /**
     * 转换扇形区域
     * @param x_json
     * @return
     */
    private JSONObject calcSubAreaOn2(JSONObject x_json) {
        String[] p_fields = new String[]{
                "scaleFactor",
                "longitude",
                "latitude",
                "precision",
                "leftBoundary",
                "rightBoundary"
        };
        Method[] p_ms = new Method[]{
                m_calcScaleFactor,
                m_calcLongitude,
                m_calcLatitude,
                m_calcPrecision,
                m_calcOrientation,
                m_calcOrientation
        };

        JSONObject p_ret = super.convertByArg(x_json, p_fields, p_ms);
        p_ret.put("areaShape", x_json.getInteger("areaShape"));
        if (x_json.getInteger("radius") == null) {
            p_ret.put("radius", 0);
        } else {
            p_ret.put("radius", x_json.getInteger("radius") * p_ret.getInteger("scaleFactor"));
        }
        return p_ret;
    }
    /**
     * 转换航路点/折线点/多边形
     * @param x_json
     * @return
     */
    private JSONObject calcSubAreaOn34(JSONObject x_json) {
        String[] p_fields = new String[]{
                "scaleFactor",
                "pointAngle1",
                "pointAngle2",
                "pointAngle3",
                "pointAngle4"
        };
        Method[] p_ms = new Method[]{
                m_calcScaleFactor,
                m_calcPointAngle,
                m_calcPointAngle,
                m_calcPointAngle,
                m_calcPointAngle
        };

        JSONObject p_ret = super.convertByArg(x_json, p_fields, p_ms);
        p_ret.put("areaShape", x_json.getInteger("areaShape"));
        for (int i = 1; i <= 4; i++) {
            if (x_json.getInteger("pointDistance" + i) == null) {
                p_ret.put("pointDistance" + i, 0);
            } else {
                p_ret.put("pointDistance" + i, x_json.getInteger("pointDistance" + i) * p_ret.getInteger("scaleFactor"));
            }
        }
        return p_ret;
    }

    /**
     * 转换关联文本
     * @param x_json
     * @return
     */
    private JSONObject calcSubAreaOn5(JSONObject x_json) {
        JSONObject p_ret = new JSONObject();
        p_ret.put("areaShape", x_json.getInteger("areaShape"));
        if (x_json.getInteger("text") == null) {
            p_ret.put("text", AppUtils.padLeft("", 14, '@'));
        } else {
            p_ret.put("text", AppUtils.padLeft(x_json.getString("text"), 14, '@'));
        }
        return p_ret;
    }
}
