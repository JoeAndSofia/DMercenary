package study008_swing.dmercenary.unit.game.entity;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import study008_swing.dmercenary.db.dao.GeneralDao;
import study008_swing.dmercenary.db.entity.PropertySet;

/**
 * entity constant
 * @author Lenovo
 *
 */
public final class EC extends GeneralDao{
	
	public static int count = 0;
	
	//Thing type 
	public static final int MATE = 1;
	
	public static final int ALLY = 10;
	public static final int ALLY01 = 11;
	public static final int ALLY02 = 12;
	public static final int ALLY03 = 13;
	public static final int ALLY04 = 14;
	public static final int ALLY05 = 15;
	public static final int ALLY06 = 16;
	public static final int ALLY07 = 17;
	public static final int ALLY08 = 18;
	
	public static final int ENEMY = 20;
	public static final int ENEMY01 = 21;
	public static final int ENEMY02 = 22;
	public static final int ENEMY03 = 23;
	public static final int ENEMY04 = 24;
	public static final int ENEMY05 = 25;
	public static final int ENEMY06 = 26;
	public static final int ENEMY07 = 27;
	public static final int ENEMY08 = 28;
	
	
	
	
	
	//Property Name
	public static final String PROPERTY_STA = "Stamina";
	public static final String PROPERTY_TAL = "Talent";
	public static final String PROPERTY_MEN = "Mentality";
	public static final String PROPERTY_STR = "Strength";
	public static final String PROPERTY_SAV = "Savvy";
	public static final String PROPERTY_AGI = "Agility";
	public static final String PROPERTY_POT = "Potential";
	public static final String PROPERTY_LUC = "Luck";
	
	//Ability Name
	public static final String ABILITY_HPT = "HitPoint";
	public static final String ABILITY_MPT = "ManaPoint";
	public static final String ABILITY_ENG = "Energy";
	public static final String ABILITY_PAT = "PhysicalAttack";
	public static final String ABILITY_MAT = "MagicAttack";
	public static final String ABILITY_PDF = "PhysicalDefence";
	public static final String ABILITY_MDF = "MagicDefence";
	
	//Property Set
	private static Map<String, PropertySet> PS = new HashMap<String, PropertySet>();

	private EC(){
		try{
			ResultSet rs = dbUtil.select("select * from property_set order by id");
			while(rs.next()){
				PS.put(rs.getString("set_name"), PropertySet.fromDb(rs));
			}
			
//			rs = dbUtil.select(""); 
			count++;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Map ps(){return PS;}
	
	public static PropertySet ps(String setName){
		if(PS!=null && PS.containsKey(setName)){
			return PS.get(setName);
		}else{
			return null;
		}
	}
	
	private static final EC c = new EC();
	
	public static EC getC(){return c;}
}
