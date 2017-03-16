package com.wbl.webdriver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhiteBox {

	

	 	public int  displSocIcons() {
	 		int lstCount;
	 		WebDriver driver = new ChromeDriver();
			//WebDriver driver = new FirefoxDriver();
			//driver.get("https://github.com/");
			driver.get("http://whiteboxqa.com/");
			driver.manage().window().maximize();
			
			//List<WebElement>  lst = driver.findElements(By.xpath("(.//*[@class='pull-right social-icons']/li)"));
			List<WebElement>  lst = driver.findElements(By.xpath("(.//*[@class='container']/ul/li)"));
			
			//for(WebElement disp: lst)
				//System.out.println("The social icons are::" +disp.getText());
			lstCount = lst.size();
			System.out.println("The no of elements are::"+lstCount);
			driver.quit();
			return lstCount;
	 	}
	
	/*@Test
	public void testGitHubPage() throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://github.com/");
		driver.get("http://whiteboxqa.com/");
		driver.manage().window().maximize();
		System.out.println("The current url is::" +driver.getCurrentUrl());
		System.out.println("The Title is::" +driver.getTitle());
		//System.out.println("The Pagesource is::" +driver.getPageSource());
		
		//List<WebElement>  lst = driver.findElements(By.xpath("(.//*[@class='pull-right social-icons']/li)"));
		List<WebElement>  lst = driver.findElements(By.xpath("(.//*[@class='container']/ul/li)"));
		
		for(WebElement disp: lst)
			System.out.println("The social icons are::" +disp.getText());
		System.out.println("The no of elements are::"+lst.size());
		
		
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.name("uname")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("abcd123");
		driver.findElement(By.name("submit")).submit();
		
		Thread.sleep(5000);
		
		
		driver.close();
		
	}*/
	
		public String homePgInfo() {
			String currentUrl;
			WebDriver driver = new ChromeDriver();
		
			driver.get("http://whiteboxqa.com/");
			driver.manage().window().maximize();
			
			currentUrl = driver.getCurrentUrl();
			System.out.println("The current url is::" +currentUrl);
			System.out.println("The Title is::" +driver.getTitle());
			System.out.println("The Pagesource is::" +driver.getPageSource());
			
			driver.quit();
			return currentUrl;
		}
		
		public String loginPag() {
			String pgTitle;
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://whiteboxqa.com/");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("loginButton")).click();
			driver.findElement(By.name("uname")).sendKeys("student");
			driver.findElement(By.id("password")).sendKeys("abcd123");
			driver.findElement(By.name("submit")).submit();
			
			pgTitle = driver.getTitle();
			System.out.println(pgTitle);
		
			 driver.quit();
				return pgTitle;
		}
	
		
		public int winHandle() {
		WebDriver driver = new ChromeDriver();
		int winCount = 0;
		
		driver.get("http://whiteboxqa.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("headerfblogin")).click();
		//get the current window
		String currentWin = driver.getWindowHandle();
		System.out.println("Current window is::" +currentWin);
		
		Set<String> window = driver.getWindowHandles();
		winCount = window.size();
		System.out.println("Total no of windows" +window.size());
		
		for(String win: window)
			System.out.println("window::" +win);
		
		for(String win: window) {
			if(!win.equals(currentWin)) {
				driver.switchTo().window(win);
			}
		}
		
		driver.findElement(By.name("email")).sendKeys("Student");
		driver.findElement(By.id("pass")).sendKeys("abcd123");
		driver.findElement(By.name("login")).submit();
		
		
		
		driver.quit();
		return winCount;
	}

}