package study012_CollectionTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args){
//		listTest();
		listToString();
	}
	
	
	
	public static void listTest(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		
		for(String str:list){
			str = "ee";
		}
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++){
			String str = list.get(i);
			if(str.length()>1){
				list.set(i, str.substring(0,1));
			}
		}
		
		System.out.println(list);
	}
	
	public static void listToString(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(13);
		String x = list.toString();
		int y = x.length();
		System.out.println(x + "," + y);
	}
}
