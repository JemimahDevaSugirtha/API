package com.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature files",glue = "com.step_definition",
		plugin = {"json:Reports/Reqres_json_report.json","html:Reports/Reqres_html_report.html"}, tags = "@db"
		)


public class Reqres_Runner {
	
	
	@BeforeClass
	public static void start() {
		System.out.println("RestAPI Automation Starts");
	}
	
	@AfterClass
	public static void end() {
		System.out.println("RestAPI Automation Ends");
	}
	
}
