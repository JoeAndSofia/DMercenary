package study_MathCommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MathCommon {
	private List<People> all;

	private int cbt(People[] participants){
		
		Scanner scan = new Scanner(System.in);
		Map<Integer,Integer> allActions = new HashMap<Integer,Integer>();

		int[] dexs = new int[participants.length];
		Map<Integer,Integer> orders = new HashMap<Integer,Integer>();
		for(int i=0;i<participants.length;i++){
			dexs[i] = participants[i].getAgility();
			orders.put(i,dexs[i]);
		}


		int lcm = leastCommonMultiple(dexs);


		int actionAmount = 0;
		int[] actionArr = null;


		int[] speeds = new int[dexs.length];
		for(int i=0;i<speeds.length;i++){
			speeds[i] = lcm/dexs[i];
		}
		for(int i=0;i<dexs.length;i++){
			actionAmount += dexs[i];
		}
		actionArr = new int[actionAmount];
		for(int i=0,j=0;i<lcm;i++){
			for(int k=0;k<speeds.length;k++){
				if(i%speeds[k]==0){

				}
			}

		}

		return 0;
	}


	public static int leastCommonMultiple(int[] nums){
		if(nums==null || nums.length==0){
			return 0;
		}else if(nums.length==1){
			return nums[0];
		}else{
			int a = nums[0];
			int b = nums[1];
			int r = a;
			int product = a*b;
			if(a<b){
				r=a;
				a=b;
				b=r;
			}
			while(r!=0){
				r=a%b;
				a=b;
				b=r;
			}
			if(nums.length==2){
				return product/a;
			}else{
				int[] nums_new = new int[nums.length - 1];
				System.arraycopy(nums, 1, nums_new, 0, nums.length-1);
				nums_new[0] = product/a;
				return leastCommonMultiple(nums_new);
			}
		}
	}

	public static int greatestCommonDivisor(int[] nums){
		if(nums==null || nums.length==0){
			return 0;
		}else if(nums.length==1){
			return nums[0];
		}else{
			int a = nums[0];
			int b = nums[1];
			int r = a;
			if(a<b){
				r=a;
				a=b;
				b=r;
			}
			while(r!=0){
				r = a%b;
				a=b;
				b=r;
			}
			if(nums.length==2){
				return a;
			}else{
				int[] nums_new = new int[nums.length - 1];
				System.arraycopy(nums, 1, nums_new, 0, nums.length-1);
				nums_new[0] = a;
				return greatestCommonDivisor(nums_new);
			}
		}
	}
	
	public static void test_LCM_GCD(int[] intArr){
		int lcm = leastCommonMultiple(intArr);
		int gcd = greatestCommonDivisor(intArr);
		int product = 1;
		for(int i:intArr){
			product *=i;
		}
		System.out.println(lcm);
		System.out.println(gcd);
		System.out.println(product);
		System.out.println(product/lcm);
	}
	
	public static double logN(double base, double target){
		return Math.log(target)/Math.log(base);
	}
	
	public static List<Integer> inRange(People p, List<People> all){
		if(all == null || all.size() == 0){
			return null;
		}
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<all.size();i++){
			People e = all.get(i);
			double d = Math.sqrt(Math.pow((p.getX() - e.getX()),2) + Math.pow((p.getY() - e.getY()),2));
			if(p.getaRange()>=d){
				result.add(e.getIndex());
			}
			System.out.println(i+", "+e.getIndex()+", "+p.getaRange()+", "+d);
		}		
		return result.size()>0?result:null;		
	}



	public static void main(String[] args){
		int[] intArr = {15,140,75,10};
		test_LCM_GCD(intArr);
		
		
		
//		List<People> list = new ArrayList<People>();
//		People p1 = new People(1,1,1,7.0);
//		People p2 = new People(2,2,1,7.0);
//		People p3 = new People(3,3,1,7.0);
//		People p4 = new People(4,4,1,7.0);
//		People p5 = new People(5,5,1,7.0);
//		People p  = new People(6,3,8,7.0); 
//		list.add(p1);
//		list.add(p2);
//		list.add(p3);
//		list.add(p4);
//		list.add(p5);
//		
//		System.out.println(MathCommon.inRange(p, list));
//		
//		System.out.println(MathCommon.logN(2, 8));
	}	
}

