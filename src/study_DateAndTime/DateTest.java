package study_DateAndTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import basic.Basic;

public class DateTest extends Basic{
	private static final String[] MONTH_STR = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			
	public static void main(String[] args){
//		test001(new Date());
//		test002(new Date());
		
		try{
			testDateTimeForGoogleMapsBooking(1522330200000l);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void test001(Date date){
		System.out.println(date.toGMTString());
		System.out.println(date.toLocaleString());
		System.out.println(date.toString());
		
		System.out.println(date.getYear()+1900);
		System.out.println(date.getMonth());
		System.out.println(date.getDate());
		System.out.println("******");		
		System.out.println(date.getHours());
		System.out.println(date.getMinutes());
		System.out.println(date.getSeconds());
		System.out.println("******");
		System.out.println(date.getDay());
		String y = String.valueOf(date.getYear());
		String d = String.valueOf(date.getDate());
		String M = MONTH_STR[date.getMonth()];
//		String H = String.valueOf(dat)
		
		StringBuilder sb = new StringBuilder(19);
		sb.append(date.getDate()+" ").append(MONTH_STR[date.getMonth()]+" ").append(date.getYear()%100+", ");
	}
	
	public static void test002(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy, hh:mm a");
		String str = sdf.format(d);
		if(str.substring(17).equalsIgnoreCase("pm")){
			str = str.substring(0, 17) + "pm";
		}else{
			str = str.substring(0,17) + "am";
		}
		System.out.println(str);
	}
	
	public static void testDateTimeForGoogleMapsBooking(long startTime) throws Exception{
		String timeZone = "GMT+0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date whichDay = sdf.parse(sdf.format(new Date(startTime)));
		long bookDate = whichDay.getTime();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
		sdf1.setTimeZone(TimeZone.getTimeZone(timeZone));
		long bookTime = passTime(sdf1.format(new Date(startTime)));
		
		pl(bookDate);
		pl(bookTime);
		pl(bookDate + bookTime);
		pl(bookDate + bookTime - startTime);
	}
}
