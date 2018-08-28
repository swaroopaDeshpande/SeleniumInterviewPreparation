package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisisbilityTest {

	public static void main(String[] args) {
		// https://www.freecrm.com/register/

		// 1.isDisplyed(): Check availabilty of particular WebElement on PAGE
		// return true: if element is displayed.
		// return false"if element not displayed.

		// submitButton
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/register/");
		boolean flag = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(flag);
		// isEnabled(): if enables return true if diabled : false
		boolean flag1 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag1);
		// enabling submit btn by selecting on checkbox
		driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
		boolean flag3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag3);
		// isSelected=for checkbox,radiobtn,dropbox
		boolean flag4 = driver.findElement(By.xpath("//input[@name='agreeTerms']")).isSelected();
		System.out.println(flag4);// true
		// deselect checkbox
		driver.findElement(By.xpath("//input[@name='agreeTerms']")).click();
		// again check isEnabled for submit btn
		boolean flag5 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag5);// false
	}

}
