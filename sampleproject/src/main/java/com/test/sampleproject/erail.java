package com.test.sampleproject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class erail extends common_methods {
	
static Xls_Reader excel = new Xls_Reader("C:\\Users\\manju\\OneDrive\\Documents\\SeleniumTraining\\test2.xlsx");
static ExtentReports reports; 
static ExtentTest test;	
public static void main(String[] args) throws IOException, InterruptedException {
	TC1();
}

	public static void TC1() throws IOException, InterruptedException {
		reports = new ExtentReports("C:\\\\Users\\\\manju\\\\OneDrive\\\\Documents\\\\SeleniumTraining\\\\test5.html", true);
		test = reports.startTest("TestName");

		prop();
		chrome();
		url(get_value("URL"));
		ID_Clear(get_value("from"));
		ID_sendkeys(get_value("from"), "sbc");
		Thread.sleep(4000);
		XPATH_Click(get_value("sbc"));
		Thread.sleep(2000);
		ID_Clear(get_value("to"));
		ID_sendkeys(get_value("to"), "bza");
		Thread.sleep(2000);
		XPATH_Click(get_value("bza"));
		Thread.sleep(2000);
		XPATH_Click(get_value("tatkal"));
		Thread.sleep(2000);
		XPATH_Click(get_value("classfilter"));
		Thread.sleep(2000);
		ID_Click(get_value("gettrains"));
	
		
		test.log(LogStatus.PASS,"Test Passed");
		reports.endTest(test);
		reports.flush();
		}
			
	
	
	
}
