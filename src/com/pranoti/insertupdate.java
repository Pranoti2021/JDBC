package com.pranoti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class insertupdate {

	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			insertupdate pm=new insertupdate();
			pm.prepstm("Pradnya", "786", "1");
			
	}
	public void prepstm(String  username,String password,String id) {
		try{
			//step 1-Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	       
			//step-3 Prepare the sql querry 
			String mysql="insert into employee1(username,password,id)"+"value(?,?,?)";
			
			//step-4 Prepare the statement
			 PreparedStatement prestm= con.prepareStatement(mysql);  
			 prestm.setString(1, username);
			prestm.setString(2, password);
			prestm.setString(3, id);
			
			//step-5 submit and execute
			prestm.execute();
			System.out.println("Execute successfully");
			//step 6 -close the statement
			prestm.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	}