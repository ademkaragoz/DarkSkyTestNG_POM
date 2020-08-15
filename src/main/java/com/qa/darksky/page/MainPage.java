package com.qa.darksky.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.util.ElementUtil;
import com.qa.darksky.util.JavaScriptUtil;


public class MainPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	
	//Locator   
	By clickToday = By.xpath("//a[@data-day='0']");
    By getcurrentTemp = By.cssSelector(".summary.swap");
    By TimeLine = By.cssSelector(".temps span:last-child");
	
	//Constructor
	public MainPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		//javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	//Actions
	public void getMinTempAndMaxTemp() throws InterruptedException {
		
	Thread.sleep(3000);
	//WebElement element = driver.findElement(clickToday);
	//javaScriptUtil.scrollIntoView(element, driver);
	
	String currentTemp = driver.findElement(getcurrentTemp).getText();
	System.out.println("Current Temp:" + currentTemp);
	List<WebElement> tempsInTimeLine = driver.findElements(TimeLine);
	int temp = Integer.parseInt(currentTemp.substring(0, 2));
	int highestInTimeLine = temp;
	int lowestInTimeLine = temp;
	for (WebElement tempInTime: tempsInTimeLine) {
		  String sLineTemp = tempInTime.getText();
		  int lineTemp = Integer.parseInt(sLineTemp.substring(0, 2));
		  if (lineTemp > highestInTimeLine){
		      highestInTimeLine  = lineTemp;
		  }
		   if (lineTemp < lowestInTimeLine ){
		      lowestInTimeLine = lineTemp;
		   }

		}

		System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
		System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine ));
		
		
		
	}
	

}

/**
String currentTemp = driver.findElement(By.cssSelector(".summary.swap")).getText();
System.out.println("Current Temp:" + currentTemp);

List<WebElement> tempsInTimeLine = driver.findElements(By.cssSelector(".temps span:last-child"));
int temp = Integer.parseInt(currentTemp.substring(0, 2));
int highestInTimeLine = temp;
int lowestInTimeLine = temp;
for (WebElement tempInTime: tempsInTimeLine) {
	  String sLineTemp = tempInTime.getText();
	  int lineTemp = Integer.parseInt(sLineTemp.substring(0, 2));
	  if (lineTemp > highestInTimeLine){
	      highestInTimeLine  = lineTemp;
	  }
	   if (lineTemp < lowestInTimeLine ){
	      lowestInTimeLine = lineTemp;
	   }

	}

	System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
	System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine ));
	elementUtil.doIsDisplayed(todayTemp);

*/




















