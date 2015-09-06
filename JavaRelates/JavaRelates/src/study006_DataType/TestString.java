package study006_DataType;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class TestString {
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
		StringUtils.trim(param);
	}
	
	public static void main(String[] args){
		
//		System.out.println(testTransferString());
//		System.out.println(testTransferString());
//		System.out.println(testTransferString());
//		System.out.println(testTransferString());
//		testStringArr();
		testNullString();
	}
}
