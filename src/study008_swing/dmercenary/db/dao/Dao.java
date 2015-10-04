package study008_swing.dmercenary.db.dao;

import java.util.Date;

import study008_swing.dmercenary.utils.DBUtil;

public class Dao {
	private static final String DATABASE_NAME = "general";
	public static DBUtil dbUtil = new DBUtil(DATABASE_NAME);
	
	public void log(Exception e, String className){
		try{
			if(e!=null && className!=null){
				int time = (int)new Date().getTime()/1000;
				String message = e.getMessage();
				Integer result = dbUtil.updateAndInsert(
					"insert into log(time, in_class, exception values("+
					time+",'"+
					className+"','"+
					message+"')"
				);
				if(result!=1){
					log(new RuntimeException("Cannot insert exception message into log"),this.getClass().getName());
				}
			}else{
				throw new Exception();
			}			
		}catch(Exception this_e){
			log(this_e, this.getClass().getName());
		}
	}
	
	public void dis(){
		dbUtil.dis();
	}
}
