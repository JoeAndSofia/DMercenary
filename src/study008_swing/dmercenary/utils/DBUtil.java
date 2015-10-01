package study008_swing.dmercenary.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.jdbc3.JDBC3Connection;

public class DBUtil {
	private String databaseName = null;
	private Connection con = null;
	private Statement stmt = null;
	
	public DBUtil(String databaseName){
		this.databaseName = databaseName;
		con();
	}
	
	private void con(){
		try{
			if(con==null || !(con instanceof Connection)){
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:./db/" + this.databaseName + ".db");
			}			
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
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
}
