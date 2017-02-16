package study005_json_xml.json.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import cc.plural.jsonij.JSON;
import cc.plural.jsonij.marshal.JSONMarshaler;
import cc.plural.jsonij.marshal.JSONMarshalerException;
import cc.plural.jsonij.parser.ParserException;
import study005_json_xml.json.instance.Json;

public class Test07Jsonij_$XR {
	public static void main(String[] args){
//		write();
		read();
	}

	//写入文件正常
	public static void write(){
		Json jsonObjContent = new Json("");

		System.out.println("Convert Java object to JSON format and save to file");

		try(FileWriter writer = new FileWriter("/home/imaginato/wyl/workspace_java/test/data/json/jsonij/jsonij.js")){
			writer.write(JSONMarshaler.marshalObject(jsonObjContent).toJSON());
		} catch (IOException | JSONMarshalerException e) {
			e.printStackTrace();
		}
	}
	
	//不知所谓...
	public static void read(){
		Json jsonObjEmpty = new Json();

		System.out.println("Read JSON from file, convert JSON string back to object");

		try (BufferedReader reader = new BufferedReader(new FileReader("/home/imaginato/wyl/workspace_java/test/data/json/jsonij/jsonij.js"))) {
			JSON json = JSON.parse(reader);
			// Now we need to parse the JSONObject object and put values back
			// to our Json object
			json.getRoot();
			
			for (Field field : jsonObjEmpty.getClass().getDeclaredFields()) {
				try {
					field.setAccessible(true);
					field.set(field.getName(), json.get(field.getName()));
				} catch(IllegalArgumentException|IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParserException e) {
			e.printStackTrace();
		}
	}
}
