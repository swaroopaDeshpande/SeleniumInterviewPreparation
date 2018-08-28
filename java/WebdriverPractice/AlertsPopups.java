package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopups {

	// alert popups : you cannot inspect javascript popups

	public static void main(String[] args) {
		// input[@type='submit']

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		// staleElement ExceptionWebDriver driver=new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		WebElement goBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", goBtn);

		// javascript popup/alert pop up
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);

		alert.accept();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Rediffmail")) {
			WebElement link = driver.findElement(By.linkText("Create a new account"));
			link.click();
		}

		else {
			driver.navigate().to("https://www.google.com");
		}

	}

}
