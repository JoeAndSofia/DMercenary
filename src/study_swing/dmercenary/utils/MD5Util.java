package study_swing.dmercenary.utils;
import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5(String s){
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

		try{
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			char str[] = new char[md.length*2];
			for(int i=0,k=0;i<md.length;i++){
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
		System.out.println(MD5Util.MD5("password"));
		System.out.println(MD5Util.MD5("1"));
	}
}
