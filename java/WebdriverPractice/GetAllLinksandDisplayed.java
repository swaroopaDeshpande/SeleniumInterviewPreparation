package WebdriverPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Constantvars;
import util.Synchronization_Points;

public class GetAllLinksandDisplayed {

	public static void main(String[] args) {
		// https://www.thewarehouse.co.nz

		System.setProperty("webdriver.chrome.driver", Constantvars.driver_exe_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);

		driver.get("https://www.thewarehouse.co.nz");
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total No Of links are"+listOfLinks.size());
		for (int i = 0; i < listOfLinks.size(); i++) {
			System.out.println(listOfLinks.get(i).getText());
		}
	}

}
