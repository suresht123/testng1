package com.flipkart.stepdefinition;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Faceboo {
	
	static WebDriver driver ;
	

@Given("user enter facebbok url")
public void user_enter_facebbok_url() {
	
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();


	
	
}

@When("user enter details")
	public void enter_user_details() throws InterruptedException {
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("suresh");
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("t");
	driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("suresh@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("suresh@gmail.com");
    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("suresh");
    
    WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
           Select s= new Select(day);
           s.selectByValue("26");
           WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
           Select s1= new Select(month);
           s1.selectByVisibleText("May");
           WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
           Select s2= new Select(year);
           s2.selectByValue("1984");
           driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	
		
               }

@When("user signup")
public void user_signup() {
	driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    
}

@When("user go facebook home")
public void user_go_facebook_home() {


}

@Then("user signout")
public void user_signout() {
	
}
@Given("enter user details by using oneD map")
public void enter_user_details_by_using_oneD_map(DataTable dataTable) throws InterruptedException {
	Map<String, String>datas= dataTable.asMap(String.class, String.class);
	String First = datas.get("first name");
	String sur = datas.get("surname");
	String Mailid = datas.get("emailid");
	String RMailid = datas.get("re mailid");
	String passw = datas.get("password");
    String Day = datas.get("day");
	String Month = datas.get("month");
	String Year = datas.get("year");
	
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(First);
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(sur);
	driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(Mailid);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(RMailid);
    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(passw);
    
    WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
           Select s= new Select(day);
           s.selectByValue(Day);
           WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
           Select s1= new Select(month);
           s1.selectByVisibleText(Month);
           WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
           Select s2= new Select(year);
           s2.selectByValue(Year);
           driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	}
@Given("enter user details {string},{string},{string},{string},{string},{string},{string},{string}")
public void enter_user_details(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) throws InterruptedException {
	String First = string;
	String sur = string2;
	String Mailid = string3;
	String RMailid = string4;
	String passw = string5;
    String Day = string6;
	String Month = string7;
	String Year = string8;
	
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(First);
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(sur);
	driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(Mailid);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(RMailid);
    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(passw);
    
    WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
           Select s= new Select(day);
           s.selectByValue(Day);
           WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
           Select s1= new Select(month);
           s1.selectByVisibleText(Month);
           WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
           Select s2= new Select(year);
           s2.selectByValue(Year);
           driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

}
   
}


