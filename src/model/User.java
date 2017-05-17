package model;

import java.sql.SQLException;

public class User {
	private String account;
	private String password;
	
	public User(String account, String password){
		this.account = account;
		this.password = password;
	}

	public String getAccount(){
		return account;
	}
	
	public String getPassword(){
		return password;
	}
	
	public Boolean isExist() throws SQLException{
		//User user = new User(account, password);
		
		DBHelper db = new DBHelper();
		return db.Query(this);
	}
	
	public String toString(){
		return "accout : " + account + "; password : " + password;
	}
}
