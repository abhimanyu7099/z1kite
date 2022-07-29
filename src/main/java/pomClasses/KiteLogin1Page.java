package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1Page {
	
	// step1: declaration
	
	@FindBy(xpath="//input[@id='userid']") private WebElement UN;
	
	@FindBy(xpath="//input[@id='password']") private WebElement Pwd;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement LoginBtn;
	
	@FindBy(xpath="//span[contains(text(),'Password should')]") private WebElement errorMsgPWD;
	
	@FindBy(xpath="//span[contains(text(),'User ID should')]") private WebElement errorMsgUN;
	
	
	// step2: initialization
	
	public KiteLogin1Page (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// usage
	public void inpKiteLogin1PageUsername(String Username) {
		UN.sendKeys(Username);
	}
	
	public void inpKiteLogin1PagePassword(String passward) {
		Pwd.sendKeys(passward);
	}
	
	public void clickKiteLogin1PageLoginBtn() {
		LoginBtn.click();
	}
	
	public String getKiteLogin1PageErrorMsgPWD() {
	String actText = errorMsgPWD.getText();
	return actText;
	
	}
	
	public String getKiteLogin1PageErrorMsgUN() {
		
		String actText = errorMsgUN.getText();
		return actText;
	}
	
}
