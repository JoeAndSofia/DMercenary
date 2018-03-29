package basic;

public class Basic{
	public static void p(Object o){
		System.out.print(o);
	}
	
	public static void pl(Object o){
		System.out.println(o);
	}
	
	public static long passTime(String bookTimeStr) throws Exception {
		String[] bookTimeStrArray = bookTimeStr.split(":");
		long bookTime = ((Integer.parseInt(bookTimeStrArray[0])*60*60+Integer.parseInt(bookTimeStrArray[1])*60)*1000);
		return bookTime;
	}
}
