package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATHScenarios {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		//a//font[contains(text(),'Sign Up')]
		WebElement signBtn=driver.findElement(By.xpath("//a//font[contains(text(),'Sign Up')]"));
		int x=signBtn.getLocation().getX();
		int y=signBtn.getLocation().getY();
		signBtn.click();
		


		
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("NaveenK");;
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
		WebElement btn=driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor JS1= (JavascriptExecutor)driver;
		JS1.executeScript("argument[0].click();",btn );

	}

}
