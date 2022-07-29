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
import pomClasses.KiteLogin1Page;
import utilClasses.UtilityClass;

public class KiteLoginTest1 {
	
	KiteLogin1Page login1; 
	WebDriver driver;
	BaseClass base ;
	
	String tcID;
	
	@BeforeClass
	public void openBrowser(){

		
	 Reporter.log("---open browser",true);
	 base =new BaseClass();
	 driver= base.lanchChrome();
	 login1 =new KiteLogin1Page(driver);  // pass driver constructor declare
	 
	}
	
	@BeforeMethod
	public void beforemethod_referesh() {
		driver.navigate().refresh();
	}
	
	@Test
	public void LoginScenarion1_EnterOnly_Username() throws EncryptedDocumentException, IOException {
		tcID ="102";
		Reporter.log("---- Login Negative Test- Balnk Password----", true);	
		login1.inpKiteLogin1PageUsername(UtilityClass.ReadExeleSheet(0, 0));
		login1.clickKiteLogin1PageLoginBtn();
		
		String actErrorMsg =login1.getKiteLogin1PageErrorMsgPWD();
		String expErrorMsg ="Password should be minimum 6 characters.";
		Assert.assertEquals(actErrorMsg,expErrorMsg);
		
	}
	
	@Test
	public void LoginScenarion2_EnterOnly_Password() throws EncryptedDocumentException, IOException {
		tcID ="103";
		Reporter.log("---- TC Name: Login Negative Test- Balnk UserID----", true);	
		login1.inpKiteLogin1PagePassword(UtilityClass.ReadExeleSheet(0, 0));
		login1.clickKiteLogin1PageLoginBtn();
		
		String actErrorMSG = login1.getKiteLogin1PageErrorMsgUN();
		String expErrorMsg="User ID should be minimum 6 characters.";
		Assert.assertEquals(actErrorMSG,expErrorMsg);
		
		
	}
	
	@Test
	public void LoginScenarion3() {
		
		tcID ="101";
		Reporter.log("----Login Negative Test- Blank credentials----", true);
		login1.clickKiteLogin1PageLoginBtn();
		
		String actErrorMSG1 = login1.getKiteLogin1PageErrorMsgUN();
		String expErrorMsg1="User ID should be minimum 6 characters.";
		Assert.assertEquals(actErrorMSG1,expErrorMsg1);
		
		String actErrorMsg2 =login1.getKiteLogin1PageErrorMsgPWD();
		String expErrorMsg2 ="Password should be minimum 6 characters.";
		Assert.assertEquals(actErrorMsg2,expErrorMsg2);
		
	}
	
	@AfterMethod
	public void takesceenshot(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityClass.takeScreenShot(driver,tcID);
		}
		
	}
	
	@AfterClass
	public void closeBrowser() {
		
		Reporter.log("----close browser", true);
		
		driver.close();
		
	}
}