package com.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.Base.WebPageUtilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature files",glue = "com.step_definition",
		plugin = {"json:Reports/Adactin_json_report.json","html:Reports/Adactin_html_report.html"}, tags = "@test3"
		)


public class Adactin_Runner extends WebPageUtilities{
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void start() {
		driver = launchBrowser("chrome");	
	}
	
	@AfterClass
	public static void end() {
		quit();		
	}
	
}
