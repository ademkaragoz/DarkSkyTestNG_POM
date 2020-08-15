package com.qa.darksky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.page.MainPage;

public class MainPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
	
	}
	
	@Test(priority=1, description="Get the lowest temp and highest temp", enabled=true)
	public void verifyMinAndMaxTemp() throws InterruptedException {
		mainPage.getMinTempAndMaxTemp();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
