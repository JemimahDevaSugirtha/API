package com.runners;


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

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Rest_Api {
	
	@Ignore
	@Test
	private void get_Method() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification given = RestAssured.given();
		
		Response response = given.get("api/users?page=2");
		
		String asString = response.asString();
		
		System.out.println("Response: "+asString);
		
		int statusCode = response.statusCode();
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	private void post_Method() {
		String jsonbody = "{ \"email\" : \"eve.holt@reqres.in\",\"password\" : \"pistol\" }";
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification given = RestAssured.given();
		Response response = given.body(jsonbody).when().post("api/register").then().extract().response();
		
		String asString = response.asString();
		
		System.out.println("Response: "+asString);
		
		int statusCode = response.statusCode();
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, 201);
		
		System.out.println(".");
		
	}
	
	
	@Ignore
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
