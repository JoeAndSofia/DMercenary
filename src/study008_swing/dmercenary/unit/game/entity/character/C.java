package study008_swing.dmercenary.unit.game.entity.character;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import study008_swing.dmercenary.db.dao.Dao;
import study008_swing.dmercenary.db.entity.PropertySet;

public class C extends Dao{
	
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
	public PropertySet VILLAGER;
	public PropertySet MILITIA;
	public PropertySet WITCH;
	public PropertySet WARRIOR;
	public PropertySet WATCHER;
	public PropertySet DOCTOR;
	public PropertySet WIZARD;
//	public static final Integer[] RANK_2_
	public C(){
		try{
			ResultSet rs = dbUtil.select("select * from property_set");
			while(rs.next()){
				switch (rs.getString("set_name")) {
				case "villager"	:VILLAGER	= PropertySet.assign(rs);continue;
				case "militia"	:MILITIA	= PropertySet.assign(rs);continue;
				case "witch"	:WITCH		= PropertySet.assign(rs);continue;
				case "warrior"	:WARRIOR	= PropertySet.assign(rs);continue;
				case "watcher"	:WATCHER	= PropertySet.assign(rs);continue;
				case "doctor"	:DOCTOR		= PropertySet.assign(rs);continue;
				case "wizard"	:WIZARD		= PropertySet.assign(rs);continue;
				default 		:continue;
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
