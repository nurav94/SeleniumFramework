package test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import utilities.ConfigReader;

public class HomeScreen extends BaseClass {

	@BeforeMethod
	public static void initiaizeBrowser() {
		ConfigReader configReader = new ConfigReader();
		openBrowser(configReader.getBrowser());
		driver.manage().window().maximize();
		driver.get(configReader.getUrl());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	

	@Test
	public static void verifySitename() {
		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa/");		
	}
	
	@Test
	public static void verifyTitle() {
		System.out.println("second testcase");
		
	}
}
