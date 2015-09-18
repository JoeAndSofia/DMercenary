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
	
	public final static String qravedSha1(String salt, String password){
		return SHA1(salt+SHA1(salt+SHA1(password)));
	}
	
	public static void main(String[] args){
//		System.out.println(SHA1("1"));
		String st_dev = "24c3678f2";
		String st_staging = "e05d07906";
		String pw = "kkndkknd00";
		String hs_dev = qravedSha1(st_dev,pw);
		String hs_staging = qravedSha1(st_staging,pw);
		System.out.println(hs_dev);
		System.out.println(hs_staging);
		
		
//		51e3f9b14f9524e4d84924a7363e54e820e69001
//		51e3f9b14f9524e4d84924a7363e54e820e69001
	}
}
