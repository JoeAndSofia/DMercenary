package study008_swing.dmercenary.db.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import study008_swing.dmercenary.utils.DBUtil;

public class GeneralDao {
	private static final String DATABASE_NAME = "general";
	public static DBUtil dbUtil = DBUtil.getInstance(DATABASE_NAME);
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void log(Exception e, String className){
		try{
			if(e!=null && className!=null){
				String time = SDF.format(new Date());
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
			this_e.printStackTrace();
			log(this_e, this.getClass().getName());
		}
	}
	
	public void dis(){
		dbUtil.dis();
	}
}
