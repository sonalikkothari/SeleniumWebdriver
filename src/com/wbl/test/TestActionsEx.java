package com.wbl.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.webdriver.ActionsEx;

public class TestActionsEx {

	
	@BeforeClass
	public void driverSetting() {
		
		String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",LOCATION);
		
		/*String LOCATION = "C:\\Users\\sonal\\workspace1\\SelWeb\\Resources\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",LOCATION);*/
	}

	@Test
	public void testActns() throws InterruptedException {
		
		ActionsEx actions = new ActionsEx();
		String actual = actions.mouseActions();
		Assert.assertEquals(actual,"Computers & Tablets");
		
		actions.dragAndDrop();
		actions.contxtClk();
		actions.takeScrnShot();
	} 
	
}
