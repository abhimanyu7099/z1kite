package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage2 {
	// step1: declaration
	
		@FindBy(xpath="//input[@id='pin']") private WebElement pin;
		
		@FindBy(xpath="//button[@type='submit']") private WebElement conbtn;
		
		
		// step2: initialization
		
		public KiteLoginPage2 (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		// usage
		public void kiteEnterPin(String pinenter) {
			pin.sendKeys(pinenter);
		}
		
		public void clickContinueButton() {
			conbtn.click();
		}

}
