package com.cbdz.sib.model.sender;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.AppUtils;
import com.cbdz.sib.common.Constant;
import com.cbdz.sib.common.RSAUtils;
import com.cbdz.sib.exception.errorcode.ErrorCode;

public class HlhtSender extends BaseSender {
    public HlhtSender(String x_sendType) {
        super(x_sendType);
    }
    @Override
    public JSONObject send(JSONObject x_json) {
        logger.debug("HlhtSender.send() start ");
        JSONObject p_json = new JSONObject();
        String p_retData;
        String p_url;
        String p_token;

        try {
            // 取得token
            p_url = Constant.getExtensionConfig(Constant.Key.CFG_HLHT_WEB_URL) + "/oauth/get_token";
            p_json.put("opcode", "10");
            p_json.put("app_id", this.getVdesAppidInHlht());
            p_json.put("secret", this.getVdesSecretInHlht());
            logger.debug("取得token时，url=" + p_url + " 参数：" + JSON.toJSONString(p_json, true));
            p_token = AppUtils.doPostJson(p_url, p_json);
            logger.debug("取得token时，返回=" + p_token);
            p_json = JSONObject.parseObject(p_token);
            p_token = p_json.getString("token");
            logger.debug("取得token时，token=" + p_token);
        } catch (Exception e) {
            logger.error("HlhtSender.send() 取得token error occurs:", e);
            logger.debug("HlhtSender.send() end Exception ");
            return ErrorCode.HLHT_TOKEN_ERR.getJson();
        }

        try {
            // 取得目标服务地址
            p_url = Constant.getExtensionConfig(Constant.Key.CFG_HLHT_WEB_URL) + "/serviceapi/apirequest";
            p_json.put("app_id", this.getVdesAppidInHlht());
            p_json.put("secret", this.getVdesSecretInHlht());
            p_json.put("token", p_token);
            p_json.put("service", this.getVdesServiceInHlht());
            logger.debug("取得目标服务地址时，url=" + p_url + " 参数：" + JSON.toJSONString(p_json, true));
            p_retData = AppUtils.doPostJson(p_url, p_json);
            logger.debug("取得目标服务地址时，返回=" + p_retData);
            p_json = JSONObject.parseObject(p_retData);
            p_retData = p_json.getJSONObject("data").getString("url");
            logger.debug("取得目标服务地址时，地址=" + p_retData);
        } catch (Exception e) {
            logger.error("HlhtSender.send() 取得token error occurs:", e);
            logger.debug("HlhtSender.send() end Exception ");
            return ErrorCode.HLHT_SERVER_URL_ERR.getJson();
        }

        try {
            // 目标服务调用
            p_url = p_retData + this.getVdesService();
            String p_key = Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_RSA_PUBLIC_KEY);
            String p_val = x_json.toJSONString();
            p_val = RSAUtils.encrypt(p_val, p_key, false);

            p_json = new JSONObject();
            p_json.put("params", p_val);
            logger.debug("目标服务调用时，url=" + p_url + " 参数：" + JSON.toJSONString(p_json, true));
            p_retData = AppUtils.doPostJson(p_url, p_json);
            logger.debug("目标服务调用时，返回=" + p_retData);
            logger.debug("HlhtSender.send() end Success ");
            return JSONObject.parseObject(p_retData);
        } catch (Exception e) {
            logger.error("HlhtSender.send() 取得token error occurs:", e);
            logger.debug("HlhtSender.send() end Exception ");
            return ErrorCode.HLHT_SERVER_INVOKE_ERR.getJson();
        }
    }
    /**
     * 获取VDES APPID（互联互通）
     * @return
     */
    private String getVdesAppidInHlht() {
        if (StringUtils.equals(super.g_sendType, Constant.Value.CONST_SEND_FLAG_BROADCAST)) {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_APP_ID_IN_HLHT_BROADCAST);
        } else {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_APP_ID_IN_HLHT_ADDRESSING);
        }
    }
    /**
     * 获取VDES Secret（互联互通）
     * @return
     */
    private String getVdesSecretInHlht() {
        if (StringUtils.equals(super.g_sendType, Constant.Value.CONST_SEND_FLAG_BROADCAST)) {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_SECRET_IN_HLHT_BROADCAST);
        } else {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_SECRET_IN_HLHT_ADDRESSING);
        }
    }
    /**
     * 获取VDES Service（互联互通）
     * @return
     */
    private String getVdesServiceInHlht() {
        if (StringUtils.equals(super.g_sendType, Constant.Value.CONST_SEND_FLAG_BROADCAST)) {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_SERVICE_IN_HLHT_BROADCAST);
        } else {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_SERVICE_IN_HLHT_ADDRESSING);
        }
    }
    /**
     * 获取VDES Service
     * @return
     */
    private String getVdesService() {
        if (StringUtils.equals(super.g_sendType, Constant.Value.CONST_SEND_FLAG_BROADCAST)) {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_SERVICE_BROADCAST);
        } else {
            return Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_SERVICE_ADDRESSING);
        }
    }
}
