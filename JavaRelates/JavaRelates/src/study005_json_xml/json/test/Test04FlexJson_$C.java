package study005_json_xml.json.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import study005_json_xml.json.instance.Json;

public class Test04FlexJson_$C {
	public static void main(String[] args){
//				write();
		read();
	}

	//文件中自动插入class的完全限定名
	public static void write(){
		Json jsonObjContent = new Json("");
		JSONSerializer serializer = new JSONSerializer();

		System.out.println("Convert Java object to JSON format and save to file");

		try(FileWriter writer = new FileWriter("/home/imaginato/wyl/workspace_java/test/data/json/flexjson/flexjson.js")){
			serializer.deepSerialize(jsonObjContent, writer);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	//读取正常,需要class完全限定名进行读取; 没有class限定名时发生异常
	public static void read(){
		Json jsonObjEmpty = new Json();

		System.out.println("Read JSON from file, convert JSON string back to object"); 

		try(BufferedReader reader = new BufferedReader(new FileReader("/home/imaginato/wyl/workspace_java/test/data/json/flexjson/flexjson.js"))){
			jsonObjEmpty = new JSONDeserializer<Json>().deserialize(reader);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
