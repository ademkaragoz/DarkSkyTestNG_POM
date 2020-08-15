package com.qa.darksky.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.darksky.base.BasePage;
import com.qa.darksky.util.ElementUtil;
import com.qa.darksky.util.JavaScriptUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	  //Locator
	  By clickToday = By.xpath("//a[@data-day='0']");
	  By temperature = By.xpath("(//div[@class='temps'])[2]//span//span");
	  By lowestTemp = By.xpath("//a[@data-day=‘0’]//span[@class=‘minTemp’]");
	  By highestTemp = By.xpath("//span[@class='high-temp-text']");
	  By maximunTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
	
	//Constructor
	public String getHomePageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	//Actions
	public void getTemperature() {
		WebElement element = driver.findElement(clickToday);
        JavaScriptUtil.scrollIntoView(element, driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(clickToday));
		driver.findElement(clickToday).click();
    }
	
	static ArrayList<Integer> tempListInt = new ArrayList<Integer>();
	
	public ArrayList<Integer> getTempList(WebDriver driver){
		
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(temperature));
		List<WebElement> tempList = driver.findElements(temperature);
		
		for (int i = 0; i < tempList.size(); i++) {
			String tempText = tempList.get(i).getText().substring(0, 2);
			tempListInt.add(Integer.parseInt(tempText));
			
		}
		return tempListInt;
	}
	
	public  int minTemp() {
		Collections.sort(tempListInt);
		return tempListInt.get(0);
	}
	
	public  int maxTemp() {
		Collections.sort(tempListInt);
		return tempListInt.get(tempListInt.size()-1);
		
	}
	public int verifyMin() {
		WebElement lowtemp = driver.findElement(lowestTemp);
		String lowTempStr =lowtemp.getText().substring(0, 2);
		int lowTempInt = Integer.parseInt(lowTempStr);
		return lowTempInt;
	}
	public int verifyMax() {
		WebElement hightemp = driver.findElement(highestTemp);
		String lowTempStr =hightemp.getText().substring(0, 2);
		int highTempInt = Integer.parseInt(lowTempStr);
		return highTempInt;
	
	}

}
	
	
	
	
	
	
	


