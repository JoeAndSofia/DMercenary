package study_DateAndTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import basic.Basic;

public class SimpleDateFormatTest extends Basic{
	public static void main(String[] args){
		try{
//			test01();
//			test011();
//			test012();
//			test013();
			
			
			
//			test02();
//			test03();
			
//			testRFC3339();
			
//			testDayMilliseconds();
			
			testGetHourMinute();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public static void test01(){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			
			
			String dateStr01 = "2015-11-25 00:00:00";
			String dateStr02 = "2015-11-25";
			String dateStr03 = "2015-11-25 08:00:00";
			String timeStr01 = "08:00:00";
			Date dateObj01 = sdf.parse(dateStr01);
			
			Date nowObj = new Date();
			String nowStr = sdf.format(nowObj);
			
			long dayMiliSeconds = 24*60*60*1000l;
			
			long sdf_dateStr01 = sdf.parse(dateStr01).getTime();
//			System.out.println(sdf_dateStr01);
			long rest = sdf_dateStr01%dayMiliSeconds;
//			System.out.println(new Date(sdf_dateStr01));
//			System.out.println(rest);
			System.out.println(sdfDate.parse(dateStr02));
			System.out.println(sdfDate.parse(dateStr02).getTime());
//			System.out.println(sdf.parse(dateStr03).getTime());
			System.out.println(sdfTime.parse(timeStr01));
			System.out.println(sdfTime.parse(timeStr01).getTime());
			Calendar c = Calendar.getInstance();
			//对于 08:00:00. 不设置时区, 会默认当前时区, 则时间为8点, 设置了GMT时区, 时间则为Epoch
			//对于 2015-11-25 不设置时区, 则为当前时区的时间, 2015-11-25 00:00:00, 设置GMT时区, 则时间为前一时间的8小时前, 及2015-11-24 16:00:00
			c.setTimeZone(TimeZone.getTimeZone("GMT+0"));	
			c.setTime(sdfTime.parse(timeStr01));
			System.out.println(c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DAY_OF_MONTH)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
			c.setTime(sdfDate.parse(dateStr02));
			System.out.println(c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DAY_OF_MONTH)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
//			System.out.println(sdf.format(sdfTime.parse(timeStr01)));
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public static void test011(){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
			sdfFull.setTimeZone(TimeZone.getTimeZone("GMT+0"));
			String str01 = "01:00:00";
			Date dt01 = sdf.parse(str01);
			System.out.println(sdf.getTimeZone());
			long ms01 = dt01.getTime();
			System.out.println(dt01+", "+ms01);
			long now = new Date().getTime();
			System.out.println(now);
			String str02 = sdfFull.format(new Date(now));
			Date dt02 = sdfFull.parse(str02);
			long dayMs = 24*60*60*1000;
			long hourMs = 60*60*1000;
			long minuteMs = 60*1000;
			long secondMs = 1000;
			System.out.println(now/dayMs+", "+(now%dayMs)/hourMs+", "+((now%dayMs)%hourMs)/minuteMs);
			
		}catch(Exception e){
			
		}finally{
			
		}
	}
	
	public static void test012() throws Exception{
		SimpleDateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdfFull.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		sdfDate.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		sdfTime.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		String str01 = "1970-01-01 00:00:00";
		String str02 = "2015-11-27";
		String str03 = "00:30";
		String str04 = "01:30";
		System.out.println(sdf.format(sdfFull.parse(str01)));
		System.out.println(sdfDate.parse(str02));
		System.out.println(sdfTime.parse(str03));
		System.out.println(sdfTime.parse(str04));
	}
	
	public static void test013() throws Exception{
		DateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat sdfTime = new SimpleDateFormat("HH:mm");
		
		sdfFull.setTimeZone(null);
		sdfDate.setTimeZone(null);
		sdfTime.setTimeZone(null);
		String str01 = "1970-01-01 00:00:00";
		String str02 = "2015-11-27";
		String str03 = "00:30";
		String str04 = "01:30";
		System.out.println(sdfFull.parse(str01));
		System.out.println(sdfDate.parse(str02));
		System.out.println(sdfTime.parse(str03));
		System.out.println(sdfTime.parse(str04));
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
	
	/**
	 * E 星期	: 	3个E或以下, 显示3字母简写weekday; 
	 * 				4个E或以上, 显示完整拼写weekday
	 * 
	 * M 月份	: 	1个M, 显示数字月份, 1月为1, 12月为12; 
	 * 				2个M, 显示数字月份, 1月为01, 12月为12;
	 * 				3个M, 显示3字母简写month;
	 * 				4个M或以上, 显示完整拼写month
	 */
	public static void test03(){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd:HHmmss");
			Date d = new Date(1486004175238l);
			d = sdf.parse("20170222:130404");
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, d MMMM yyyy'T'HH:mm:ss Z");
			SimpleDateFormat sdf2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
			SimpleDateFormat sdf3 = new SimpleDateFormat("EE, d MM yyyy HH:mm:ss Z");
			SimpleDateFormat sdf4 = new SimpleDateFormat("E, d M yyyy HH:mm:ss Z");
			SimpleDateFormat sdf5 = new SimpleDateFormat("EEE, d MMMMM yyyy, H:mm a");
			SimpleDateFormat sdf6 = new SimpleDateFormat("EEE, d MMMMM yyyy, h:mm a");
			
			System.out.println(sdf1.format(d));
			System.out.println(sdf2.format(d));
			System.out.println(sdf3.format(d));
			System.out.println(sdf4.format(d));
			System.out.println(sdf5.format(d));
			System.out.println(sdf6.format(d));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * RFC3339 UTC "Zulu"
	 * 
	 * 
	 */
	public static void testRFC3339(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.'000000000Z'");
		long now = System.currentTimeMillis();
		Date d = new Date(now);
		
		pl("2014-10-02T15:01:23.045123456Z");
		pl(sdf.format(d));
		pl(d);
	}
	
	public static void testDayMilliseconds() throws Exception{
		Calendar c = Calendar.getInstance();
		Date now = new Date();
		c.setTime(now);
		c.add(Calendar.DATE, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		long l = sdf.parse(sdf.format(c.getTime())).getTime();
		pl(l);
		
		String xStr = "2018-04-11,2018-04-11,2018-04-26,2018-04-11,2018-04-14,2018-04-12,2018-04-14,2018-04-11,2018-04-27,2018-04-11";
		String yStr = "1523379600000,1523379600000,1524675600000,1523379600000,1523638800000,1523466000000,1523638800000,1523379600000,1524762000000,1523379600000";
		String[] xArr = xStr.split(",");
		String[] yArr = yStr.split(",");
		for(int i=0;i<xArr.length; i++){
			long lo = sdf.parse(xArr[i]).getTime();
			pl(xArr[i] + "-" + yArr[i] + "-" +  (lo==Long.parseLong(yArr[i])));
		}
		
//		1523379600000
//		1523379600000
	}
	
	public static void testGetHourMinute() throws Exception{
		long start = 1523379600000l;
		long end = 1523638800000l;
		
		String timeZone = "GMT+7";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		
		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone(timeZone));
		for(long millis = start; millis <= end; millis += 1800000l){
			c.setTimeInMillis(millis);
			long dayPart = sdf.parse(sdf.format(new Date(millis))).getTime();
			long restPart = c.get(Calendar.HOUR_OF_DAY) * 3600000l + c.get(Calendar.MINUTE) * 60000l;
			
			p(restPart);pl(millis == (dayPart + restPart));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
