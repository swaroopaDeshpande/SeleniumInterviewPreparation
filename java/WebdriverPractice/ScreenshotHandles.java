package WebdriverPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotHandles {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/register/");
		takeSCreenShot("FreeCRM_RegistrationPage");

	}

	public static void takeSCreenShot(String fileName) throws IOException {
		// 1.take screenshot and store it in file format
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// 2.now copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(file,
				new File("C:\\Users\\HP\\workspace\\SeleniumInterviewPreparation\\java\\WebdriverPractice\\screenshots"
						+ fileName + ".jpg"));
	}

}
