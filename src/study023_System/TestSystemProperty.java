package study023_System;

import java.util.Properties;
import java.util.Set;

import basic.Basic;

public class TestSystemProperty extends Basic{
	public static void main(String[] args){
		test01();
	}
	
	public static void test01(){
		Properties p = System.getProperties();
		
		Set<Object> keys = p.keySet();
		for(Object key_ : keys){
			String key = (String)key_;
			pl(key + ": " + p.getProperty(key.toString()));
		}
	}
}
