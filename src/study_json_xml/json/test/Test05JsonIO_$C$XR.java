package study_json_xml.json.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

import study_json_xml.json.instance.Json;

public class Test05JsonIO_$C$XR {
	public static void main(String[] args){
//		write();
		read();
	}
	
	//文件中自动插入 @type 字段,为class的完全限定名
	public static void write(){
		Json jsonObj = new Json("");
		
		System.out.println("Convert Java object to JSON format and save to file");
		 
		try(JsonWriter writer = new JsonWriter(new FileOutputStream("/home/imaginato/wyl/workspace_java/test/data/json/json-io/json-io.js"))){
			writer.write(jsonObj);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//读取数据不正确,message内容重复读取一遍
	public static void read(){
		Json jsonObj = new Json();
		
		System.out.println("Read JSON from file, convert JSON string back to object");
		 
		try(JsonReader reader = new JsonReader(new FileInputStream(new File("/home/imaginato/wyl/workspace_java/test/data/json/json-io/json-io.js")))){
			jsonObj = (Json) reader.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
