package study007_DateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SimpleDateFormatTest {
	public static void main(String[] args){

		test02();
		
		
	}
	
	public static void test01(){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			
			String dateStr01 = "2015-06-05 12:27:15";
			Date dateObj01 = sdf.parse(dateStr01);
			
			Date nowObj = new Date();
			String nowStr = sdf.format(nowObj);
			
			
			System.out.println(dateObj01);
			System.out.print(nowStr);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void test02(){
		try{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = sdf1.parse("2014-08-23T09:20:05Z");
			System.out.println(sdf1.getTimeZone().toString());
			sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.out.println(sdf1.getTimeZone().toString());
			Date d3 = sdf1.parse("2014-08-23T09:20:05Z");
			
			Date d2 = sdf2.parse("2014-08-23 09:20:05");
			
			
			System.out.println("2014-08-23T09:20:05Z" + " , " + d1.toString() + " , "+sdf1.format(d1));
			System.out.println("2014-08-23T09:20:05Z" + " , " + d3.toString() + " , "+sdf1.format(d3));
			
			System.out.println("2014-08-23 09:20:05" + " , " + d2.toString() + " , "+sdf2.format(d2));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
}
