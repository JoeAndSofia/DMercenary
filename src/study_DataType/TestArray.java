package study_DataType;

import basic.Basic;

public class TestArray extends Basic{
	public static void main(String[] args){
		arrayClassName();
	}
	
	static void arrayClassName(){
		String[] strArr = new String[]{};
		
		pl(strArr.getClass().getName());
	}
}
