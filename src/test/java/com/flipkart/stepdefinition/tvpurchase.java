package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class tvpurchase {
	String names;
	@When("user search required tv")
	public void user_search_required_tv() {
		
         names= "MITV";
		
		mobilepuchasestep.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobilename = mobilepuchasestep.driver.findElement(By.xpath("//div[@class='_4rR01T']"));
		String fn = mobilename.getText();
		mobilename.click();
	  
	   
	}


@When("user select required  tv")
public void user_select_required_tv() {

		
		String parent = mobilepuchasestep.driver.getWindowHandle();
		Set <String> child = mobilepuchasestep.driver.getWindowHandles();
		
	for ( String x : child) {
		if (!parent.equals(child)){
			mobilepuchasestep.driver.switchTo().window(x);
			System.out.println("window swiched");
		}}
		}
		
		@When("user search required tv by using oneD list")
		public void user_search_required_tv_by_using_oneD_list(DataTable dataTable) {
			List<String> data = dataTable.asList();

			names= data.get(2);
			
			mobilepuchasestep.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
			WebElement mobilename = mobilepuchasestep.driver.findElement(By.xpath("//div[@class='_4rR01T']"));
			String fn = mobilename.getText();
			mobilename.click();
		}
		
		@When("user search required tv by using oneD map")
		public void user_search_required_tv_by_using_oneD_map(DataTable dataTable) {
			Map<String, String> data1 = dataTable.asMap(String.class, String.class);

			names= data1.get("TV2");
			
			mobilepuchasestep.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
			WebElement mobilename = mobilepuchasestep.driver.findElement(By.xpath("//div[@class='_4rR01T']"));
			String fn = mobilename.getText();
			mobilename.click();
		}

		@When("user search required tv {string}")
		public void user_search_required_tv(String string) {
			
			names= string;
			
			mobilepuchasestep.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
			WebElement mobilename = mobilepuchasestep.driver.findElement(By.xpath("//div[@class='_4rR01T']"));
			String fn = mobilename.getText();
			mobilename.click();
}}
		
