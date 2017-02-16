package study010_Polymorphism;

public class SuperAndSub {
	public static void main(String[] args){
		SuperClass sc1 = new SubClass();
		System.out.println(sc1.method001("test1"));
		SuperClass sc2 = new SuperClass();
		System.out.println(sc2.method001("test2"));
	}
	
}

interface Supersub{
	String method001(String test);
}

class SuperClass implements Supersub{
	String super_string;
	static int super_count = 0;

	public SuperClass() {
		super_count++;
		System.out.println("create super " + super_count);
	}

	public SuperClass(String super_string) {
		super_count++;
		System.out.println("create super " + super_count);
		this.super_string = super_string;
	}

	public String getSuper_string() {
		return super_string;
	}

	public void setSuper_string(String super_string) {
		this.super_string = super_string;
	}
	
	public String method001(String test){
		return "super"+test;
	}
	
}

class SubClass extends SuperClass implements Supersub{
	String sub_string;
	static int sub_count = 0;

	public SubClass() {
		sub_count++;
		System.out.println("create sub " + sub_count);
	}

	public SubClass(String sub_string) {
		sub_count++;
		System.out.println("create sub " + sub_count);
		this.sub_string = sub_string;
	}

	public String getSub_string() {
		return sub_string;
	}

	public void setSub_string(String sub_string) {
		this.sub_string = sub_string;
	}
	
	public String method001(String test){
		return "sub"+test;
	}
	
}
