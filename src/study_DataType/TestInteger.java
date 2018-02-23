package study_DataType;

import java.text.DecimalFormat;
import basic.Basic;

public class TestInteger extends Basic{
	public static long test01(){
		double x = 2134434131901.123190;
		long y = (long)x;
		return y;
	}
	
	public static double test02(){
		double x = 2134434131901.123190;
		return x;
	}
	
	public static String concat(){
		Integer i = Integer.valueOf(5);
		return "flaefale"+i;
	}
	
	public static Long longValueObj(){
		Integer i = Integer.valueOf(189159);
		return i.longValue();
	}
	
	public static long longValuePrim(){
		Integer i = Integer.valueOf(189159);
		return (long)i;		
	}
	
	public static void main(String[] args){
		DecimalFormat format = new DecimalFormat("#,###");
		String x = format.format(test01());
		String y = format.format(test02());
		System.out.println(x);
		System.out.println(y);
		System.out.println(concat());
		pl(longValueObj());
		pl(longValuePrim());
	}
}
