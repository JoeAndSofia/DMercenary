package study_DataType;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import basic.Basic;

public class TestString extends Basic{
	public static String testTransferString(){
		Scanner s = new Scanner(System.in);
		System.out.println("input string");
		String receive = s.next();
		return receive;		
	}
	
	public static void testStringArr(){
		String str = "x,y,,";
		String[] arr1 = str.split(",",-1);
		System.out.println(arr1.length);
		System.out.println(Arrays.toString(arr1));
		str +=",";
		String[] arr2 = str.split(",",-1);
		System.out.println(arr2.length);
		System.out.println(Arrays.toString(arr2));
	}
	
	public static void testNullString(){
		Long l = null;
		System.out.println("abc"+"_"+l);
	}
	
	public static void testStringUtils(String param){
		String x = param.trim();
		pl(x);
		pl(StringUtils.trim(param));
	}
	
	public static double testEquals(String param){
		return param==""?0:Double.parseDouble(param);
	}
	
	public static String[] testStringSplitLimit(String param){
		String[] arr = param.split(",");
		pl(arr.length);
		return arr;
	}
	
	public static String[] testStringSplitAll(String param){
		String[] arr = param.split(",",-1);
		pl(arr.length);
		return arr;
	}
	
	public static String testSubstring(String param){
		return param.substring(0, 1).toUpperCase() + param.substring(1, param.length()).toLowerCase();				
	}
	
	public static String testTrim(String param){
		return param.trim();
	}
	
	public static void testChar(String testStr){
		for(int i=0; i<testStr.length(); i++){
			char c = testStr.charAt(i);
			boolean in = c>=48&&c<=54;
			System.out.println(testStr.charAt(i)+0+", "+in);
			
		}
	}
	
	public static void testCompare(String testStr, String testStr2){
		pl(testStr.compareTo(testStr2));
	}
	
	public static void main(String[] args){
		testStringUtils("faejfla afawf");
//		System.out.println(testTransferString());
//		System.out.println(testTransferString());
//		System.out.println(testTransferString());
//		System.out.println(testTransferString());
//		testStringArr();
//		testNullString();
//		System.out.println(testEquals("a"));
//		System.out.println(testStringSplitAll("faef,felrkf,fER,,").length);
//		System.out.println(Arrays.toString(testStringSplitAll("faef,felrkf,fER,,")));
//		System.out.println(testStringSplitAll("faef,felrkf,fER,,")[4].length());
//		System.out.println("".equals(testStringSplitAll("faef,felrkf,fER,,")[3]));
//		System.out.println(testStringSplitLimit("faef,felrkf,fER,,").length);
//		System.out.println(Arrays.toString(testStringSplitLimit("faef,felrkf,fER,,")));
//		testChar("abcdefghijklmnopqrstuvwxyz1234567890");
//		System.out.println(testSubstring("feeraGEFSAFfe"));
//		pl(testStringSplitLimit("大秦铁路,7.070,7.090,7.150,7.170,7.030,7.140,7.150,49446508,352277073.000,323300,7.140,362100,7.130,368600,7.120,61600,7.110,194200,7.100,69200,7.150,525000,7.160,1756823,7.170,1248200,7.180,1389803,7.190,2017-03-24,15:00:00,00"));
//		testCompare("3.0.6","3.0.6.0");
//		testCompare("3.0.6.","3.0.6.0");
//		testCompare("3.0.7.","3.0.6.0");
//		testCompare("3.0.7.","3.0.6.9");
//		testCompare("3.0.7","3.0.7.0");
//		testCompare("3.0.7","3.0.7");
//		testCompare("3.0.7","3.0.6.0");
		
		
//		stringNull();
	}
	
	public static void stringNull(){
		System.out.println("1"+null);
	}
	
}
