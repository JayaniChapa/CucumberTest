package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OfferPageStepDefinition {
	
	public String offerpageProductName;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup= testContextSetup;
	}
		
	@Then("User searched for the same shortname in offers page")
	public void user_searched_for_the_same_shortname_in_offers_pagee(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
        offerpageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		 
	 
	}
	public void switchToOffersPage()
	{
		//if switched to offer page -> skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1= testContextSetup.driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		String parentWindow =i1.next();
		String childWindow = i1.next();
		
		testContextSetup.driver.switchTo().window(childWindow); 
	}
	
	@Then("validate product name in offers matches with Landing page")
	public void validation()
	{
		Assert.assertEquals(testContextSetup.landingpageProductName, offerpageProductName);
		
	}

}
