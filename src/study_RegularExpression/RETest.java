package study_RegularExpression;

public class RETest {
	public static void main(String[] args){
//		p(t01("abc"));
//		p(t01("abcabc"));
//		p(t02("ajdlfaef"));
//		p(t02("489019348"));
//		p(t03("falfanlef"));
//		p(t03("814905834"));
//		p(t03("290423-24891"));
//		p(t04("falfanlef"));
//		p(t04("814905834"));
//		p(t04("290423-24891"));
		p(t05("012"));
		p(t05("23a"));
		p(t05("ava"));
		p(t05("av2faewrfa"));
		p(t05("23"));
		p(t05(""));
		p("***********");
		p(t06("012"));
		p(t06("23a"));
		p(t06("ava"));
		p(t06("av2faewrfa"));
		p(t06("23"));
		p(t06(""));
		p("***********");
		p(t07("012"));
		p(t07("23a"));
		p(t07("ava"));
		p(t07("av2faewrfa"));
		p(t07("23"));
		p(t07(""));
		p("***********");
		p(t08("012"));
		p(t08("23a"));
		p(t08("ava"));
		p(t08("av2faewrfa"));
		p(t08("23"));
		p(t08(""));
		p("***********");
		p(t09("The US population is 2719827398444215 which is growing."));
	}
	
	
	static boolean t01(String p){
		String regex="^abc$";
		return p.matches(regex);
	}
	
	static boolean t02(String p){
		String regex="\\w+";
		return p.matches(regex);
	}
	
	static boolean t03(String p){
		String regex="[0-9]+";
		return p.matches(regex);
	}
	
	static boolean t04(String p){
		String regex="[0-9]+-?[0-9]+";
		return p.matches(regex);
	}
	
	static boolean t05(String p){
		String regex="^.{3}$";
		return p.matches(regex);
	}
	
	static boolean t06(String p){
		String regex=".{3}";
		return p.matches(regex);
	}
	
	static boolean t07(String p){
		String regex=".+.{3}";
		return p.matches(regex);
	}
	
	static boolean t08(String p){
		String regex=".*.{3}";
		return p.matches(regex);
	}
	
	static String t09(String p){
//		String regex="(?<=\\d{1,3})(?=(?:\\d\\d\\d)+)";
		String regex="(?<=\\d)(?=(?:\\d\\d\\d)+)";
		return p.replaceAll(regex,",");
	}
	
	static void p(Object o){
		System.out.println(o);
	}
}

