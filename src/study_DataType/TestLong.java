package study_DataType;

import java.util.HashSet;
import java.util.Set;

import basic.Basic;

public class TestLong extends Basic{
	public static void main(String[] args){
		test01(10,49);
		pl("_________________________");
		testLongDevide();
		pl("_________________________");
		addToSet();
	}
	
	public static void test01(long param1, long param2){
		pl(param2/param1);
	}
	
	public static void testLongDevide(){
		long a = 1517462096758l;
		long b = 1517462112865l;
		long c = -1;
		long d = -86399999l;
		
		pl((b-a)/86400000l);
		pl(c/86400000l);
		pl(d/86400000l);
		d -= 1;
		pl(d/86400000l);
	}
	
	public static void addToSet(){
		long a = 1517462096758l;
		long b = 1517462112865l;
		long c = -1;
		long d = -86399999l;
		
		Set<Long> longSet = new HashSet<Long>();
		longSet.add(a);
		longSet.add(a);
		longSet.add(b);
		longSet.add(c);
		longSet.add(d);
		
		pl(longSet);
	}
}
