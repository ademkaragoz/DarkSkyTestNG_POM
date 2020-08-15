package com.qa.darksky.test;


import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.page.HomePage;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	
	@BeforeTest
	public void Setup() {
		basePage= new BasePage();
		properties=basePage.init_properties();
		String browserName= properties.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
		homePage= new HomePage(driver);
	}
	
	@Test(priority=1)
	public void clickToday() {
	  homePage.getTemperature();
	}
	
	@Test(priority=2)
	public void verifyHomeaPageTitle() {
	  String title= homePage.getHomePageTitle();
	  Assert.assertEquals(title, "Dark Sky - Broadway, New York, NY");
	}
	
	@Test(priority=3)
	public void getTempeList() {
	  System.out.println(homePage.getTempList(driver));
	}
	
	@Test(priority=4)
	public void minTempe() {
	   System.out.println("Expected minimum temperature : "+homePage.minTemp());
	}
	
	@Test(priority=5)
	public void maxTempe() {
		System.out.println("Expected maksimum temperature : "+ homePage.maxTemp());
	}
	
	@Test(priority=6, enabled=false)
	public void verifyMinTempe() {
		homePage.verifyMin();
		Assert.assertEquals(homePage.verifyMin(), homePage.minTemp());
	}
	
	@Test(priority=7, enabled=false)
	public void verifyMax() {
		homePage.verifyMax();
		Assert.assertEquals(homePage.verifyMax(), homePage.maxTemp());
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();;
	}
	
	
	

}
