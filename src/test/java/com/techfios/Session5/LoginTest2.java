package com.techfios.Session5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest2 {
	

WebDriver driver;
	
	By USERNAME = By.xpath("//*[@id=\"username\"]");
	By PASSWORD = By.xpath("//*[@id=\"password\"]");
	By LOGIN = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER = By.xpath("//span[contains(text(),'Customers')]");
	By ADDCUSTOMER = By.xpath("//a[contains(text(), 'Add Customer')]");
	By FULLNAME =By.xpath("//*[@id=\"account\"]");
	String username = "demo@techfios.com";
	String password = "abc123";
	String expectedTile = "Dashboard" ;


	@BeforeMethod
public void initDriver() {
	
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nesar Ahmed\\eclipse-workspace\\Session5\\drivers\\chromedriver.exe");
	//driver=new ChromeDriver();
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nesar Ahmed\\eclipse-workspace\\Session5\\drivers\\Firefox Installer.exe");
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://techfios.com/billing/?ng=admin");
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