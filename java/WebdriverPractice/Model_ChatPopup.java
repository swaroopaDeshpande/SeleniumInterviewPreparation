package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Model_ChatPopup {

	public static void main(String[] args) throws InterruptedException {
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		//
		// driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		WebElement ModelPopup = driver.findElement(By.xpath(
				"//div[@class='intercom-chat-card intercom-chat-card-borderless intercom-chat-card-with-avatar']"));
		Actions action = new Actions(driver);
		action.moveToElement(ModelPopup).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']//span")).click();
		action.click();
	}

}
