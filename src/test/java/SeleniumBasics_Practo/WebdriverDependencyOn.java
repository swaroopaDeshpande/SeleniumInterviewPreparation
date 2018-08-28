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

public class WebdriverDependencyOn {
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
	
	@Test(priority=1)
	public void LoginPageTest()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
		userName.clear();
		userName.sendKeys("NaveenK");
		
		WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
		password.clear();
		password.sendKeys("Test@123");
		
		WebElement LgnBtn= driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", LgnBtn);
		
		driver.switchTo().frame("mainpanel");
		WebElement userTitle=driver.findElement(By.xpath("//td[@class='headertext']//font[contains(text(),'User: Naveen K')]"));
		String Title=userTitle.getText();
		Assert.assertEquals(Title, "  User: Naveen K "); 
	}
	
	@Test(priority=2,dependsOnMethods={"LoginPageTest"})
	public void SerachTest()
	{
		boolean flag=driver.findElement(By.xpath("//input[@type='text' and @name='search' ]")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	
	

}
