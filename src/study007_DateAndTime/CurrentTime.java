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
			System.out.println(convertToDate(1448784000000l));
			System.out.println(convertToDate(1448790638589l));
			System.out.println(sdf.parse("2015-10-01").getTime());	//1443628800000
			System.out.println(sdf.parse("2015-10-04").getTime());	//1443888000000
			System.out.println(sdf.parse("2015-10-07").getTime());	//1444147200000
			System.out.println(sdf.parse("2015-10-10").getTime());	//1444406400000
			System.out.println(sdf.parse("2015-10-13").getTime());	//1444665600000
			System.out.println(sdf.parse("2015-10-16").getTime());	//1444924800000
			System.out.println(sdf.parse("2015-10-19").getTime());	//1445184000000
			System.out.println(sdf.parse("2015-10-22").getTime());	//1445443200000
			System.out.println(sdf.parse("2015-10-25").getTime());	//1445702400000
			System.out.println(sdf.parse("2015-10-28").getTime());	//1445961600000
			System.out.println(sdf.parse("2015-11-01").getTime());	//1446307200000
			System.out.println(sdf2.parse("2015-12-03 23:59:59").getTime());
			System.out.println(sdf2.parse("2015-12-03 22:59:59").getTime());
			sdf2.setTimeZone(TimeZone.getTimeZone("GMT+7"));
			System.out.println(sdf2.parse("2015-12-03 23:59:59").getTime());
			System.out.println(sdf2.parse("2015-12-01 00:00:00").getTime());
			System.out.println(sdf2.parse("2015-12-02 23:59:59").getTime());
			
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
