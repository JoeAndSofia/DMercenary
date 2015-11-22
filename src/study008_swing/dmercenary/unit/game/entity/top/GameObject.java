package study008_swing.dmercenary.unit.game.entity.top;

import javax.swing.Icon;

public class GameObject {
	protected String name;
	protected Icon image;
	protected Long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
