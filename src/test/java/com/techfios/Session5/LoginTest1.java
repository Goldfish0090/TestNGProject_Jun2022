package com.techfios.Session5;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest1 {
	
	WebDriver driver;
	
	String browser;
	String url;
	
	
	//Element List
	
	By USERNAME = By.xpath("//*[@name=\"username\"]");
	
	By PASSWORD = By.xpath("//*[@id=\"password\"]");
	By LOGIN = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER = By.xpath("//span[contains(text(),'Customers')]");
	By ADDCUSTOMER = By.xpath("//a[contains(text(), 'Add Customer')]");
	By FULLNAME =By.xpath("//*[@id=\"account\"]");
	String username = "demo@techfios.com";
	String password = "abc123";
	String expectedTile = "Dashboard" ;

	@BeforeClass
	public void readConfig() {
		//inputStream//BufferReader//FileReader//Scanner
		
		try {
			InputStream input= new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop= new Properties();
			prop.load(input);
			browser= prop.getProperty("browser");
			url= prop.getProperty("url");
		
	}catch(IOException e){
		e.printStackTrace();
	}
		
	}
	
	
	@BeforeMethod
	public void initDriver() {
		
		
		if (browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nesar Ahmed\\eclipse-workspace\\Session5\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
	 
		else if  (browser.equalsIgnoreCase("firefox")){

		System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	 }
		driver.manage().deleteAllCookies();
		driver.get("url");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 }
	
@Test
	public void loginTest() {
		
	driver.findElement(USERNAME).sendKeys(username);
    driver.findElement(PASSWORD).sendKeys(password);
    driver.findElement(LOGIN).click();
    Assert.assertEquals(driver.findElement(DASHBOARD).getText(), expectedTile,"page khuja pailam na boss");
   
    
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}
