package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private Connection conn;
	private Statement stmt;

	public Boolean Query(User user) throws SQLException{
		// TODO Auto-generated method stub
		ResultSet rs = null;
		System.out.println(user.toString());
		rs = stmt.executeQuery("select * from user where account='" + user.getAccount() + "' and password='" + user.getPassword() + "'");
		
		return rs.next();
	}

	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306";
	private static final String sDropDB = "drop database if exists userdb";
	private static final String sCreateDB = "create database userdb";
	private static final String sUseDB = "use userdb";
	private static final String sDropTb = "drop table if exists user";
	private static final String sCreateTb = "create table user (account varchar(20), password varchar(20))";
	private static final String sInsert = "insert into user values('admin', '123456')";
	
	public DBHelper(){
		try{
			//1. ����MySql����
			Class.forName(driverName);
			//2.�����ݿ⽨������
			conn = DriverManager.getConnection(url, "root", "root");
			//3. ��ʼ��sql ������
			stmt = conn.createStatement();
			stmt.execute(sDropDB);   // �������userdb�Ѿ����ھ���ɾ��
			stmt.execute(sCreateDB); // �������ݿ�userdb
			stmt.execute(sUseDB);    // ʹ�����ݿ�
			stmt.execute(sDropTb);   // ���user���Ѿ����ھ���ɾ��
			stmt.execute(sCreateTb); // �������ݿ�user��
			stmt.execute(sInsert);   // ��user�����һ����¼		
		}catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
			
	
}
