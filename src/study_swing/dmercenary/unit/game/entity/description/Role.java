package study_swing.dmercenary.unit.game.entity.description;

import java.util.HashMap;
import java.util.Map;

public class Role extends Description {
	
	protected Map<String, Skill> skills = new HashMap<String, Skill>();
	
	public Role(){
		
	}
	
	public Role(String roleName){
		this.description = roleName;
	}
}
