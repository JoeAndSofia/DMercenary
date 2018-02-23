package study_swing.fake;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import study_swing.dmercenary.db.entity.PropertySet;
import study_swing.dmercenary.unit.game.entity.EC;

public class TestDb {
	public static void main(String[] args){
		//singleton test, 
		test01();
		test02();
		System.out.println(EC.count);
	}
	
	public static void test01(){
		EC c = EC.getC();
		Map m = c.ps();
		Set<Entry<String, PropertySet>> s = m.entrySet();
		for(Entry e : s){
			System.out.println(e.getKey()+", "+e.getValue());
		}
	}
	
	public static void test02(){
		EC c = EC.getC();
		Map m = c.ps();
		Set<Entry<String, PropertySet>> s = m.entrySet();
		for(Entry e : s){
			System.out.println(e.getKey()+", "+e.getValue());
		}
	}
}
