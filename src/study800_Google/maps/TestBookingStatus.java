package study800_Google.maps;

import basic.Basic;
import study_Google.maps.BookingStatus;

public class TestBookingStatus extends Basic{
	
	public static void main(String[] args){
		test000();
	}
	
	public static void test000(){
		BookingStatus[] statusArr = BookingStatus.values();
		for(BookingStatus b : statusArr){
			pl(b.ordinal());
			pl(b.toString());
		}
	}
}
