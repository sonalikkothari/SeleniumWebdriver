package com.wbl.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.webdriver.AlertEx;

public class TestAlertEx {

	
	@BeforeClass
	public void driverSetting() {
		
		String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",LOCATION);
		
		/*String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",LOCATION);*/
	}

	@Test
	public void testAlertEx() throws InterruptedException {
		
		AlertEx  alrt = new AlertEx();
		
		alrt.alertWindow();
		
		alrt.alertPrompt();
		
		alrt.alertConfirm();
		
		alrt.alert();
	}
}
