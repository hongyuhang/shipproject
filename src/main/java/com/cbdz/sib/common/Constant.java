package com.cbdz.sib.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
@Component
public class Constant {
	public class Value {
		// 使用VDES服务URL区分（1:从互联互通平台取得服务URL）
		public static final String CFG_ENVIRONMENT_FLAG_HLHT = "environment_flag";
		// 使用VDES服务URL区分（2:用测试VDES服务URL）
		public static final String CFG_ENVIRONMENT_FLAG_TEST = "environment_flag";

		public static final String CONST_SEND_FLAG_BROADCAST = "1";
		public static final String CONST_SEND_FLAG_ADDRESSING = "2";
	}
	public class Key {
		// 互联互通平台URL
		public static final String CFG_HLHT_WEB_URL = "hlht_web_url";
		// 以下为取得VDES服务的参数
		public static final String CFG_VDES_IF_APP_ID_IN_HLHT_BROADCAST = "vdes_if_app_id_in_hlht_broadcast";
		public static final String CFG_VDES_IF_SECRET_IN_HLHT_BROADCAST = "vdes_if_secret_in_hlht_broadcast";
		public static final String CFG_VDES_IF_SERVICE_IN_HLHT_BROADCAST = "vdes_if_service_in_hlht_broadcast";
		public static final String CFG_VDES_IF_APP_ID_IN_HLHT_ADDRESSING = "vdes_if_app_id_in_hlht_addressing";
		public static final String CFG_VDES_IF_SECRET_IN_HLHT_ADDRESSING = "vdes_if_secret_in_hlht_addressing";
		public static final String CFG_VDES_IF_SERVICE_IN_HLHT_ADDRESSING = "vdes_if_service_in_hlht_addressing";
		// VDES服务URL的SERVICE部分
		public static final String CFG_VDES_IF_SERVICE_BROADCAST = "vdes_if_service_broadcast";
		public static final String CFG_VDES_IF_SERVICE_ADDRESSING = "vdes_if_service_addressing";
		// 测试用VDES服务URL
		public static final String CFG_TEST_VDES_IF_URL_BROADCAST = "test_vdes_if_url_broadcast";
		public static final String CFG_TEST_VDES_IF_URL_ADDRESSING = "test_vdes_if_url_addressing";
		// 使用VDES服务URL区分（1:从互联互通平台取得服务URL、2:用测试VDES服务URL）
		public static final String CFG_ENVIRONMENT_FLAG = "environment_flag";
		// VDES服务公钥
		public static final String CFG_VDES_IF_RSA_PUBLIC_KEY = "vdes_if_rsa_public_key";
		// 安全消息播发服务私钥
		public static final String CFG_MY_RSA_PRIVATE_KEY = "my_rsa_private_key";
		// 安全消息发送超时（ms）
		public static final String CFG_SEND_TIMEOUT = "send_timeout";
		// MMSI保留时间（h）
		public static final String CFG_MMSI_SAVE_TIME = "mmsi_save_time";
	}

	public static Environment s_environment;
	// 最后配置文件的修改时间
	private static long g_extFileTime = 0;
	// 配置文件内容
	private static HashMap<String, String> g_extConfig = null;

	@Autowired
	public Constant(Environment x_obj) {
		s_environment = x_obj;
	}
	/**
	 * 扩展Config读取
	 * @return 
	 */
	private static HashMap<String, String> getExtConfig() throws Exception {
		String p_filePath = s_environment.getProperty("extension_file");
		File p_file = new File(p_filePath);
		if (p_file.lastModified() > g_extFileTime) {
			HashMap<String, String> p_ret = new HashMap<String, String>();
			try {
				FileReader p_reader = new FileReader(p_file);
				BufferedReader p_br = new BufferedReader(p_reader);
				String p_tmp;
				while((p_tmp = p_br.readLine()) != null){
					if (p_tmp.startsWith("#")) {
						continue;
					}
					int p_idx = p_tmp.indexOf("=");
					if (p_idx > 0) {
						p_ret.put(p_tmp.substring(0, p_idx), p_tmp.substring(p_idx +1));
					}
				}
				
				p_br.close();
				p_reader.close();
				g_extConfig = p_ret;
				g_extFileTime = p_file.lastModified();
			} catch (Exception e) {
				throw e;
			}
		}
	
		return g_extConfig;
	}
	/**
	 * 扩展Config读取
	 * @param x_key
	 * @return
	 * @throws Exception
	 */
	public static Integer getExtensionConfigInt(String x_key) {
		
		try {
			HashMap<String, String> p_hash = getExtConfig();
			return Integer.valueOf(p_hash.get(x_key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 扩展Config读取
	 * @param x_key
	 * @return
	 * @throws Exception
	 */
	public static String getExtensionConfig(String x_key) {
		
		try {
			HashMap<String, String> p_hash = getExtConfig();
			return p_hash.get(x_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
