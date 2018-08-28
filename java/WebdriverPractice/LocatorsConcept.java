package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	public static void main(String[] args) {
		// https://www.phptravels.net/register

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/register");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// verification point
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Register")) {
			System.out.println("You are on correct page");
		} else {
			System.out.println("You are on Wrong page");
		}

		// elements

		WebElement firstName = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']"));
		firstName.clear();
		firstName.sendKeys("Test_Auto1");
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.clear();
		lastname.sendKeys("auto");
		WebElement phoneNo = driver.findElement(By.xpath("//input[@type='text' and @name='phone']"));
		phoneNo.clear();
		phoneNo.sendKeys("2555555555");
		WebElement Email = driver.findElement(By.name("email"));
		Email.clear();
		Email.sendKeys("Test123@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("Test@123");
		WebElement ConfirmPwd = driver.findElement(By.name("confirmpassword"));
		ConfirmPwd.clear();
		ConfirmPwd.sendKeys("Test@123");
		WebElement SignUpBtn = driver.findElement(
				By.xpath("//button[@type='submit' and @class='signupbtn btn_full btn btn-action btn-block btn-lg'] "));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", SignUpBtn);
		// Validation point
		WebElement ConfirmationMsg = driver.findElement(By.xpath("//h3[contains(text(),'Hi, Test_Auto1 auto')]"));
		System.out.println(ConfirmationMsg);
		boolean flag = ConfirmationMsg.isDisplayed();
		if (flag) {
			System.out.println("Sucessful login");
		} else {
			System.out.println("User already exits");
		}
		// driver.quit();

	}

}
