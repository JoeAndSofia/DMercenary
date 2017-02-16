package study013_NumberFormat;

import java.text.DecimalFormat;

public class DecimalFormatTest {
	public static String test01(long num){
		String patternStr = "0000000000000";
		DecimalFormat df = new DecimalFormat(patternStr);
		return df.format(num);
	}
	
	public static void main(String[] args){
		System.out.println(test01(100));
	}
}
