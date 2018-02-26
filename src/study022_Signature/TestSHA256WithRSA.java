package study022_Signature;

import java.security.Signature;

import basic.Basic;
import sun.security.rsa.RSASignature.SHA256withRSA;

public class TestSHA256WithRSA extends Basic{
	
	private static final String ENCODING = "UTF-8";
	private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
	
	public static void main(String[] args){
		try{
			test000(args[0]);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String test000(String param)throws Exception{
		String result = new String(SignUtil.sign256(param, null));
		
		return result;
	}
}
