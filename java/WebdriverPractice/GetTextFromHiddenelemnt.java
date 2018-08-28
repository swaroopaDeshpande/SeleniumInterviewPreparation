package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFromHiddenelemnt {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\Cromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.inviul.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Javascript command
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text = js.executeScript("return document.getElementById('main').innerHTML").toString();
		System.out.println("Text on hompage is- "+text );
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
