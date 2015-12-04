package study008_swing.dmercenary.unit.game.entity.character;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;

import study008_swing.dmercenary.unit.game.entity.EC;
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
	
	protected Map<String, Integer> ability = new HashMap<String, Integer>();
	
	public Character(){
		
	}
	
	public Character(String name, Icon image){
		this.name = name;
		this.image = image;
		initProperty();
	}
	
	private void initProperty(){
		this.property.put(EC.PROPERTY_STA, 1);
		this.property.put(EC.PROPERTY_TAL, 1);
		this.property.put(EC.PROPERTY_MEN, 1);
		this.property.put(EC.PROPERTY_STR, 1);
		this.property.put(EC.PROPERTY_SAV, 1);
		this.property.put(EC.PROPERTY_AGI, 1);
		this.property.put(EC.PROPERTY_LUC, 0);
		this.property.put(EC.PROPERTY_LUC, 0);
		
		this.ability.put(EC.ABILITY_HPT, 0);
	}

	public Map<String, Role> getRoles() {
		return roles;
	}
	public Map<String, Equipment> getEquipments() {
		return equipments;
	}
	public Map<Integer, Pack> getPacks() {
		return packs;
	}
	public Map<String, Integer> getProperty() {
		return property;
	}	
	public Map<String, Integer> getAbility() {
		return ability;
	}


	public void setRoles(Map<String, Role> roles) {this.roles = roles;}
	public void setEquipments(Map<String, Equipment> equipments) {this.equipments = equipments;}
	public void setPacks(Map<Integer, Pack> packs) {this.packs = packs;}
	public void setProperty(Map<String, Integer> property) {this.property = property;}
	public void setAbility(Map<String, Integer> ability) {this.ability = ability;}
}























































