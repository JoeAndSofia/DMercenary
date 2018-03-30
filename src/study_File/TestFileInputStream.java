package study_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import basic.Basic;

public class TestFileInputStream extends Basic{

	public static void main(String[] args){
		try{
			File f = new File("save/scene/joe.json");
			pl(f.exists());
			FileInputStream is = new FileInputStream(f);
			
		}catch(Exception e){
			pl(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
