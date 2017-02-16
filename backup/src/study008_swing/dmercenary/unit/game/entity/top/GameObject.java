package study008_swing.dmercenary.unit.game.entity.top;

import javax.swing.Icon;

public class GameObject {
	protected String name;
	protected int type;
	protected Icon image;
	protected Long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Icon getAvatar() {
		return image;
	}
	public void setAvatar(Icon image) {
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
