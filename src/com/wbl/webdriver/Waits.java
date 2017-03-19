package com.wbl.webdriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class Waits {
		
		WebDriver driver  = new ChromeDriver();
	
	
		public String implicitWait() {
		
		String gTxt;
			
		driver.get("https://dev.talentscreen.io/#/website-pages/home");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Subjects")).click();
		
		WebElement element = driver.findElement(By.cssSelector(".text-display-1.margin-none"));
		gTxt = (element.getText());
		
		System.out.println("txt::" +gTxt);
	
		driver.quit();
		return gTxt;
	}

	
	public void explicitWait() {
		
		
		WebElement element;
		driver.get("https://dev.talentscreen.io/#/website-pages/home");
		driver.manage().window().maximize();
		
		WebDriverWait explwait = new WebDriverWait(driver,25);
			//Explicit wait default checks after 500ms
		
		List<WebElement> fpnav = driver.findElements(By.xpath("//*[@id='fp-nav']/ul/li"));
		explwait.until(ExpectedConditions.visibilityOfAllElements(fpnav));
		
		System.out.println("The count of fpnavigator is::" +fpnav.size());
		
		fpnav.get(1).click();
		
		element = explwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class= 'lead text-muted']")));
		System.out.println("The text is:: " +element.getText());
		
		fpnav.get(2).click();

		/*explwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='candidateCountUp']")));
		System.out.println(driver.findElement(By.xpath("//*[@id='candidateCountUp']")).getAttribute("class"));*/
		
		element = explwait.until(function);
		System.out.println("Attribute:: "+element.getAttribute("class"));
	
		driver.quit();
	}
	
	Function<WebDriver,WebElement> function = new Function<WebDriver,WebElement> () {

		@Override
		public WebElement apply(WebDriver arg0) {
			// TODO Auto-generated method stub
			
			//WebDriver driver;
			WebElement element = 
						driver.findElement(By.xpath("//*[@id='candidateCountUp']"));
			return element;
		}

	};	

	

	
		public void fluentWait() {
			driver.get("https://dev.talentscreen.io/#/website-pages/home");
			driver.manage().window().maximize();
			
			FluentWait<WebDriver>   flwt =
					new FluentWait<WebDriver> (driver).pollingEvery(5, TimeUnit.SECONDS).withTimeout(25, TimeUnit.SECONDS);
			List<WebElement> fpnav = driver.findElements(By.xpath("//*[@id='fp-nav']/ul/li"));
			
			fpnav.get(3).click();
			
			flwt.until(pr);
			/*WebElement elem=flwt.until(ExpectedConditions.presenceOfElementLocated
					(By.xpath("//*[@class='section section-four ng-scope fp-section fp-table active']/div/div/h2")));
			//WebElement elem  = driver.findElement(By.xpath("//*[@class='section section-four ng-scope fp-section fp-table active']/div/div/h2"));
			System.out.println("Text::::" +elem.getAttribute("class"));
			System.out.println("Text::::" +elem.getTagName());*/
			
			driver.quit();
			
		}
	
		
		Predicate<WebDriver> pr = new Predicate<WebDriver> () {

			@Override
			public boolean  apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				
				WebElement elem  = driver.findElement(By.xpath("//*[@class='section section-four ng-scope fp-section fp-table active']/div/div/h2"));
				System.out.println("Text::::" +elem.getAttribute("class"));
				System.out.println("Text::::" +elem.getTagName());
				return true;
			}
			
		};
		
}

