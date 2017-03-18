package com.wbl.webdriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownRadButton {

		
	@Test
	//public void testFaceBookPage() throws InterruptedException {
		
		public String dropdnRadButton()  {
		//Facebook Signup
		
		//Open Facaebook page
		String gText;
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
	
		driver.findElement(By.id("u_0_1")).sendKeys("Dhruv");
		driver.findElement(By.id("u_0_3")).sendKeys("Kothari");

		driver.findElement(By.id("u_0_6")).sendKeys("dhruv_kothari@gmail.com");
	
		
		driver.findElement(By.id("u_0_9")).sendKeys("dhruv_kothari@gmail.com");
		
		driver.findElement(By.id("u_0_d")).sendKeys("pswd123");
		
		WebElement element = driver.findElement(By.name("birthday_month"));
		Select select = new Select(element);
		select.selectByVisibleText("Feb");
		
		element = driver.findElement(By.id("day"));
		select = new Select(element);
		select.selectByVisibleText("14");
		
		element = driver.findElement(By.id("year"));
		select = new Select(element);
		select.selectByVisibleText("2007");
		
		//Male/Female
		//driver.findElement(By.xpath("//*[@id='u_0_g']/span[2]/label")).click();
		driver.findElement(By.xpath("//*[@id='u_0_k']")).click();
	
		
		List<WebElement> radiobuttons = 
				driver.findElement(By.xpath("//*[@id='u_0_n']")).findElements(By.xpath("//*[@class='_5k_2 _5dba']"));
				
					
		//List<WebElement> radiobuttons = driver.findElements(By.cssSelector("#u_0_g"));
		System.out.println("The size of radiobutton list is: " +radiobuttons.size());
		
		for(WebElement radb: radiobuttons) {
			if(!(radb.isSelected())) {
				radb.click();
				}
			}
		
		 driver.findElement(By.name("websubmit")).submit();
		 gText = driver.findElement(By.name("websubmit")).getText();
		 System.out.println("signup button:" +gText );
		 
		
		/*element = driver.findElement(By.cssSelector("#u_0_i"));
		System.out.println("signup button:" + element.getText());
		element.click();
		*/
	//	Thread.sleep(5000);
		driver.quit();
		return gText;
		
		
	}
}
