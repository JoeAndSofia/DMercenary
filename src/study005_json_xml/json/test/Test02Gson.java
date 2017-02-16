package study005_json_xml.json.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import study005_json_xml.json.instance.Json;

public class Test02Gson{
	public static void main(String[] args) {
//		write();
		read();
//		write_disableHtmlEscaping();
//		read_disableHtmlEscaping();
	}

	//文件中不存在任何类型解释
	//特殊字符会转换成Ascii码进行存储
	public static void write(){
		Json jsonObjContent = new Json("");
		Gson gson = new Gson();

		System.out.println("Convert Java object to JSON format and save to file");

		try (FileWriter writer = new FileWriter("/home/imaginato/wyl/workspace_java/test/data/json/gson/gson.js")){
			writer.write(gson.toJson(jsonObjContent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//读取正常,所以在构建对象时,根据setter的参数进行转换
	public static void read(){
//		Json jsonObjEmpty = new Json();
		Json jsonObjEmpty = null;
		Gson gson = new Gson();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("/home/imaginato/wyl/workspace_java/test/data/json/gson/gson.js"))){
			jsonObjEmpty = gson.fromJson(reader, Json.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//关闭特殊字符转换为Ascii码
	public static void write_disableHtmlEscaping(){
		Json jsonObjContent = new Json("");
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		
		System.out.println("Convert Java object to JSON format and save to file");

		try (FileWriter writer = new FileWriter("/home/imaginato/wyl/workspace_java/test/data/json/gson/gson2.js")){
			writer.write(gson.toJson(jsonObjContent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//读取正常,所以在构建对象时,根据setter的参数进行转换
	public static void read_disableHtmlEscaping(){
		Json jsonObjEmpty = new Json();
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("/home/imaginato/wyl/workspace_java/test/data/json/gson/gson2.js"))){
			jsonObjEmpty = gson.fromJson(reader, Json.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}











