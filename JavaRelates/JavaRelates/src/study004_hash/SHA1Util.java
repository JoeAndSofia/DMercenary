package study004_hash;

import java.security.MessageDigest;

public class SHA1Util {
	public final static String SHA1(String s){
		
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(s.getBytes("UTF-8"));
			byte[] result = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b:result){
				int i=b&0xff;
				if(i<0xf){
					sb.append(0);
				}
				sb.append(Integer.toHexString(i));
			}
			return sb.toString();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	
	public static void main(String[] args){
		System.out.println(SHA1("1"));
		System.out.println(SHA1("2"));
		System.out.println(SHA1("3"));
		System.out.println(SHA1("4"));
		System.out.println(SHA1("5"));
		System.out.println(SHA1("6"));
		System.out.println(SHA1("7"));
		System.out.println(SHA1("8"));
		System.out.println(SHA1("9"));
		System.out.println(SHA1("10"));
	}
}