/**
 * EnvironmentConstant
 * @author wyl
 *
 */
class EC{
	/**
	 * ABILITY_MAP
	 */
	public static Map<String, Integer> AM = new HashMap<String, Integer>();
	static{
		AM.put("BASIC_STAMINA",50);
		AM.put("BASIC_STRENGTH",75);
		AM.put("BASIC_INTELLIGENCE",75);
		AM.put("BASIC_AGILITY",50);
		AM.put("BASIC_SPRINT",50);
		AM.put("BASIC_SAVVY",25);
		AM.put("BASIC_LUCK",25);

		AM.put("NORMAL_STAMINA",25);
		AM.put("NORMAL_STRENGTH",25);
		AM.put("NORMAL_INTELLIGENCE",25);
		AM.put("NORMAL_AGILITY",25);
		AM.put("NORMAL_SPRINT",25);
		AM.put("NORMAL_SAVVY",25);
		AM.put("NORMAL_LUCK",10);

		AM.put("ELITE_STAMINA",35);
		AM.put("ELITE_STRENGTH",35);
		AM.put("ELITE_INTELLIGENCE",35);
		AM.put("ELITE_AGILITY",35);
		AM.put("ELITE_SPRINT",35);
		AM.put("ELITE_SAVVY",30);
		AM.put("ELITE_LUCK",13);

		AM.put("GENIUS_STAMINA",45);
		AM.put("GENIUS_STRENGTH",45);
		AM.put("GENIUS_INTELLIGENCE",45);
		AM.put("GENIUS_AGILITY",45);
		AM.put("GENIUS_SPRINT",45);
		AM.put("GENIUS_SAVVY",35);
		AM.put("GENIUS_LUCK",16);		
	}
}


/**
 * People
 * @author wyl
 *
 */
class People{

	private Random r = new Random();
	private int index;
	private double x = 0;
	private double y = 0;
	private int stamina;
	private int strength;
	private int intelligence;
	private int agility;
	private int sprint;
	private int savvy;
	private int luck;
	private double aRange = 10;
	
	public People(){

	}

	public People(String type){
		if(!("NORMAL".equals(type) || "ELITE".equals(type) || "GENIUS".equals(type))){
			type = "NORMAL";
		}
		this.stamina = EC.AM.get("BASIC_STAMINA") + (int)(r.nextDouble()*EC.AM.get(type+"_STAMINA"));
		this.strength = EC.AM.get("BASIC_STRENGTH") + (int)(r.nextDouble()*EC.AM.get(type+"_STRENGTH"));
		this.intelligence = EC.AM.get("BASIC_INTELLIGENCE") + (int)(r.nextDouble()*EC.AM.get(type+"_INTELLIGENCE"));
		this.agility = EC.AM.get("BASIC_AGILITY") + (int)(r.nextDouble()*EC.AM.get(type+"_AGILITY"));
		this.sprint = EC.AM.get("BASIC_SPRINT") + (int)(r.nextDouble()*EC.AM.get(type+"_SPRINT"));
		this.savvy = EC.AM.get("BASIC_SAVVY") + (int)(r.nextDouble()*EC.AM.get(type+"_SAVVY"));
		this.luck = EC.AM.get("BASIC_LUCK") + (int)(r.nextDouble()*EC.AM.get(type+"_LUCK")); 
		
	}
	
	public People(int index, double x, double y, double aRange){
		this.index = index;
		this.x = x;
		this.y = y;
		this.aRange = aRange;
	}
	
	public int getIndex() {
		return index;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getaRange() {
		return aRange;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setaRange(double aRange) {
		this.aRange = aRange;
	}
	
	//
	public int getStamina() {
		return stamina;
	}

	public int getStrength() {
		return strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getAgility() {
		return agility;
	}

	public int getSprint() {
		return sprint;
	}

	public int getSavvy() {
		return savvy;
	}

	public int getLuck() {
		return luck;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public void setSprint(int sprint) {
		this.sprint = sprint;
	}

	public void setSavvy(int savvy) {
		this.savvy = savvy;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}
}
