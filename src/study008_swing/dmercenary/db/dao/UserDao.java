package study008_swing.dmercenary.db.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import study008_swing.dmercenary.db.entity.User;
import study008_swing.dmercenary.utils.DBUtil;

public class UserDao extends Dao {
	private static final String DATABASE_NAME = "general";
	
	public User get(int id){
		ResultSet rs = null;
		try{
			rs = dbUtil.select("select * from user where id="+id);
			User user = new User();
			while(rs.next()){
				user.Id(rs.getInt("id"));
				user.Name(rs.getString("name"));
				user.Password(rs.getString("password"));
				user.Hint(rs.getString("hint"));
				user.PlayDuration(rs.getInt("play_duration"));
			}
			if(user.Id()==0){
				return null;
			}else{
				return user;
			}
		}catch(Exception e){
			log(e,this.getClass().getName());
			return null;
		}finally{
			try{
				if(rs!=null){
					rs.close();	
				}
			}catch(Exception e){
				throw new RuntimeException("Failed to close ResultSet.");
			}
		}
	}
	
	public Map<Integer, User> getAll(){
		ResultSet rs = null;
		try{
			rs = dbUtil.select("select * from user order by id asc");
			Map<Integer, User> userMap = new HashMap<Integer, User>();
			while(rs.next()){
				User user = new User();
				user.Id(rs.getInt("id"));
				user.Name(rs.getString("name"));
				user.Password(rs.getString("password"));
				user.Hint(rs.getString("hint"));
				user.PlayDuration(rs.getInt("play_duration"));
				userMap.put(user.Id(), user);
			}
			if(userMap.size()>0){
				return userMap;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}catch(Exception e){
				throw new RuntimeException("Failed to close ResultSet.");
			}
		}
	}
	
	public boolean save(User user, boolean insert){
		try{
			if(user!=null && user.Id()==0 && user.Name()!=null && insert){
				Integer result = dbUtil.updateAndInsert(
					"insert into user(name, password, hint, ) values('"+
					user.Name()+"','"+
					user.Password()+"','"+
					user.Hint()+"')"
				);
				return result==0?false:true;
			}else if(user!=null && user.Id()>0 && user.Name()!=null && !insert){
				Integer result = dbUtil.updateAndInsert(
					"update user set name='"+user.Name()+
					"', password='"+user.Password()+
					"', hint='"+user.Hint()+
					"', play_duration="+user.PlayDuration()+
					" where id="+user.Id()
				);
				return result==0?false:true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}finally{
			
		}
	}
	
	public static void main(String[] args){
		User user1 = new User("joey","password","hint");
		User user2 = new User("joy1","adfa","faefaef");
		System.out.println(user2.save(true));
		User.close();
		
//		User user = get(1);
//		System.out.println(1);
	}
}