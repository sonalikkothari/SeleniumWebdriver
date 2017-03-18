package com.wbl.webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhiteBox {

		WebDriver driver;

	 	public int  displSocIcons() {
	 		int lstCount;
	 		WebDriver driver = new ChromeDriver();
			//WebDriver driver = new FirefoxDriver();
			//driver.get("https://github.com/");
			driver.get("http://whiteboxqa.com/");
			driver.manage().window().maximize();
			
			List<WebElement>  lst = driver.findElements(By.xpath("(.//*[@class='pull-right social-icons ']/li)"));
			//List<WebElement>  lst = driver.findElements(By.xpath("(.//*[@class='container']/ul/li)"));
			
			lstCount = lst.size();
			System.out.println("The no of elements are::"+lstCount);
			driver.quit();
			return lstCount;
	 	}
	
	
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
		
		public boolean navigate() throws InterruptedException {
			
			boolean chkPres;
			WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("http://whiteboxqa.com/");
			driver.manage().window().maximize();

			
			driver.findElement(By.xpath(".//*[@class='container']/ul/li[1]")).click();
			
			driver.navigate().back();
			
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().refresh();
			
			chkPres = driver.findElement(By.xpath(".//*[@class='text']")).isDisplayed();
			System.out.println(chkPres);
			
			driver.quit();
			return chkPres;
		}
			
		public String dimenPoint() {
		
			String tagNm,attri;
			WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("http://whiteboxqa.com/");
			driver.manage().window().maximize();
			
			WebElement element = driver.findElement(By.cssSelector("#logo"));
			Dimension dimension = element.getSize();
			
			System.out.println("The height of 'Whiteboxqa' is: " + dimension.getHeight() );
			System.out.println("The width of 'Whiteboxqa' is: " + dimension.getWidth());
			
			Point point = element.getLocation();
			System.out.println("X : " +point.getX());
			System.out.println("Y : " +point.getY());
			
			System.out.println(driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).isEnabled());
			
			tagNm = driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getTagName();
			//attri = driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getAttribute("type");
			attri = driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getAttribute("class");
			System.out.println("//////////////" +tagNm);
		System.out.println("++++++++++++++++" +attri);
			//(assertEquals("button",driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getTagName()));
			//assertEquals("button",driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getAttribute("type"));
		System.out.println("The css value is: " +driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getCssValue("font-family"));
		System.out.println("The css value is: " +driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getCssValue("background-color"));
		System.out.println("The css value is: " +driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getCssValue("border"));
		System.out.println("The css value is: " +driver.findElement(By.xpath("//*[@class='btn-md btn-theme btn-over']")).getCssValue("color"));
		
		
		driver.quit();	
		return attri;	
			
		}

}