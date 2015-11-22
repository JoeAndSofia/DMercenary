package study008_swing.dmercenary.unit.game.entity.character;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;

import study008_swing.dmercenary.unit.game.entity.description.Role;
import study008_swing.dmercenary.unit.game.entity.things.Equipment;
import study008_swing.dmercenary.unit.game.entity.things.Pack;
import study008_swing.dmercenary.unit.game.entity.things.Thing;
import study008_swing.dmercenary.unit.game.entity.top.GameObject;

public class Character extends GameObject {
	
	protected Map<String, Role> roles = new HashMap<String, Role>();
	
	protected Map<String, Equipment> equipments = null;
	
	protected Map<Integer, Pack> packs = null;
	
	protected Map<String, Integer> property = new HashMap<String, Integer>();
	
	
	public Character(){
		
	}
	
	public Character(String name, Icon image, Integer[] propertySet){
		this.name = name;
		this.image = image;
		initProperty(propertySet);
	}
	
	private void initProperty(Integer[] propertySet){
		this.property.put(C.PROPERTY_STA, propertySet[0]);
		this.property.put(C.PROPERTY_MEN, propertySet[1]);
		this.property.put(C.PROPERTY_AGI, propertySet[2]);
		this.property.put(C.PROPERTY_STR, propertySet[3]);
		this.property.put(C.PROPERTY_SAV, propertySet[4]);
		this.property.put(C.PROPERTY_TAL, propertySet[5]);
		this.property.put(C.PROPERTY_LUC, propertySet[6]);
		this.property.put(C.PROPERTY_LUC, propertySet[7]);
	}

	public Map<String, Role> getRoles() {
		return roles;
	}
	public Map<String, Equipment> getEquipments() {
		return equipments;
	}
	public Map<Integer, Pack> getThings() {
		return packs;
	}
	public Map<String, Integer> getProperty() {
		return property;
	}

	
	
	
	public void setRoles(Map<String, Role> roles) {this.roles = roles;}
	public void setEquipments(Map<String, Equipment> equipments) {this.equipments = equipments;}
	public void setThings(Map<Integer, Pack> packs) {this.packs = packs;}
	public void setProperty(Map<String, Integer> property) {this.property = property;}	
}























































