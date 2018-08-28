package SeleniumBasics_Practo.Parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametrizedTest {

	@Test
	@Parameters({ "url", "username", "password" })

	public void loginFreeCRMTest(String url, String username, String password) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
		WebElement uname = driver.findElement(By.xpath("//input[@name='username']"));
		uname.clear();
		uname.sendKeys(username);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("document.getElementbyName('password').value=password;");
		WebElement pswd = driver.findElement(By.name("password"));
		pswd.clear();
		pswd.sendKeys(password);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click();", loginBtn);
	}

}
