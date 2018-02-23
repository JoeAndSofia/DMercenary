package study_RegularExpression;

public class EmailRE {
	public static void main(String[] args){
		String email01 = "wylsniper@163.com";
		String email02 = "546051099163.com";
		
		checkAll(email01);
		checkAll(email02);
		
	}
	
	public static boolean check01(String email){
		String regex = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		return email.matches(regex);
	}
	
	public static boolean check02(String email){
		String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return email.matches(regex);
	}
	
	public static boolean check03(String email){
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		return email.matches(regex);
	}
	
	public static boolean check04(String email){
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return email.matches(regex);
	}
	
	public static boolean check05(String email){
		String regex = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
		return email.matches(regex);
	}
	
	public static void checkAll(String email){
		System.out.println(check01(email));
		System.out.println(check02(email));
		System.out.println(check03(email));
		System.out.println(check04(email));
		System.out.println(check05(email));
	}
}
