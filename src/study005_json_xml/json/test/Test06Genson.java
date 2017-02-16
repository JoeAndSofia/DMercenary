package study005_json_xml.json.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.owlike.genson.Genson;
import com.owlike.genson.TransformationException;

import study005_json_xml.json.instance.Json;

public class Test06Genson {
	public static void main(String[] args){
//		write();
		read();
	}
	
	//文件中不存在任何类型解释
	public static void write(){
		Json jsonObjContent = new Json("");
		Genson genson = new Genson();
		
		System.out.println("Convert Java object to JSON format and save to file");
		
		try (FileWriter writer = new FileWriter("/home/imaginato/wyl/workspace_java/test/data/json/genson/genson.js")) {
			writer.write(genson.serialize(jsonObjContent));
		} catch (IOException | TransformationException e) {
			e.printStackTrace();
		}
	}
	
	//读取正常,所以在构建对象时,根据setter的参数进行转换
	public static void read(){
		Json jsonObjEmpty = new Json();
		Genson genson = new Genson();
		
		System.out.println("Read JSON from file, convert JSON string back to object");
		
		try(BufferedReader reader = new BufferedReader(new FileReader("/home/imaginato/wyl/workspace_java/test/data/json/genson/genson.js"))){
			jsonObjEmpty = genson.deserialize(reader, Json.class);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException | TransformationException e){
			e.printStackTrace();
		}
	}
}
