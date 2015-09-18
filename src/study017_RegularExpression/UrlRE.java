package study017_RegularExpression;

public class UrlRE {
	public static void main(String[] args){
		String urlStr = "https%3A%2F%2Ffbcdn-profile-a.akamaihd.net%2Fhprofile-ak-xtp1%2Fv%2Ft1.0-1%2Fp200x200%2F11705166_1494305984193723_540891972045591503_n.jpg%3Foh%3D579e74dd863dc9ae60da87151e900696%26oe%3D5683CECA%26__gda__%3D1450634246_f181b940ea492d2125b200ed9eacd32f";
		String url = "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xtp1/v/t1.0-1/p200x200/11705166_1494305984193723_540891972045591503_n.jpg?oh=579e74dd863dc9ae60da87151e900696&oe=5683CECA&__gda__=1450634246_f181b940ea492d2125b200ed9eacd32f";
		String url2 = "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xtp1/v/t1.0-1/p200x200/11705166_1494305984193723_540891972045591503_n.jpg?oh=579e74dd863dc9ae60da87151e900696&oe=5683CECA&__gda__=1450634246_f181b940ea492d2125b200ed9eacd32f";
		System.out.println(url.equals(url2));
		System.out.println(test(url));
		System.out.println(test01(urlStr));
		System.out.println(test01(test(urlStr)));
		System.out.println(test02(urlStr));
		System.out.println(test02(test(urlStr)));
		System.out.println(test03(urlStr));
		System.out.println(test03(test(urlStr)));
	}
	
	public static boolean test01(String urlStr){
		String regex = "^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-"   
		           + "Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{"   
		           + "2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}"   
		           + "[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|"   
		           + "[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-"   
		           + "4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0"   
		           + "-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/"   
		           + "[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*$";
		return urlStr.matches(regex);
	}
	
	public static boolean test02(String urlStr){
		String regex = "^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";
		return urlStr.matches(regex);
	}
	
	public static String test03(String urlStr){
		String regex = "^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$";
		String regex1 = "^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$^[1-9][0-9]{0,3}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]{1}|6553[0-5]$^[a-zA-z]+:\\/\\/(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\:([1-9][0-9]{0,3}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]{1}|6553[0-5]))?(\\/\\w*)*(\\.\\w*)?(\\?\\S*)?$/";
		return urlStr.matches(regex) + ", " + urlStr.matches(regex1);
	}
	
	public static String test(String testStr){
		String result = java.net.URLDecoder.decode(testStr);
		return result;
	}
}
