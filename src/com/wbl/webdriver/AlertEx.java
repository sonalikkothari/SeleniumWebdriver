package com.wbl.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertEx {
	WebDriver driver; 
	
	public void alertWindow() throws InterruptedException {
		
		driver = new ChromeDriver();
		//driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.get("file:///C:/Users/sonal/Desktop/alert.html");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	    //driver.findElement(By.xpath("html/body/button")).click();
	    driver.findElement(By.tagName("button")).click();
		Thread.sleep(2000);
	    
	    Alert alrtAcc = driver.switchTo().alert();
	    alrtAcc.accept();
	    Thread.sleep(2000);
	    
	    driver.quit();
	}
	
	public void alertPrompt() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/sonal/Desktop/alert-prompt.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(2000);
		
		 Alert alrtAcc = driver.switchTo().alert();
		 alrtAcc.sendKeys("This is an alert");
		 
		 alrtAcc.accept();
		 Thread.sleep(3000);
		 
		 driver.quit();
	}
	
	
	public void alertConfirm() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/sonal/Desktop/alert-confirm.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(2000);
		
		 Alert alrtAcc = driver.switchTo().alert();
		 
		 alrtAcc.dismiss();
		 Thread.sleep(3000);
		 
		 driver.quit();
	}
	
	public void alert() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://www.rightstart.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("closewelcomeRedirectPopupDialog")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}