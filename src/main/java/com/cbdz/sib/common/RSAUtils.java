package com.cbdz.sib.common;

import com.alibaba.druid.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA公钥/私钥工具包
 */
public class RSAUtils {
	private static final int MAX_DECRYPT_BLOCK = 128;
	private static final int MAX_ENCRYPT_BLOCK = 64;

	/**
	 * RSA公钥加密（包括BASE64转码）
	 * 
	 * @param x_val
	 *            原文
	 * @return 加密后String
	 * @throws IOException
	 *             公钥文件缺失
	 * @throws ClassNotFoundException
	 *             指定文件非公钥文件
	 */
	public static String encrypt(String x_val, String x_key, boolean x_isConvertSafeUrl)  {
		X509EncodedKeySpec p_keySpec = new X509EncodedKeySpec(Base64.base64ToByteArray(x_key));
		PublicKey p_pubK;
		try {
			p_pubK = KeyFactory.getInstance("RSA").generatePublic(p_keySpec);
			byte[] buffer = RSAEncode(x_val, p_pubK);
			if (!x_isConvertSafeUrl) {
				return org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(buffer);
			} else {
				return org.apache.tomcat.util.codec.binary.Base64.encodeBase64URLSafeString(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Title: RSAEncode
	 * @Description: 将字符串加密
	 * @param data
	 * @param publicKey
	 * @return String
	 * @throws Exception 
	 */
	private static byte[] RSAEncode(String data, PublicKey publicKey) throws Exception {
		byte[] b = data.getBytes();
		try {
			int inputLen = b.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			// 对数据分段解密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
					cache = cipher.doFinal(b, offSet, MAX_ENCRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(b, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * MAX_ENCRYPT_BLOCK;
			}
			byte[] decryptedData = out.toByteArray();
			out.close();
			return decryptedData;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * RSA私钥解密（包括BASE64转码）
	 * 
	 * @param x_val
	 *            加密后String
	 * @return 解密后String
	 * @throws Exception 
	 * @throws IOException
	 *             私钥文件缺失
	 * @throws ClassNotFoundException
	 *             指定文件非私钥文件
	 */
	public static String decrypt(String x_val) throws Exception {
		String p_priKStr = getPrivateKeyString();
		PKCS8EncodedKeySpec p_keySpec = new PKCS8EncodedKeySpec(Base64.base64ToByteArray(p_priKStr));
		
		byte[] p_afterDecode = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(x_val); // BASE64 转码
		try {
			PrivateKey p_priK = KeyFactory.getInstance("RSA").generatePrivate(p_keySpec);
			return RSADecode(p_afterDecode, p_priK);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Title: RSADecode
	 * @Description: 将字符串解密
	 * @param b
	 * @param privateKey
	 * @return String
	 * @throws Exception 
	 */
	private static String RSADecode(byte[] b, PrivateKey privateKey) throws Exception {
		try {
			int inputLen = b.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			// 对数据分段解密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
					cache = cipher.doFinal(b, offSet, MAX_DECRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(b, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * MAX_DECRYPT_BLOCK;
			}
			byte[] decryptedData = out.toByteArray();
			out.close();
			return new String(decryptedData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * RSA私钥文件读取
	 * @return
	 * @throws Exception 
	 */
	private static String getPrivateKeyString() throws Exception {
		return Constant.getExtensionConfig(Constant.Key.CFG_MY_RSA_PRIVATE_KEY);
	}

	private static final String KEY_ALGORITHM = "RSA";

	private static final String PUBLIC_KEY = "RSAPublicKey";

	private static final String PRIVATE_KEY = "RSAPrivateKey";



	public static void main(String[] args) {

		Map<String, Object> keyMap;

		try {

			keyMap = initKey();

			String publicKey =  getPublicKey(keyMap);

			System.out.println(publicKey);

			String privateKey =  getPrivateKey(keyMap);

			System.out.println(privateKey);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private static String getPublicKey(Map<String, Object> keyMap) throws Exception {

		Key key = (Key) keyMap.get(PUBLIC_KEY);

		byte[] publicKey = key.getEncoded();

		return encryptBASE64(key.getEncoded());

	}

	private static String getPrivateKey(Map<String, Object> keyMap) throws Exception {

		Key key = (Key) keyMap.get(PRIVATE_KEY);

		byte[] privateKey =key.getEncoded();

		return encryptBASE64(key.getEncoded());

	}



	private static byte[] decryptBASE64(String key) throws Exception {

		return (new BASE64Decoder()).decodeBuffer(key);

	}



	private static String encryptBASE64(byte[] key) throws Exception {

		return (new BASE64Encoder()).encodeBuffer(key);

	}



	private static Map<String, Object> initKey() throws Exception {

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

		keyPairGen.initialize(1024);

		KeyPair keyPair = keyPairGen.generateKeyPair();

		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		Map<String, Object> keyMap = new HashMap<>(2);

		keyMap.put(PUBLIC_KEY, publicKey);

		keyMap.put(PRIVATE_KEY, privateKey);

		return keyMap;

	}
}