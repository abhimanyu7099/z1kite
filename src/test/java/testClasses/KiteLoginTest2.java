package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pomClasses.KiteHomePage3UserID;
import pomClasses.KiteLogin1Page;
import pomClasses.KiteLoginPage2;
import utilClasses.UtilityClass;

public class KiteLoginTest2 {
	WebDriver driver;
	BaseClass b;
	KiteLogin1Page login1;
	KiteLoginPage2 login2;
	KiteHomePage3UserID home;
	KiteLoginTest1 test ;
	String tcID;
	
	@BeforeClass
	public void openBrowser(){
		 Reporter.log("---open browser",true); 
		b = new BaseClass();                          // baseclass obj
		driver=b.lanchChrome();                      // pass driver 
		login1 = new KiteLogin1Page(driver);        // pom class 1 obj
		login2 = new KiteLoginPage2 (driver);      // pom class 2 obj 
		home= new KiteHomePage3UserID(driver);    // pom class 3 obj 
		test = new KiteLoginTest1();             //testclass 1 obj
		
	}
		
	@BeforeMethod
	public void loginToApp() throws IOException, InterruptedException {
		
		Reporter.log("----login to Application----");
		
		//Enter user ID
		String user = UtilityClass.readPropertyFileData("UN");
		login1.inpKiteLogin1PageUsername(user);
		
		////Enter Password
		
		String pass = UtilityClass.readPropertyFileData("Pwd");
		login1.inpKiteLogin1PagePassword(pass);
		
		//click on login
		
		login1.clickKiteLogin1PageLoginBtn();
		
		Thread.sleep(3000);
		
		login2.kiteEnterPin(UtilityClass.readPropertyFileData("pin"));
		login2.clickContinueButton();
	
	}
	
	@Test
	public void verifyUserid() throws EncryptedDocumentException, IOException, InterruptedException {
		tcID ="201";
		Reporter.log("running verifyUserID test script");
		
		
		//driver.navigate().refresh();
		
		//Thread.sleep(3000);
		
		String exptUserID = UtilityClass.ReadExeleSheet(3, 1);
		String actUserID= home.getHomePageUID();
		
		
		UtilityClass.implicitWait(driver, 5);
		
		Assert.assertEquals(actUserID, exptUserID);
	
		
	}
		

	
	
	@AfterMethod
	public void takesceenshot(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			UtilityClass.takeScreenShot(driver,tcID);
		}
		
		Reporter.log("----logout From Application----");
		
		home.clickHomePageUserId();
		home.clickHomePageLogout();
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		
		Reporter.log("----close browser", true);
		
		Thread.sleep(3000);
		driver.close();
		
	}
	

}
