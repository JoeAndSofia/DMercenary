package study008_swing.dmercenary.unit;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;

class TestUnit{
	public static void main(String[] args){
		
	}
}

class Unit {
	protected String name;
	protected Icon avatar;
	private Long id;	
}

class Thing extends Unit implements BeThing{
	public Thing(){
		this(null,null);
	}
	
	public Thing(String name, Icon image){
		this.name = name;
		this.avatar = image;
	}

	public void use() {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void inspect() {
		// TODO Auto-generated method stub
		
	}
}

class Equipment extends Thing implements BeEquipment{
	private int duration_max;
	private int duration_now;
	
	
}

class Being extends Unit implements BeBeing, CanWork, CanFight, CanGrow{
	private Map<Integer,Thing> pack = new HashMap<Integer, Thing>();
	
	private int strength = 0;
	private int agility = 0;
	private int intelligence = 0;
	private int spirit = 0;
	private int stamina = 0;
	private int talent = 0;
	private int luck = 0;
	
	private int x = 0;
	private int y = 0;
	private double move_residual = 0.0;
	
	public Being(){
		
	}
	
	public Being(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param tx
	 * @param ty
	 */
	public void move(int tx, int ty) {
		double distance = Math.pow((Math.pow(tx-x,2)+Math.pow(ty-y, 2)),0.5);
		System.out.println(distance);
	}
	
	public void act() {
		// TODO Auto-generated method stub
		
	}
	
	public void equip(Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

	public Equipment unequip() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	public void get(Thing thing) {
		// TODO Auto-generated method stub
		
	}

	public Thing give() {
		return null;
		// TODO Auto-generated method stub
		
	}

	//can work
	public void produce() {
		// TODO Auto-generated method stub
		
	}

	public void process() {
		// TODO Auto-generated method stub
		
	}

	//can fight
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
	public void spell() {
		// TODO Auto-generated method stub
		
	}

	public void levelup() {
		// TODO Auto-generated method stub
		
	}

	public void skill() {
		// TODO Auto-generated method stub
		
	}	
}

interface BeThing{
	public void use();
	
	public void destroy();
	
	public void inspect();
}

interface BeBeing{
	public void move(int x, int y);
	
	public void act();
	
	public void equip(Equipment equipment);
	
	public Equipment unequip();
	
	public void get(Thing thing);
	
	public Thing give();
}

interface BeEquipment{
	
}

interface CanWork{
	public void produce();
	
	public void process();
}

interface CanFight{
	public void attack();
	
	public void spell();
}

interface CanGrow{
	public void levelup();
	
	public void skill();
}


