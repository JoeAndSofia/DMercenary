package study005_json_xml.json.instance;

import java.util.ArrayList;
import java.util.List;

public class Json{

	private int age = 52;
	private String name = "Jim Carrey";
	private JsonFirstObject jsnFO = new JsonFirstObject();
	private List<String> messages;
	
	public Json(){
		
	}
	
	public Json(String type){
		this.jsnFO = new JsonFirstObject("");
		
		this.messages = new ArrayList<String>(){{
			add("Hey, maybe I will give you..");
			add("Excuse me, I'd like to..");
			add("Brain freeze. Alrighty Then I just..");
		}};
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public JsonFirstObject getJsnFO() {
		return jsnFO;
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

	public void setJsnFO(JsonFirstObject jsnFO) {
		this.jsnFO = jsnFO;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
