package WebdriverPractice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import util.Constantvars;
import util.Synchronization_Points;
import util.WebEventListener;

public class FlipKartActionClassPracto {
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;

	public static void main(String[] args) throws InterruptedException, IOException {
		// https://www.flipkart.com/
		System.setProperty("webdriver.chrome.driver", Constantvars.driver_exe_path);
		WebDriver driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		WebElement emailId = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text']"));
		emailId.clear();
		emailId.sendKeys("swar.deshpande@gmail.com");

		WebElement pwd = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='password']"));
		pwd.clear();
		pwd.sendKeys("swardeshpande");

		WebElement lgnBtn = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Login')]"));
		lgnBtn.click();
		Thread.sleep(3000);


		WebElement tvAppliances = driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]"));
		Actions action = new Actions(driver);

		action.moveToElement(tvAppliances).build().perform();
		Thread.sleep(5000);
		action.moveToElement(tvAppliances).build().perform();


		driver.findElement(By.xpath("//a[contains(text(),'Fully Automatic Front Load')]")).click();
		Thread.sleep(5000);

	}

}
