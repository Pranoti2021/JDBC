package com.pranoti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Updatedstatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Updatedstatement up=new Updatedstatement();
		
	up.update("saniya","56654" , "1");
}
	public void update(String username,String password,String id) {
		try{
			//step 1-Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	       
			//step-3 Prepare the sql querry 
			String singleupdatequerry="update employee1 set username=? where id=?" ;
		//String multiupdatequerry="update employee1 set username=? ,password =? where id=?";
			
			//step-4 Prepare the statement
			 PreparedStatement prestm= con.prepareStatement(singleupdatequerry); 
			 //PreparedStatement prestm= con.prepareStatement(multiupdatequerry);  
			 prestm.setString(1, username);
			 
			//prestm.setString(2, password);
			prestm.setString(2, id);
			
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
