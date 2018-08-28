package SeleniumBasics_Practo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webdriver_Basics {
	WebDriver driver;

	@BeforeMethod
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
	}

	@Test(priority = 2,groups={"HomePageTest"})
	public void freeCRMLogoTest() {
		boolean flag = driver.findElement(By.xpath("//img[@class='img-responsive' and @alt='free crm logo']"))
				.isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 1,groups={"LoginPageTest"})
	public void forgetPasswordLinkTest() {
		driver.findElement(By.xpath("//small[contains(text(),'Forgot Password?')]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO Log In Screen");
	}

	@Test(priority = 0,groups={"LoginPageTest"})
	public void signupTest() {
		
		WebElement signupBtn= driver.findElement(By.xpath("//button[@type='button' and @class='btn' and text()='Sign Up']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signupBtn);
		String ValidateTitle = driver.getTitle();
		System.out.println(ValidateTitle);
		Assert.assertEquals(ValidateTitle, "CRMPRO - CRM Pro for customer relationship management, sales, and support");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
