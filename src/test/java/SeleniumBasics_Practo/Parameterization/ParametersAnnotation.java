package SeleniumBasics_Practo.Parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersAnnotation {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test
	@Parameters({ "email", "password" })
	public void loginTest(String email, String password) {
		driver.get("www.udemy.com/join/login-popup/");
		WebElement emailId = driver.findElement(By.xpath("//input[@name='email']"));
		emailId.clear();
		emailId.sendKeys(email);
		WebElement pswd = driver.findElement(By.xpath("//input[@name='password']"));
		pswd.clear();
		pswd.sendKeys(password);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='submit-id-submit']"));
		loginBtn.click();
	}

}
