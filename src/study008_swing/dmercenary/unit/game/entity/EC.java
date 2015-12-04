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
