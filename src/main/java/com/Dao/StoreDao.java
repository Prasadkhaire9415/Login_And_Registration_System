package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Login;

public class StoreDao  {
	public static Connection getConnection()throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","9415");
        return con;
	}
	public static int insert(Login l) {
		int status=0;
		try {
			Connection con=getConnection();
			String sql="insert into login(name,mobile,email,address,password)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,l.getName());
			ps.setString(2,l.getMobile());
			ps.setString(3,l.getEmail());
			ps.setString(4,l.getAddress());
			ps.setString(5,l.getPassword());
			status=ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.print(status);
		return status;
		
	}
	public static int search(String name) {
		int status=0;
		try {
			Connection con=getConnection();
			String sql="select * from login where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("name").equals(name)) {
					status++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public static int searchpass(String name,String password) {
		int status=0;
		try {
			Connection con=getConnection();
			String sql="select * from login where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					status++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
