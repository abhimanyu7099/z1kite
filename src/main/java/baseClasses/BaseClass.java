package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import configuration.ConfigClass;
public class BaseClass {
	

	 WebDriver driver;
	
	public WebDriver lanchChrome() {
		System.setProperty("webdriver.chrome.driver",ConfigClass.chromepath );
		driver= new ChromeDriver(); 
		driver.get(ConfigClass.url); 
		driver.manage().window().maximize();	
		return driver;
		
	}
	
	public WebDriver FireFoxLaunch() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",ConfigClass.FireFoxPath);
	    driver= new FirefoxDriver(); 
		driver.get(ConfigClass.url);
		driver.manage().window().maximize(); 
		return driver;
}

	public WebDriver edegeDriver() {
        System.setProperty("webdriver.edge.driver",ConfigClass.Edgepath);
		driver= new EdgeDriver(); 
		driver.get(ConfigClass.url);
		driver.manage().window().maximize();
		return driver;
	}
}