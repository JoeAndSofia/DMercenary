package study_swing.dmercenary.unit.game.entity.living;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;

import study_swing.dmercenary.unit.game.carrier.Square;
import study_swing.dmercenary.unit.game.entity.EC;
import study_swing.dmercenary.unit.game.entity.description.Role;
import study_swing.dmercenary.unit.game.entity.living.animal.Animal;
import study_swing.dmercenary.unit.game.entity.living.pokemon.Pokemon;
import study_swing.dmercenary.unit.game.entity.things.Equipment;
import study_swing.dmercenary.unit.game.entity.things.Pack;
import study_swing.dmercenary.unit.game.entity.things.Thing;
import study_swing.dmercenary.unit.game.entity.top.GameObject;
import study_swing.dmercenary.unit.game.interphase.SandBox;

public class Character extends GameObject {
	
	protected Square carrier = null;
	
	protected Map<String, Role> roles = new HashMap<String, Role>();
	protected Map<String, Integer> property = new HashMap<String, Integer>();
	protected Map<String, Integer> ability = new HashMap<String, Integer>();
	
	protected Map<String, Equipment> equipments = null;
	protected Map<String, Pack> packs = null;
	protected Map<String, Animal> animals = null;
	protected Map<String, Pokemon> pokemons = null;
	
	protected int level = 0;
	protected Role role = null;
	
	//***************************************************************************
	
	public Character(){
		
	}
	
	public Character(String name, Icon image, int type){
		this.name = name;
		this.type = type;	//
		this.image = image;
		initProperty();
	}
	
	//***************************************************************************
	
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

	//***************************************************************************
	
	public Square getCarrier() {return carrier;}
	
	public Map<String, Role> getRoles() {return roles;}
	public Map<String, Integer> getProperty() {return property;}	
	public Map<String, Integer> getAbility() {return ability;}
	
	public Map<String, Equipment> getEquipments() {return equipments;}
	public Map<String, Pack> getPacks() {return packs;}
	public Map<String, Animal> getAnimals() {return animals;}
	public Map<String, Pokemon> getPokemons() {return pokemons;}

	//***************************************************************************
	
	public void setCarrier(Square carrier) {this.carrier = carrier;}
	
	public void setRoles(Map<String, Role> roles) {this.roles = roles;}
	public void setProperty(Map<String, Integer> property) {this.property = property;}
	public void setAbility(Map<String, Integer> ability) {this.ability = ability;}
	
	public void setEquipments(Map<String, Equipment> equipments) {this.equipments = equipments;}
	public void setPacks(Map<String, Pack> packs) {this.packs = packs;}
	public void setAnimals(Map<String, Animal> animals) {this.animals = animals;}
	public void setPokemons(Map<String, Pokemon> pokemons) {this.pokemons = pokemons;}
	
	//***************************************************************************
	
	public void 装备(Equipment item){
		
	}
	
	public void 放入(Thing thing){
		
	}
	
	public void 认主(Animal animal){
		
	}
	
	public void 捉获(Pokemon pokemon){
		
	}
	
	public void 经验(int exp){
		
	}
	
	public void 进阶(){
		
	}
	
	public void 切换职业(){
		
	}
	
	//***************************************************************************
	
	public static void main(String[] args){
		Character c = new Character();
		c.装备(null);
	}
}























































