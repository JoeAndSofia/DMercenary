package study_Encoding;

import java.io.UnsupportedEncodingException;
import java.net.*;

public class EncodingTest {
	public static void main(String[] args){
		String testStr = "https%3A%2F%2Ffbcdn-profile-a.akamaihd.net%2Fhprofile-ak-xtp1%2Fv%2Ft1.0-1%2Fp200x200%2F11705166_1494305984193723_540891972045591503_n.jpg%3Foh%3D579e74dd863dc9ae60da87151e900696%26oe%3D5683CECA%26__gda__%3D1450634246_f181b940ea492d2125b200ed9eacd32f";
		try{
			test01(testStr);
			System.out.println(test02(testStr).equalsIgnoreCase(test03(testStr, "utf8")));
			System.out.println(test04(testStr).equalsIgnoreCase(test05(testStr, "utf8")));
			System.out.println(test05(testStr, "utf8").equalsIgnoreCase(test05(testStr, "utf-8")));
			System.out.println(test05(testStr, "utf8").equalsIgnoreCase(test05(testStr, "utf-8")));
			test05(testStr, "ISO-8859-1");
			System.out.println(testStr);
			test04(testStr);
			System.out.println(test05(testStr, null));
			test06(testStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * fail
	 * @return
	 */
	public static String test01(String testStr){		
		String result = org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4(testStr);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 
	 */
	public static String test02(String testStr){
		String result = URLEncoder.encode(testStr);
		System.out.println(result);
		return result;
	}
	
	public static String test03(String testStr, String enc) throws UnsupportedEncodingException{
		String result = URLEncoder.encode(testStr, enc);
		System.out.println(result);
		return result;
	}
	
	public static String test04(String testStr){
		String result = URLDecoder.decode(testStr);
		System.out.println(result);
		return result;
	}
	
	public static String test05(String testStr, String enc) throws UnsupportedEncodingException{
		String result = URLDecoder.decode(testStr, enc);
		System.out.println(result);
		return result;
	}
	
	public static void test06(String testStr) throws MalformedURLException{
			URL url = new URL(testStr);
			System.out.println("new done");
	}
	
}
