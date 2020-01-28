package practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup extends Excel{
	public static WebDriver driver;
	public static void driversetup(String url) {

		String pathToChromeDriver = ".\\utils\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        
        
	}

}
