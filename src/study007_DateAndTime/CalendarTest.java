package study007_DateAndTime;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarTest {
	public static void main(String[] args){
		CalendarTest ct = new CalendarTest();
		Date d = new Date();
		System.out.println(new Date(ct.ms(d)));
		
		ct.gmt();
		ct.gmt8();
		
		Date d2 = new Date(0l);
		ct.d = d2;
		ct.gmt();
		ct.gmt8();
	}
	
	Date d = new Date();
	Calendar c = Calendar.getInstance();
	
	long ms(Date d){
		this.c.setTime(d);
		long ms = c.getTimeInMillis();
		System.out.println(ms);
		return ms;
	}
	
	String gmt(){
		c.setTime(this.d);
		c.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		String year = c.get(Calendar.YEAR)+"";
		String month = c.get(Calendar.MONTH)+"";
		String date = c.get(Calendar.DAY_OF_MONTH)+"";
		String hour = c.get(Calendar.HOUR_OF_DAY)+"";
		String minute = c.get(Calendar.MINUTE)+"";
		String second = c.get(Calendar.SECOND)+"";
		String gmtStr = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		System.out.println(gmtStr);
		return gmtStr;
	}
	
	String gmt8(){
		c.setTime(this.d);
		c.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String year = c.get(Calendar.YEAR)+"";
		String month = c.get(Calendar.MONTH)+"";
		String date = c.get(Calendar.DAY_OF_MONTH)+"";
		String hour = c.get(Calendar.HOUR_OF_DAY)+"";
		String minute = c.get(Calendar.MINUTE)+"";
		String second = c.get(Calendar.SECOND)+"";
		String gmtStr = year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		System.out.println(gmtStr);
		return gmtStr;
	}
	
}
