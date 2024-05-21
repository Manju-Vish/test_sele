package com.test.sampleproject;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common_methods {
	static WebDriver driver;
	static WebElement ele;
		static Properties prop = new Properties();
	
	@SuppressWarnings("deprecation")
	public static void chrome() {
		
		   ChromeOptions options = new ChromeOptions();
	         options.addArguments("--remote-allow-origins=*");
	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\manju\\OneDrive\\Documents\\SeleniumTraining\\libs\\chromedriver-win32\\chromedriver.exe");
	         driver = new ChromeDriver(options);
	         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	public static void prop() throws IOException {
		FileInputStream file =new FileInputStream("C:\\Users\\manju\\eclipse-workspace\\SeleniumDays\\src\\erail.properties");         
		prop.load(file);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void url(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	public static String get_value(String value) {
		return prop.getProperty(value);
	}
	
	public static void ID_Click(String value) {
		
		driver.findElement(By.id(value)).click();
		
	}
	
	
public static void ID_Clear(String value) {
		
		driver.findElement(By.id(value)).clear();
		
	}
	
public static void ID_sendkeys(String value,String text) {
		
		driver.findElement(By.id(value)).sendKeys(text);;
		
	}
	

public static String ID_gettext(String value) {
	
	return driver.findElement(By.id(value)).getText();
	
}



public static void XPATH_Click(String value) {
	
	driver.findElement(By.xpath(value)).click();
	
}


public static void XPATH_sendkeys(String value,String text) {
	
	driver.findElement(By.xpath(value)).sendKeys(text);;
	
}


public static String XPATH_gettext(String value) {

return driver.findElement(By.xpath(value)).getText();

}

public static void linktext_Click(String value) {
	
	driver.findElement(By.linkText(value)).click();
	
}



public static void Xpath_select(String value,String selection) {
	
	
	 Select objSelect =new Select(driver.findElement(By.xpath(value)));
	 objSelect.selectByValue(selection);
	
}

public static void ID_select(String value,String selection) {
	
	
	 Select objSelect =new Select(driver.findElement(By.id(value)));
	 objSelect.selectByValue(selection);
	
}


public static void Mouseover_xpath(String value) {
	
	 ele = driver.findElement(By.xpath(value));
	 Actions action = new Actions(driver);
	 action.moveToElement(ele).perform();
	
}

public static void wait(String Value) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Value)));
     driver.findElement(By.xpath(Value)).click();
	
}

public static void fluent_wait(String Value) {
	
	Wait<WebDriver> wait =
	        new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(ElementNotInteractableException.class);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Value)));
}

}
