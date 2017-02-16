package study007_DateAndTime;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
	public static void main(String[] args){
		Date d = new Date();
		System.out.println(d);
		System.out.println(changeDateTimeZone(d,Calendar.getInstance().getTimeZone(),TimeZone.getTimeZone("Europe/London")));
	}
	
	public static void test01(){
		Calendar cal = Calendar.getInstance();
		
		TimeZone tz_gmt = TimeZone.getTimeZone("Europe/London");
		TimeZone tz_this = cal.getTimeZone();
		
		System.out.println(tz_gmt.getID());
		System.out.println(tz_this.getID());
		
		int offset = tz_gmt.getRawOffset()-tz_this.getRawOffset();
		System.out.println(offset);
		
		Date d1 = new Date();
		System.out.println(d1.getTime());
		System.out.println(d1.toString());
		
		System.out.println(offset*1000l);
		
		Date d2 = new Date(d1.getTime()+(offset*1000l));
		System.out.println(d2);
		System.out.println(d2.toString());
		
				
	}
	
	public static Date changeDateTimeZone(Date d, TimeZone current, TimeZone target){
		return new Date(d.getTime() + target.getRawOffset() - current.getRawOffset());
	}
	
}
