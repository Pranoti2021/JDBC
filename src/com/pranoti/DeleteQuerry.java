package com.pranoti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class DeleteQuerry {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteQuerry up=new DeleteQuerry();
		
	up.delete("2");
}
	public void delete(String id) {
		try{
			//step 1-Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	       
			//step-3 Prepare the sql querry 
			String deletequerry="delete from employee1 where id=?" ;
		
			//step-4 Prepare the statement
			 PreparedStatement prestm= con.prepareStatement(deletequerry); 
			 
			prestm.setString(1, id);
			
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


