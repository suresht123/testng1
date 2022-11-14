package com.flipkart.stepdefinition;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mobilepuchasestep {
	
	static WebDriver driver ;
	
	
	@Given("user login into flipkart")
	public void user_login_into_flipkart() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        try{
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).isDisplayed();
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        
        } catch (Exception e){	
        	System.out.println("login not required");	
        }
	}
    String names;
	@When("user search required mobile")
	public void user_search_required_mobile() {
		
		names= "vivo";
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobilename = driver.findElement(By.xpath("(//div[contains(text(),'"+names+"')])[2]"));
		String fn = mobilename.getText();
		mobilename.click();
	  
	}

	@When("user select required  mobile")
	public void user_select_required_mobile() {
		
	String parent = driver.getWindowHandle();
	Set <String> child = driver.getWindowHandles();
	
for ( String x : child) {
	if (!parent.equals(child)){
		driver.switchTo().window(x);
		System.out.println("window swiched");
		
	}	
	
}	  
	}

	@When("user select payment method in UPI")
	public void user_select_payment_method_in_UPI() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement buy = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']"));
		js.executeScript("arguments[0].scrollIntoView(true)", buy);
		String text = buy.getText();
		Assert.assertEquals("BUY NOW", text);
		
		
		
	}

	@Then("user got the confirmation")
	public void user_got_the_confirmation() {
		
	}
	@When("user search required mobile by using oneD list")
	public void user_search_required_mobile_by_using_oneD_List(DataTable dataTable) {
		List<String> data = dataTable.asList();

		names= data.get(2);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobilename = driver.findElement(By.xpath("//div[@class='_4rR01T']"));
		String fn = mobilename.getText();
		mobilename.click();
	}
		@When("user search required mobile by using oneD map")
		public void user_search_required_mobile_by_using_oneD_map(DataTable dataTable) {
			Map<String, String> data1 = dataTable.asMap(String.class, String.class);

			names= data1.get("MOBILE2");
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
			WebElement mobilename = driver.findElement(By.xpath("//div[@class='_4rR01T']"));
			String fn = mobilename.getText();
			mobilename.click();
	 
	}   
	
		@When("user search required mobile {string}")
		public void user_search_required_mobile(String string) {
			
			names= string;
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
			WebElement mobilename = driver.findElement(By.xpath("//div[@class='_4rR01T']"));
			String fn = mobilename.getText();
			mobilename.click();
		  

		}

}
