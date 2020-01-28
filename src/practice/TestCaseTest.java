package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCaseTest extends DriverSetup {

	@Test
	public static void testcaseTest() throws InterruptedException {

		driversetup("https://www.amazon.in/");
		exceldataFetch();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(mobilename);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		String winHandleBefore = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement button = driver.findElement(By.xpath("//a/span[(contains(text(), 'XR (64GB) - Yellow'))]"));
		js.executeScript("arguments[0].click();", button);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebElement ele = driver.findElement(By.id("priceblock_ourprice"));
		Thread.sleep(2000);
		String AmazonPrice = ele.getText().replace(".00", "").replaceAll("[^0-9]","").trim();
		int priceamazon = Integer.parseInt(AmazonPrice);
		System.out.print(priceamazon);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.close();
		driversetup("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div[(contains(@class ,'_3N'))]/button")).click();
		exceldataFetch();
		driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys(mobilename);
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		Thread.sleep(2000);
		String winHandleBefore1 = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[contains(text(), 'Apple iPhone XR (Yellow, 64 GB)')][1]")).click();
		for(String winHandle1 : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle1);
		}
		String flipkartPrice = driver
				.findElement(By.xpath(
						"//div[(contains(@class,'_1v'))]"))
				.getText().replaceAll("[^0-9]","").trim();
		int priceflipkart = Integer.parseInt(flipkartPrice);
		driver.close();
		
		if(priceamazon >priceflipkart) {
			System.out.println("Price of amazon is["+priceamazon+"] Higher than that of flipkart which is ["+priceflipkart+"]");
			Reporter.log("Price of amazon is["+priceamazon+"] Higher than that of flipkart which is ["+priceflipkart+"]");
		}else {
			System.out.println("Price of flipkart is["+priceflipkart+"] Higher than that of amazon which is ["+priceamazon+"]");
			Reporter.log("Price of flipkart is["+priceflipkart+"] Higher than that of amazon which is ["+priceamazon+"]");
		}
		driver.switchTo().window(winHandleBefore1);
		driver.close();

	}
}
