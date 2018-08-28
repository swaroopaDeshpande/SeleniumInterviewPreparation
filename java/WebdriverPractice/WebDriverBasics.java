package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverBasics {

	public static void main(String args[]) {
		// launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Launch url
		driver.get("http://www.google.com");

		String title = driver.getTitle();
		if (title.equals("Google") ) {
			System.out.println("Correct Title");
		} else {
			System.out.println("incorrect title");
		}
		// driver.getPageSource();
		// driver.navigate().to("http://www.google.com");
		// refresh
		// driver.navigate().refresh();
		// driver.get("http://www.google.com");
		// driver.getCurrentUrl();
		// driver.get(driver.getCurrentUrl());
		// (Keys.F5)
		// WebElement
		// serachBox=driver.findElement(By.xpath("//input[@id='lst-ib']"));
		// serachBox.sendKeys(Keys.F5);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		if(currenturl.contains("gws_rd=ssl"))
		{
			System.out.println("redirectimg");
		}
		driver.quit();
	}

}
