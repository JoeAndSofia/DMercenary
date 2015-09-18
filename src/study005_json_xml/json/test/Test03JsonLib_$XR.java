package study005_json_xml.json.test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.sf.json.JSONObject;
import study005_json_xml.json.instance.Json;

public class Test03JsonLib_$XR {
	public static void main(String[] args){
//				write();
		read();
	}

	//文件中不存在任何类型解释
	public static void write(){
		Json jsonObjContent = new Json("");
		JSONObject json;

		System.out.println("Convert Java object to JSON format and save to file");

		try(FileWriter writer = new FileWriter("/home/imaginato/wyl/workspace_java/test/data/json/json-lib/json-lib.js")){
			json = JSONObject.fromObject(jsonObjContent);
			json.write(writer);
		}catch(IOException e){
			e.printStackTrace();
		}		
	}

	//读取文件不正确,message(ArrayList)没有内容
	public static void read(){
		Json jsonObjEmpty = new Json();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try(BufferedReader reader = new BufferedReader(new FileReader("/home/imaginato/wyl/workspace_java/test/data/json/json-lib/json-lib.js"))){
			jsonObjEmpty = (Json) JSONObject.toBean(JSONObject.fromObject(reader), Json.class);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
