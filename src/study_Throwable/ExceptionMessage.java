package study_Throwable;

import basic.Basic;

public class ExceptionMessage extends Basic{
	public static void main(String[] args){
		getExceptionMessage();
	}
	
	public static void getExceptionMessage(){
		try{
			Long x = Long.parseLong("s");	
		}catch(Exception e){
			e.printStackTrace();
		}
		pl("________________________________________");
		
		try{
			Long x = Long.parseLong("s");	
		}catch(Exception e){
			pl(e);
			pl(e.getClass().getName());
			pl(e.getMessage());
		}
		
		pl("________________________________________");
		
		try{
			Long x = Long.parseLong("s");	
		}catch(Exception e){
			StackTraceElement[] arr = e.getStackTrace();
			for(StackTraceElement ste : arr){
				pl(ste);
			}
		}
	}
}
