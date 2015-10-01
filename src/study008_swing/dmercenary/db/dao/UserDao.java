package study008_swing.dmercenary.db.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import study008_swing.dmercenary.db.entity.User;
import study008_swing.dmercenary.utils.DBUtil;

public class UserDao {
	private static final String DATABASE_NAME = "general";
	public DBUtil util = new DBUtil(DATABASE_NAME);
	
	public User get(int id){
		ResultSet rs = null;
		try{
			rs = util.select("select * from user where id="+id);
			User user = new User();
			while(rs.next()){
				user.Id(rs.getInt("id"));
				user.Name(rs.getString("name"));
				user.Password(rs.getString("password"));
				user.Hint(rs.getString("hint"));
			}
			if(user.Id()==0){
				return null;
			}else{
				return user;
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
	
	public Map<Integer, User> getAll(){
		ResultSet rs = null;
		try{
			rs = util.select("select * from user order by id asc");
			Map<Integer, User> userMap = new HashMap<Integer, User>();
			while(rs.next()){
				User user = new User();
				user.Id(rs.getInt("id"));
				user.Name(rs.getString("name"));
				user.Password(rs.getString("password"));
				user.Hint(rs.getString("hint"));
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
	
	public boolean save(User user){
		try{
			if(user!=null && user.Id()==0 && user.Name()!=null){
				Integer result = util.updateAndInsert(
					"insert into user(name, password, hint) values('"+
					user.Name()+"','"+
					user.Password()+"','"+
					user.Hint()+"')"
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
		System.out.println(user2.save());
		User.close();
		
//		User user = get(1);
//		System.out.println(1);
	}
}