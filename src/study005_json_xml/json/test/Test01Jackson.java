package study005_json_xml.json.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import study005_json_xml.json.instance.Json;



public class Test01Jackson {
	public static void main(String[] args) {
//		write();
		read();
	}
	
	//文件中不存在任何类型解释
	public static void write(){
		Json jsonObjContent = new Json("");
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("Convert Java object to JSON format and save to file");
		try{
			mapper.writeValue(new File("/home/imaginato/wyl/workspace_java/test/data/json/jackson/jackson.js"), jsonObjContent);
		}catch(JsonGenerationException e){
			e.printStackTrace();
		}catch(JsonMappingException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//读取正常,所以在构建对象时,根据setter的参数进行转换
	public static void read(){
		Json jsonObjEmpty = new Json();
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("Read JSON from file, convert JSON back to object");
		try{
			jsonObjEmpty = mapper.readValue(new File("/home/imaginato/wyl/workspace_java/test/data/json/jackson/jackson.js"), Json.class);
		}catch(JsonGenerationException e){
			e.printStackTrace();
		}catch(JsonMappingException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
