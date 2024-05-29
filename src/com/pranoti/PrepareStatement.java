package com.pranoti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class PrepareStatement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrepareStatement pm=new PrepareStatement();
		pm.prepstm("Pradnya", "more", "pune");
		
}
public void prepstm(String firstname,String lastname,String city) {
	try{
		//step 1-Load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 Establish connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
       
		//step-3 Prepare the sql querry 
		String mysql="insert into user(firstname,lastname,city)"+"value(?,?,?)";
		
		//step-4 Prepare the statement
		 PreparedStatement prestm= con.prepareStatement(mysql);  
		 prestm.setString(1, firstname);
		prestm.setString(2, lastname);
		prestm.setString(3, city);
		
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