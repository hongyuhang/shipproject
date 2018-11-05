package com.cbdz.sib.model.sender;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.AppUtils;
import com.cbdz.sib.common.Constant;
import com.cbdz.sib.common.RSAUtils;
import com.cbdz.sib.exception.errorcode.ErrorCode;

public class TestSender extends BaseSender {
    public TestSender(String x_sendType) {
        super(x_sendType);
    }
    @Override
    public JSONObject send(JSONObject x_json) {
        logger.debug("TestSender.send() start ");
        JSONObject p_json = new JSONObject();
        String p_retData;
        String p_url;
        String p_token;

        try {
            // 目标服务调用
            p_url = getVdesIfUrl();
            String p_key = Constant.getExtensionConfig(Constant.Key.CFG_VDES_IF_RSA_PUBLIC_KEY);
            String p_val = x_json.toJSONString();
            p_val = RSAUtils.encrypt(p_val, p_key, false);

            p_json = new JSONObject();
            p_json.put("params", p_val);
            logger.debug("目标服务调用时，url=" + p_url + " 参数：" + JSON.toJSONString(p_json, true));
            p_retData = AppUtils.doPostJson(p_url, p_json);
            logger.debug("目标服务调用时，返回=" + p_retData);
            return JSONObject.parseObject(p_retData);
        } catch (Exception e) {
            logger.error("TestSender.send() 目标服务调用 error occurs:", e);
            logger.debug("TestSender.send() end Exception ");
            return ErrorCode.HLHT_SERVER_INVOKE_ERR.getJson();
        }
    }

    /**
     * 获取VDES测试URL
     * @return
     */
    private String getVdesIfUrl() {
        if (StringUtils.equals(super.g_sendType, Constant.Value.CONST_SEND_FLAG_BROADCAST)) {
            return Constant.getExtensionConfig(Constant.Key.CFG_TEST_VDES_IF_URL_BROADCAST);
        } else {
            return Constant.getExtensionConfig(Constant.Key.CFG_TEST_VDES_IF_URL_ADDRESSING);
        }
    }
}
