package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Constantvars;
import util.Synchronization_Points;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", Constantvars.driver_exe_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);

		driver.get(Constantvars.url_FreeCrm);

		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys(Constantvars.userName);

		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(Constantvars.Password);

		WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitBtn);
		Thread.sleep(2000);

		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);

		WebElement printLink = driver.findElement(By.xpath("//a[contains(text(),'Print') and @title='Print']"));
		printLink.click();

		WebElement AlertMsg = driver.findElement(By.xpath(
				"//div[@id='dispAlertMessage']//div[@class='alertMessage' and contains(text(),'This feature is not available for Free account. Please upgrade to pro account.')]"));
		System.out.println(AlertMsg.getText());

		// if(AlertMsg.getText().contains("This feature is not available for
		// Free account"))
		// {
		// System.out.println("Upgrade your account");
		// driver.findElement(By.linkText("Upgrade your account")).click();
		// }
		//
		// else
		// {
		// System.out.println("Utilized this print facility");
	}
}

// }
