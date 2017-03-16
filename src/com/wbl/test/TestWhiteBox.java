package com.wbl.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.wbl.webdriver.WhiteBox;

public class TestWhiteBox {

	/*@BeforeSuite
	public void beforeSuite() {
		WebDriver driver = new ChromeDriver();
	}*/
	@BeforeClass
	public void driverSetting() {
		String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",LOCATION);
		
		/*String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",LOCATION);*/
		
}
	@Test
	public void testhomePgInfo() {
		String actual;
		WhiteBox winHand = new WhiteBox();
		actual = winHand.homePgInfo();
		Assert.assertEquals(actual, "http://whiteboxqa.com/");
	}
	
	@Test
	public void testLoginPg() {
		String actual;
		WhiteBox winHand = new WhiteBox();
		 actual = winHand.loginPag();
		 Assert.assertEquals(actual, "QA/QE/SDET Training.");
	}
	
	@Test
	public void testWinHandle() {
		int actual;
		WhiteBox winHand = new WhiteBox();
		actual = winHand.winHandle();
		System.out.println("Actual:" +actual);
		Assert.assertEquals(actual, 2);
	}
	
	@Test
	public void testdisplSocIcons() {
		int actual;
		WhiteBox winHand = new WhiteBox();
		actual = winHand.displSocIcons();
		Assert.assertEquals(actual, 4);
	}

}
