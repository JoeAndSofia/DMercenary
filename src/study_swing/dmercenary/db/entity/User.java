package study_swing.dmercenary.db.entity;

import java.util.Map;

import study_swing.dmercenary.db.dao.UserDao;
import study_swing.dmercenary.utils.DBUtil;

public class User {
	int id = 0;
	String name = null;
	String password = null;
	String hint = null;
	int playDuration = 0; 
	
	private static UserDao dao = new UserDao();
	
	
	public User(){
		
	}
	
	public static void close(){
		dao.dbUtil.dis();
	}
	
	public User(String name, String password, String hint){
		this.name = name;
		this.password = password;
		this.hint = hint;
	}
	
	public User get(int id){
		return dao.get(id);
	}
	
	public static Map<Integer, User> getAll(){
		return null;
//		return UserDao.
	}
	
	public boolean save(boolean insert){
		return dao.save(this, insert);
	}
	
	public boolean delete(int id){
		return dao.delete(id);
	}
	
	public int Id() {
		return id;
	}

	public void Id(int id) {
		this.id = id;
	}

	public String Name() {
		return name;
	}

	public void Name(String name) {
		if(name==null && "".equals(name)){
			throw new RuntimeException("User name cannot be null.");
		}
		this.name = name;
	}

	public String Password() {
		return password;
	}

	public void Password(String password) {
		if(password==null && "".equals(password)){
			throw new RuntimeException("Password cannot be null.");
		}
		this.password = password;
	}

	public String Hint() {
		return hint==null?"":hint;
	}

	public void Hint(String hint) {
		this.hint = hint;
	}
	
	public int PlayDuration(){
		return playDuration;
	}
	
	public void PlayDuration(int played){
		this.playDuration += played;
	}
	
	
}
