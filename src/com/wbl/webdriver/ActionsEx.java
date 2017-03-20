package com.wbl.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class ActionsEx {
	
		WebDriver driver = new ChromeDriver();
		
			public String mouseActions() {
				
				driver.get("http://www.ebay.com/");
				//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
				
				driver.manage().window().maximize();
				
				
				Actions acts = new Actions(driver);
				
				WebElement mainElement = driver.findElement(By.xpath("//*[@role = 'list']/td[6]"));
				acts.moveToElement(mainElement).perform();
				
				WebElement subElement = driver.findElement
						(By.xpath("//*[@ title='Electronics - Computers & Tablets']"));
				FluentWait<WebDriver> flntwt = 
						new FluentWait<WebDriver> (driver).pollingEvery(5, TimeUnit.SECONDS).withTimeout(35,TimeUnit.SECONDS);
				flntwt.until(ExpectedConditions.visibilityOf(subElement));
				
				
						//driver.findElement(By.xpath("html/body/div[4]/div/div/div[1]/div[1]/div/table/tbody/tr/td[6]/div[2]/div[1]/ul[1]/li[3]/a"));
	
				acts.moveToElement(subElement).click().perform();
				
				WebElement title = driver.findElement(By.xpath("//*[@id='mainTitle']"));
				flntwt.until(ExpectedConditions.visibilityOf(title));
				
				String txt = title.getText();
				System.out.println("Ebay - Electronics txt is::" +txt);
				System.out.println("The page title is:: "+driver.getTitle());
				
				
				driver.quit();
				return txt;
				
			}
			
			public void dragAndDrop() throws InterruptedException {
				
				driver = new ChromeDriver();
				driver.get("http://marcojakob.github.io/dart-dnd/basic/web/");
				
				driver.manage().window().maximize();
				
				WebElement src1 = driver.findElement(By.xpath("html/body/div/img[1]"));
				WebElement src2 = driver.findElement(By.xpath("html/body/div/img[2]"));
				WebElement src3 = driver.findElement(By.xpath("html/body/div/img[3]"));
				WebElement src4 = driver.findElement(By.xpath("html/body/div/img[4]"));
				
				WebElement dstn = driver.findElement(By.xpath("html/body/div/div"));
				
				Actions actn = new Actions(driver);
				
				actn.dragAndDrop(src1, dstn).perform();
				Thread.sleep(1000);
				actn.dragAndDrop(src2, dstn).perform();
				Thread.sleep(1000);
				actn.dragAndDrop(src3, dstn).perform();
				Thread.sleep(1000);
				actn.dragAndDrop(src4, dstn).perform();
				Thread.sleep(1000);
				
				driver.quit();
				
			}

			public void contxtClk() throws InterruptedException  {
				
				driver= new ChromeDriver();
				driver.get("http://www.jqueryscript.net/demo/Lightweight-jQuery-Context-Menu-Plugin-with-Callback-Support/");
				
				driver.manage().window().maximize();
				
				WebElement conEle1 = driver.findElement(By.xpath("html/body/div[2]/p[1]"));
				
				Actions acn = new Actions(driver);
				
				acn.contextClick(conEle1).perform();
				
				Thread.sleep(1000);
				
				WebElement conEle2 = driver.findElement(By.xpath("html/body/div[4]/ul/li[1]/a/span"));
				
				acn.moveToElement(conEle2).perform();
				//contextClick(conEle2).perform();
				
				Thread.sleep(1000);
				
				WebElement conEle3 = driver.findElement(By.xpath("html/body/div[4]/ul/li[1]/ul/li[1]/a"));
				
				acn.moveToElement(conEle3).click().perform();
				Thread.sleep(1000);
				
				driver.quit();
				
			} 
				
		public void takeScrnShot() {
			
			try {
			driver = new ChromeDriver();
			driver.get("http://www.jqueryscript.net/demo/Lightweight-jQuery-Context-Menu-Plugin-with-Callback-Support/");
			
			driver.manage().window().maximize();
			
			WebElement conEle1 = driver.findElement(By.xpath("html/body/div[2]/p[100]"));
			
			Actions acn = new Actions(driver);
			
			acn.contextClick(conEle1).perform();
			
			driver.quit();
			
			} catch(Exception e) {
				System.out.println("In exception loop.....");
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("C:\\Users\\sonal\\Desktop\\newscreenshotFile.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	finally {
				driver.quit();
			}
			
		}
}

}