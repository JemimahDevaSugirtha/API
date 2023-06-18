package com.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DB_Conn {

public static void connect() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tae"); 
		
		//If connection error occurs: https://docs.oracle.com/cd/F49540_01/DOC/java.815/a64685/basic1.htm
		
		//if TNS listener exception occurs: https://stackoverflow.com/questions/10786782/ora-12514-tnslistener-does-not-currently-know-of-service-requested-in-connect-d
		
		Statement stmt = con.createStatement();
		
		ResultSet result = stmt.executeQuery("Select * from jemi order by ID");
		
		//while (result.next())
		while (result.next()) {
			System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getInt(3));
		}
		
		con.close();
	}
}
