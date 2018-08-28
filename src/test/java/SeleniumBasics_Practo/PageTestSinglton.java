package SeleniumBasics_Practo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTestSinglton {
	WebDriver driver;

	@BeforeMethod
	public void setUP() {
		DriverInit instanceDriver = DriverInit.getInstance();
		driver = instanceDriver.openBrowser();
	}

	@Test
	public void testMethod1() {
		driver.get("https://www.google.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
