package com.pranoti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Demo {

	public static void main(String[] args) {
	Demo dm=new Demo();
	dm.demo();
		
	}
		
		public void demo() {
			try {
		
			//Step1:Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step2:Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
			//step 3&4- Create the statement
			String sqlQuery ="insert into user(lastname,firstname,city)"+" values('Naiknaware','pranoti','pune')";
					 Statement sta= con.createStatement();
		//step 5 -submit the execute
					// sta.execute(sqlQuery);
					 int executeUpdate = sta.executeUpdate(sqlQuery);
					 System.out.println("Execute Successfully");
		//step 6_ close the resources
					 sta.close();
					 con.close();
			
			}
			
			catch(Exception ex) {
			ex.printStackTrace();
		}
}
}