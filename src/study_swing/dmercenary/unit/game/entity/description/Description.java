package study_swing.dmercenary.unit.game.entity.description;

import javax.swing.Icon;

import study_swing.dmercenary.unit.game.entity.top.GameObject;

public class Description extends GameObject {
	
	protected String description;
	
	public Description(){
		
	}
	
	public Description(String name, Icon image){
		this.name = name;
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
