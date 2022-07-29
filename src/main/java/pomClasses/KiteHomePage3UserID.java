package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage3UserID {
	// step1: declaration
	
		@FindBy(xpath="//span[@class='user-id']") private WebElement userid;
		@FindBy(xpath="(//button[@type='button'])[1]") private WebElement startInvBTN;
		@FindBy(xpath="//button[@class='button-outline']") private WebElement InvCloseBTN;
		@FindBy(xpath="//a[@href='/logout']") private WebElement logout;
		
		
		// step2: initialization
		
		public KiteHomePage3UserID (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		// usage
		
		public String getHomePageUID() {
			
		     String actText = userid.getText();
			return actText;
		}
		
		
		public void clickHomePageUserId() {
			userid.click();
		}
		
		public String getHomePageStartInvestBTN() {
			
		    String actTextbtn = startInvBTN.getText();
			return actTextbtn;
		}
		
		public void clickStartInvestButton() {
			startInvBTN.click();
		}
		
		public void closeInvestmentButton() {
			
			InvCloseBTN.click();
			
		}
		
		
		
		public void clickHomePageLogout() {
			logout.click();
		}

}
