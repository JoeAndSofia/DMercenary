package study_json_xml.json.instance;

import java.util.ArrayList;
import java.util.List;

public class JsonSecondObject {

	private int age = 83;
	private String name = "Clint Eastwood";
	private JsonThirdObject jsnTO = new JsonThirdObject();
	private List<String> messages;
	
	public JsonSecondObject(){

	}
	
	public JsonSecondObject(String type){
		this.jsnTO = new JsonThirdObject("");
		
		this.messages = new ArrayList<String>(){{
			add("This is the AK-47 assault..");
			add("Are you feeling lucky..");
			add("When a naked man's chasing a..");
		}};
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public JsonThirdObject getJsnTO() {
		return jsnTO;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJsnTO(JsonThirdObject jsnTO) {
		this.jsnTO = jsnTO;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
