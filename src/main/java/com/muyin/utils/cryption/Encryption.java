package com.muyin.utils.cryption;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.net.URLCodec;

/**
 * 对称加密 
 * 1.方案一:简单对称加密
 * 2.方案二:简单对称加密，变化加密KEY,时间越短越好, 过期KEY 做备KEY
 * (长字符串  短时间变化 简单加密)
 * @author Administrator
 *
 */
public class Encryption{

	private static String password = "2019-01-28 17:41:46.464 INFO  com.muyin.controller.OrderInfoController#doLogin [line:34] - this is a insert for 订单";
	
	public static void main(String[] args) {
		jdkAES();
		
		//testBase64();
	}
	
	/**
	 * AES加密KEY的问题
	 */
	public static void jdkAES() {
		try {
			//1.生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			
			//随机的
			//keyGenerator.init(new SecureRandom());
			
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());
			keyGenerator.init(128, secureRandom);

			SecretKey secretKey = keyGenerator.generateKey();

			byte[] byteKey = secretKey.getEncoded();
 
			//2.转换KEY
			Key key = new SecretKeySpec(byteKey,"AES");
			System.out.println("key:"+key.toString());
			
			//3.加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(password.getBytes());
			System.out.println("加密后：" + Hex.encodeHexString(result));
			
			//4.解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("解密后：" + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testBase64(){
        System.out.println("==========Base64==========");
        //假设密码为123456abc+
        byte[] passwd = password.getBytes();
        Base64 base64 = new Base64();
        //加密
        String enPasswd = base64.encodeAsString(passwd);
        System.out.println("加密后：" + enPasswd);
        //解密
        String dePasswd = new String(base64.decode(enPasswd));
        System.out.println("解密后：" + dePasswd);
    }

	
	public void testURLCodec(){
        System.out.println("==========URLCodec==========");
        URLCodec urlCodec = new URLCodec();
        String data = "陈某某abc+";
        try {
            String encode = urlCodec.encode(data, "UTF-8");
            System.out.println("加密后：" + encode);
            String decode = urlCodec.decode(encode, "UTF-8");
            System.out.println("解密后：" + decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
