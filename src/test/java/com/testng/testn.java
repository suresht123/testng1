package com.testng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testn {
	static WebDriver driver;
	@DataProvider ( name = "login")
	public Object [] [] getlogindetails(){
		return new Object [][] {{"SARAVANAN","123456"}};
	}
	
    @BeforeClass (groups = "default")
	public void Beforeclass(){
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
//		System.out.println("beforeclass");
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
	@Test (priority=1,dataProvider = "login",groups="smoke")
	public void test1 (String ID,String PASS) throws InterruptedException{
		WebElement name =driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		name.sendKeys(ID);
		WebElement pass =driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys(PASS);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();   
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
//		System.out.println("login");
	}
	@Parameters({"flipmob"})
	@Test (priority=2,groups="smoke")
	public void test2(String mobile){
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(mobile);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		System.out.println("search");
		
	}
	@Test(priority=3)
	public void test3() throws IOException{
		WebDriverWait w = new WebDriverWait (driver,Duration.ofSeconds(100));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_4rR01T']")));
		
		File f = new File ("C:\\Users\\Windows 11\\workspace\\testng\\target\\Testngexce.xlsx");
		FileOutputStream d= new FileOutputStream(f);
		Workbook w1 = new XSSFWorkbook();
	    Sheet s = w1.createSheet("MOBILE LIST");
		
		List <WebElement>vivo=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (int i = 0; i<vivo.size();i++){
			WebElement name = vivo.get(i);
			String text = name.getText();	
			Row ro =s.createRow(i);	
			Cell ce = ro.createCell(0);
			ce.setCellValue(text);
		}
		{
			w1.write(d);
		
		}
//		System.out.println("mobile");

}	@Test(priority=4)
	public void test4() throws IOException{
	FileWriter f1 = new FileWriter("C:\\Users\\Windows 11\\workspace\\testng\\target\\Testng.txt");
	driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]")).click();
    Set<String> child = driver.getWindowHandles();
    List <String> child1 = new ArrayList(child);
	driver.switchTo().window(child1.get(1));
	String text1=driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
	f1.write(text1);
	f1.close();
//		System.out.println("window");

}	@Test(priority=5)
	public void test5() throws IOException{
	
  
	
   File f = new File ("C:\\Users\\Windows 11\\workspace\\testng\\target\\Testngexce.xlsx");
   FileInputStream d= new FileInputStream(f);
   Workbook w1 = new XSSFWorkbook(d);
   Sheet s = w1.getSheet("MOBILE LIST");
   
  Row ro = s.getRow(3);
  Cell ce = ro.getCell(0);
  
  String getval= ce.getStringCellValue();
  System.out.println(getval);
  
  FileReader f1 = new FileReader("C:\\Users\\Windows 11\\workspace\\testng\\target\\Testng.txt");
  BufferedReader buf = new  BufferedReader (f1);
  String get;
  while ((get =buf.readLine()) != null){
  System.out.println(get);
	
  
	SoftAssert s1 = new SoftAssert();
	s1.assertEquals(getval, get);
  }
//		System.out.println("add to cart");
}	@Test(priority=6,invocationCount=2)
	public void test6(){
	driver.navigate().refresh();

  
  }	@Test(priority=7,enabled =true)
	public void test7(){
	driver.close();
  
  }
}