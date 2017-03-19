package com.wbl.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.webdriver.Waits;
import org.testng.Assert; 
//import junit.framework.Assert;

public class TestWaits {
		
		String actual;
	
		@BeforeClass
		public void driverSetting() {
			
			String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",LOCATION);
			
			/*String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",LOCATION);*/
		}
	
		@Test
		public void testImpliWait() {
			Waits wt = new Waits();
			
			actual = wt.implicitWait();
			Assert.assertEquals("Library", actual);
		}
		
		
		@Test
		public void testExplicitwt() {
			Waits wt = new Waits();
			
			actual = wt.explicitWait();
			Assert.assertEquals("jumbo", actual);
		}
		
	
		@Test
		public void testfluentWait() {
			Waits wt = new Waits();
			
			wt.fluentWait();
		}
}
