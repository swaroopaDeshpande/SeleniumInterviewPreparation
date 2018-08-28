package WebdriverPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoDriverLaunch {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\selenium\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}

}
