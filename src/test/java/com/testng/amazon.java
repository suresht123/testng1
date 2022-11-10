package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {
	  static WebDriver driver;
	   
	
	 @BeforeClass (groups = "default")
		public void Beforeclass(){
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.amazon.in/");
	        driver.manage().window().maximize();
//			System.out.println("beforeclass");
		}
	    @AfterClass (groups = "default")
		public void Afterclass(){
			System.out.println("afterclass");
		}
	    @BeforeMethod  (groups = "default")
		public void Beforemethod(){
	    	System.out.println("beforemethod");
		}
	    @AfterMethod (groups = "default")
		public void Afteremethod(){
			System.out.println("aftermethod");
		}
	    @Parameters({"amazmob"})
		@Test (priority=1,groups="sanity")
		public void test1 (String mob){
			WebElement name =driver.findElement(By.xpath("//input[@type='text']"));
			name.sendKeys(mob);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
}
		@Test (priority=2)
		public void test2 (){
			driver.findElement(By.xpath("(//span[contains(text(),'Black')])[1]")).click();
		}
		@Test (priority=3)
		public void test3 (){
			}
		}


