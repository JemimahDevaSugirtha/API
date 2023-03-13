package com.API_methods;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.pojo.Urls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class Api {
	
	static Urls pojoURL = new Urls();
	
	@Test
	public static void get_Method(String url, int statcode) {
		
		//RestAssured.baseURI = pojoURL.getReqresBaseURI();
		
		RequestSpecification given = RestAssured.given();
		
		Response response = given.get(url); //url hitting
		
		String asString = response.asString();
		
		System.out.println("Response: "+asString);
		
		int statusCode = response.statusCode();
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, statcode); //Actual vs expected
		
	}
	
	@Test
	private void get_Method_Parse() throws IOException, ParseException {
		File f = new File("D:\\Jemi\\Selenium\\eclipse-workspace\\API_Practice\\json files\\Payload.json");
		
		FileReader fr = new FileReader(f);
		
		JSONParser jp = new JSONParser();
		
		Object parse = jp.parse(fr);
		
		JSONObject jo = (JSONObject) parse;
		
		Object obj = jo.get("Tata");
		
		
		String str = obj.toString();
		
		System.out.println(str);
		
		
	}
	
	@Ignore
	@Test
	public static void viewTable(Connection con) throws SQLException{
		String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
		
		try (Statement stmt = con.createStatement()){
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				String coffeeName = rs.getString("COF_NAME");
				int supplierID = rs.getInt("SUP_ID");
				float price = rs.getFloat("PRICE");
				int sales = rs.getInt("SALES");
				int total = rs.getInt("TOTAL");
				
				System.out.println(coffeeName+","+supplierID+","+price+","+sales+","+total);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
}
