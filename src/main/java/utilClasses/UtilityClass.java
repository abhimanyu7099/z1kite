package utilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configuration.ConfigClass;

public class UtilityClass {
	
	 WebDriver driver;

	public static void takeScreenShot( WebDriver driver, String tcID) throws IOException
	{              
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();          
		String str = d.toString();
		str=str.replace(" ", "_");
		str=str.replace(":", "_"); 
		
		File dest = new File (ConfigClass.screenshotpath+tcID+str+".jpeg");	
		FileHandler.copy(src, dest);
    }
	
	public static String ReadExeleSheet(int row, int col) throws EncryptedDocumentException, IOException {
		
		FileInputStream file= new FileInputStream(ConfigClass.getdata);
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String user = sheet.getRow(row).getCell(col).getStringCellValue();

		System.out.println(user);
		
		return user;
	}
	
	
	public static String  readPropertyFileData (String key) throws IOException {
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("D:\\new -ecalipse-workspace\\kite.zerodha\\src\\main\\resources\\credential\\zerodha login");
		p.load(file);
		String value = p.getProperty(key);
		
		System.out.println("-----reading property file---------");
		return value;

	}
	
	
	@SuppressWarnings("deprecation")
	public static void implicitWait(WebDriver driver,int time) {
		
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	public WebElement expliciteWait(WebElement element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		
		 WebElement elementReturn = wait.until(ExpectedConditions.visibilityOf(element));;
		 
        return elementReturn;
	}
	
}
