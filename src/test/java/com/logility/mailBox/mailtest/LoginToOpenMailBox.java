package com.logility.mailBox.mailtest;

import java.sql.Driver;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class LoginToOpenMailBox {

	public static void main(String[] args) throws InterruptedException {
			
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://app.openmailbox.org/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys("sadanand12345");//Creted username 
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sadanand12345");
				
		WebElement element = driver.findElement(By.xpath("(//*[@id='login'])[1]"));
		//Verify page
		String elementText = driver.findElement(By.xpath("(//*[@id='login'])[1]")).getText();
		Assert.assertEquals("Login", elementText.contains(elementText));
		
		Thread.sleep(1000);
				
		driver.findElement(By.xpath("(//*[@id='login'])[1]")).click();
		//Verify login page
		String LogoutText = driver.findElement(By.xpath("//a[@id='logout']/i")).getText();
		Assert.assertEquals("Login", LogoutText.contains(LogoutText));		
		//Search key in search box of inbox
		String expected1="Inbox";
		Thread.sleep(10000);
		String actual1=driver.findElement(By.xpath("//div[@id='titleHead']/b")).getText();
		System.out.println("Actual1 text is : "+actual1);		
		
		Assert.assertEquals(actual1, expected1, "Input link text is not present");
		System.out.println("Input link text is present");
		System.out.println("Login is successful");
		
		String expected2="Empty folder";
		String actual2=driver.findElement(By.xpath("//div[@id='list']//h1[contains(text(),'Empty')]")).getText();
		System.out.println("Actual2 text is : "+actual2);	
				
		Assert.assertEquals(actual2, expected2, "Empty folder text is not present");
		System.out.println("Empty folder text is present");
			
		
		driver.quit();
	}

}
