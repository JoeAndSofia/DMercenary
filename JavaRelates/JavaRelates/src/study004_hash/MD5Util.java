package study004_hash;

import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5(String s){
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

		try{
			byte[] btInput = s.getBytes();
			//获得MD5摘要算法的MessageDigest对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			//使用指定的字节更新摘要
			mdInst.update(btInput);
			//获得密文
			byte[] md = mdInst.digest();
			//把密文转换成16进制字符串形式
			int j = md.length;
			char str[] = new char[j*2];
			int k = 0;
			for(int i = 0;i<j;i++){
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>>4&0xf];
				str[k++] = hexDigits[byte0&0xf];
			}
			return new String(str);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
		System.out.println(MD5("kkndkknd00kkndkknd00kkndkknd00"));
		System.out.println(MD5(MD5("kkndkknd00kkndkknd00kkndkknd00")));
		System.out.println(MD5("kkndkknd00kkndkknd00kkndkknd00"));
		System.out.println(MD5("kkndkknd00kkndkknd00kkndkknd01"));
		System.out.println(MD5("加密"));
		System.out.println(MD5("812988018"));
	}
}
