package study_swing.dmercenary.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

//import org.sqlite.jdbc3.JDBC3Connection;

public final class DBUtil {
	private String databaseName = null;
	private Connection con = null;
	private Statement stmt = null;
	
	public static int instanceCount = 0;
	
	private static Map<String, DBUtil> utils = new HashMap<String, DBUtil>();
	
	private DBUtil(String databaseName){
		this.databaseName = databaseName;
		con();
		instanceCount++;
	}
	
	public static DBUtil getInstance(String databaseName){
		if(utils.get(databaseName)!=null){
			return utils.get(databaseName);
		}else{
			DBUtil util = new DBUtil(databaseName);
			utils.put(databaseName, util);
			return util;
		}
	}
	
	public static DBUtil getInstance(String databaseName, boolean createIfNotExisted){
		if(utils.get(databaseName)!=null){
			return utils.get(databaseName);
		}else{
			DBUtil util = new DBUtil(databaseName);
			utils.put(databaseName, util);
			return util;
		}
	
	}
	
	private void con(){
		try{
			if(con==null || !(con instanceof Connection)){
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:./db/" + this.databaseName + ".db");
				System.out.println(this.databaseName+" connected");
			}			
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
	}
	
	private void con(boolean createIfNotExisted){
		
	}
	
	public void dis(){
		try{
			if(con!=null){
				con.close();
			}
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
	}
	
	
	
	public ResultSet select(String query){
		try{
			if(this.databaseName!=null){
				con();
			}else{
				throw new RuntimeException("No database name specified.");
			}
			stmt = con.createStatement();
			if(query==null || "".equals(query)){
				return null;
			}else{
				return stmt.executeQuery(query);
			}
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
	}
	
	public Integer updateAndInsert(String query){
		try{
			if(this.databaseName!=null){
				con();
			}else{
				throw new RuntimeException("No database name specified.");
			}
			stmt = con.createStatement();
			if(query==null || "".equals(query)){
				return null;
			}else{
				return stmt.executeUpdate(query);
			}
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
	}
	
	public Integer delete(String query){
		try{
			if(this.databaseName!=null){
				con();
			}else{
				throw new RuntimeException("No database name specified.");
			}
			stmt = con.createStatement();
			if(query==null || "".equals(query)){
				return null;
			}else{
				return stmt.executeUpdate(query);
			}
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
	}
}
