package study007_DateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentTime {
	//	private static final  

	public static void main(String[] args){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(convertToDate(1451840400000l+64800000l));
			System.out.println(convertToDate(1374664307385l));
			
			System.out.println(sdf2.parse("2015-12-31 10:44:59").getTime());
			System.out.println(sdf2.parse("2015-12-03 22:59:59").getTime());
			System.out.println(sdf.parse("2015-11-01").getTime());	//1446307200000
			sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));
			System.out.println(sdf2.parse("2015-11-01 00:00:00").getTime());
			
			System.out.println("*****************");	//1446307200000
			//		System.out.println(convertToDate(1431459375000l));	//85543 : Wed Jul 15 01:10:45 CST 2015
			System.out.println(convertToDate(1373821200000l));	//85543 : Wed Jul 15 01:10:45 CST 2015
			ctds(39600000);
			ctds(81000000);
			longtime(0);
			System.out.println(new Date().getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static String distinctTime(Date date){
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();

		String timeStr = ""+year + 
				(month<10?("0"+month):month) + 
				(day<10?("0"+day):day) + 
				(hour<10?("0"+hour):hour) + 
				(minute<10?("0"+minute):minute) + 
				(second<10?("0"+second):second);

		System.out.println("Milliseconds: "+date.getTime());
		return timeStr;
	}

	public static Date convertToDate(Long milliseconds){
		Date date = new Date();

		return new Date(milliseconds);
	}

	public static String ctds(Long m){
		double x=0;
		System.out.println(x=((double)m/3600000));
		return x+"";
	}

	public static String ctds(int m){
		double x=0;
		System.out.println(x=((double)m/3600000));
		return x+"";
	} 

	public static void longtime(long ms){
		Date d = new Date();
		d.setTime(ms);
		System.out.println(d.toString());
	}
}
