package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class searchProduct {
	
	WebDriver driver;
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.google.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("i enter the {string} in the search bar")
	public void i_enter_the_in_the_search_bar(String product_name) {
	    
		WebElement searchBar = driver.findElement(By.className("gLFyf"));
	    searchBar.sendKeys(product_name);
	}
  
	@When("i click on the search button")
	public void i_click_on_the_search_button() {
	    WebElement searchButton = driver.findElement(By.name("btnK"));
	    searchButton.click();
	}

	@Then("i can able to see the product search result sucessfully")
	public void i_can_able_to_see_the_product_search_result_sucessfully() {
	    WebElement searchResult = driver.findElement(By.id("result-stats"));
	    searchResult.click();
	    
	    String resultText = searchResult.getText();
	    System.out.println("====================");
	    System.out.println(resultText);
	    System.out.println("============");
	    Assert.assertTrue(searchResult.isDisplayed());
	}
	
	
}
