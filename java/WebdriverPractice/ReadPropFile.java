package WebdriverPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadPropFile {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Properties prop=new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\HP\\workspace\\SeleniumInterviewPreparation\\config.properties");
		
		prop.load(ip);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement emailId = driver.findElement(By.xpath("//input[@name='email']"));
		emailId.clear();
		emailId.sendKeys(prop.getProperty("email"));
		WebElement pswd = driver.findElement(By.xpath("//input[@name='password']"));
		pswd.clear();
		pswd.sendKeys(prop.getProperty("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='submit-id-submit']"));
		clickOn(driver, loginBtn, 30);
		

	}

	public static void clickOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
