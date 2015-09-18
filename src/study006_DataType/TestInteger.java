package study006_DataType;

import java.text.DecimalFormat;

public class TestInteger {
	public static long test01(){
		double x = 2134434131901.123190;
		long y = (long)x;
		return y;
	}
	
	public static double test02(){
		double x = 2134434131901.123190;
		return x;
	}
	
	public static void main(String[] args){
		DecimalFormat format = new DecimalFormat("#,###");
		String x = format.format(test01());
		String y = format.format(test02());
		System.out.println(x);
		System.out.println(y);
	}
}
