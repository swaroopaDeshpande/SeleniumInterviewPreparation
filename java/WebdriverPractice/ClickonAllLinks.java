package WebdriverPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickonAllLinks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-chat-card intercom-chat-card-borderless intercom-chat-card-with-avatar']"))).build().perform();
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total No of links avilable pn Login Page of google app is :" + listOfLinks.size());

		for (int i = 0; i < listOfLinks.size(); i++) {
			listOfLinks.get(i).click();
			driver.navigate().back();
			listOfLinks = driver.findElements(By.tagName("a"));


		}

	}

}
