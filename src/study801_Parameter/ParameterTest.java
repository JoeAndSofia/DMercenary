package study801_Parameter;

public class ParameterTest {
	
	/**
	 * for the passed-in parameter, can it be changed?
	 */
	public static void test001_primitive(int x){
		System.out.println(++x);
	}
	
	public static void test002_wrapper(Integer y){
		y++;
		System.out.println(y);
	}
	
	public static void test003_wrapper_trulyChange(Integer z){
		z = new Integer(21);
		System.out.println(z);
	}
	
	public static void test004_string(String s){
		System.out.println(s);
		s = s.substring(3);
	}
	
	public static void test005_object(StringBuffer sb){
		System.out.println(sb.append(" was been trying to be modified."));
	}
	
	public static void test006_instance(TestObject to){
		System.out.println(to.toString());
		to.setA(97);
		to.setB(98);
		to.setStr("string");
		to.setI(105);
	}
	
	public static void main(String[] args){
		int x = 10;
		Integer y = 20;
		Integer z = 20;
		String s = "String";
		StringBuffer sb = new StringBuffer("string");
		TestObject to = new TestObject();
		
		test001_primitive(x);
		test002_wrapper(y);
		test003_wrapper_trulyChange(z);
		test004_string(s);
		test005_object(sb);
		test006_instance(to);
		
		System.out.println();
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(s);
		System.out.println(sb);
		System.out.println(to);
		
	}
}

class TestObject{
	private int a;
	private int b;
	private String str;
	private Integer i;
	
	TestObject(){
		this.a = 1;
		this.b = 2;
		this.str = "str";
		this.i = 9;
	}
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public String getStr() {
		return str;
	}
	public Integer getI() {
		return i;
	}
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	
	public String toString(){
		return "[a="+this.a+", b="+this.b+", str=\""+this.str+"\", i="+this.i+"]";
	}
}
