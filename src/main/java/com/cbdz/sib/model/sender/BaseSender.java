package com.cbdz.sib.model.sender;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseSender {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected String g_sendType = null;
    protected BaseSender(String x_sendType) {
        g_sendType = x_sendType;
    }
    public static BaseSender getInstance(String x_sendType) {
        String p_env = Constant.getExtensionConfig(Constant.Key.CFG_ENVIRONMENT_FLAG);
        if (StringUtils.equals(p_env, Constant.Value.CFG_ENVIRONMENT_FLAG_TEST)) {
            return new TestSender(x_sendType);
        } else {
            return new HlhtSender(x_sendType);
        }
    }
    public abstract JSONObject send(JSONObject x_json);
}
