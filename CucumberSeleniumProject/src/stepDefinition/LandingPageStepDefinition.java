package stepDefinition;
import java.util.Iterator; 
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

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingpageProductName;
	public String offerpageProductName;
	TestContextSetup testContextSetup;
	//public LandingPageStepDefinition()
	//{
		
	//}
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/jayanichapa/Eclipse2024/CucumberSeleniumProject/drivers/chromedriver");
		testContextSetup.driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	   
	}
	
	@When("User searched with {string} and extaracted actual name of product")
	public void user_searched_with_and_extaracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		testContextSetup.landingpageProductName= testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(landingpageProductName + "is extracted from the HOME PAGE"  );
	    
	}
	
	

}
