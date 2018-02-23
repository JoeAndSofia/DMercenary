package study_File;

import java.io.File;

import basic.Basic;

public class TestFile extends Basic{

	public static void main(String[] args){
		try{
			pl(testFileAbsolutePath("/home/imaginato/Desktop/temp/"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String testFileAbsolutePath(String path) throws Exception{
		File file = new File(path);
		pl(file.isDirectory());
		pl(file.isFile());
		return file.getAbsolutePath();
	}
	
}
