package study007_time;

import java.util.Date;

public class CurrentTime {
	public static void main(String[] args){
		Date date = new Date();
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
//		int mili
		System.out.println(
			"Milliseconds: " + 
			date.getTime());
		System.out.println(
			"TimeStr:      " + 
			year + 
			(month<10?("0"+month):month) + 
			(day<10?("0"+day):day) + 
			(hour<10?("0"+hour):hour) + 
			(minute<10?("0"+minute):minute) + 
			(second<10?("0"+second):second)
		);
		System.out.println(
			"Formated:     "
				);
	}
}
