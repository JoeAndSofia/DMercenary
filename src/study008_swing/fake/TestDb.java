package study008_swing.fake;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import study008_swing.dmercenary.db.entity.PropertySet;
import study008_swing.dmercenary.unit.game.entity.character.C;

public class TestDb {
	public static void main(String[] args){
		//singleton test, 
		test01();
		test02();
		System.out.println(C.count);
	}
	
	public static void test01(){
		C c = C.getC();
		Map m = c.ps();
		Set<Entry<String, PropertySet>> s = m.entrySet();
		for(Entry e : s){
			System.out.println(e.getKey()+", "+e.getValue());
		}
	}
	
	public static void test02(){
		C c = C.getC();
		Map m = c.ps();
		Set<Entry<String, PropertySet>> s = m.entrySet();
		for(Entry e : s){
			System.out.println(e.getKey()+", "+e.getValue());
		}
	}
}
