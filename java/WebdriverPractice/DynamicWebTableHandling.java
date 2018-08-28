package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTableHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("NaveenK");
		;
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
		WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor JS1 = (JavascriptExecutor) driver;
		JS1.executeScript("arguments[0].click();", btn);
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);

		WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		contactLink.click();
		// Actions action = new Actions(driver);
		// action.moveToElement(contactLink).build().perform();
		// WebElement createContact=
		// driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		// createContact.click();

		String before_Xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String after_Xpath = "]/td[2]";

		for (int i = 4; i <= 7; i++) {
			String name = driver.findElement(By.xpath(before_Xpath + i + after_Xpath)).getText();
			System.out.println(name);
			if (name.contains("AA A ")) {
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i + "]/td[1]/input")).click();
			}
		}

	}

}
