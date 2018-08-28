package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import util.Constantvars;
import util.Synchronization_Points;

public class ActionClassMenuSubMenu {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", Constantvars.driver_exe_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);

		driver.get(Constantvars.url_ActionsPracto);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.className("menulink"))).build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//ul[@class='submenu']//a[contains(text(),'Courses')]")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}

}
