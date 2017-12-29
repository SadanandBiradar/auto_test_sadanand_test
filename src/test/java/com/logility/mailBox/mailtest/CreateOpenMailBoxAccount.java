package com.logility.mailBox.mailtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;


public class CreateOpenMailBoxAccount {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://app.openmailbox.org/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SoftAssert sassert=new SoftAssert();
				
		driver.findElement(By.xpath("//div[@id='data']/div/button")).click();
		
		driver.findElement(By.id("register_id")).sendKeys("sadanand12345");//If we need to iterate with multiple user names, need to implement loop 
		driver.findElement(By.id("register_pw")).sendKeys("Sadanand12345");
		driver.findElement(By.id("register_vpw")).sendKeys("Sadanand12345");
		
		driver.findElement(By.xpath("//button[@id='register']")).click();
				 
		/*User need to select randomly occurrence of captcha image, while runnuning test script unable to complete the process
		 *  hence unable to process with user registration in this scenario. But we can achive this using Autoit tool
		 */
		
		Boolean statusDisplayed = driver.findElement(By.xpath("//a[@id='logout']/i")).isDisplayed();
		System.out.println("The logout button is displayed - "+statusDisplayed);
		Boolean statusEnabled = driver.findElement(By.xpath("//a[@id='logout']/i")).isEnabled();
		System.out.println("The logout button is enabled - "+statusEnabled);
		
		String expected="Choose your plan";
		String actual=driver.findElement(By.xpath("//div[@id='offers']//h2[contains(text(),'Choose your plan')]")).getText();
				
		sassert.assertEquals(actual, expected, "Choose your plan text is not present");
		System.out.println("Choose your plan text is present");
		System.out.println("Account Creation is successful");
		
		
		sassert.assertAll();
		
		driver.quit();
		
		
	}

}
