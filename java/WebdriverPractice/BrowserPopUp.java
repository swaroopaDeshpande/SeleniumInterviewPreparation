package WebdriverPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopUp {

	public static void main(String[] args) throws InterruptedException {
		// window_Browser_PopUp
		// 1. alerts -- JavaScript Pop UP-- Alert API (accept, dismiss)
		// 2. File Upload pop up -- Browse Button (type = file, sendKeys(path)
		// 3. Browser Window Popup - Advertisement pop up (windowHandler API -
		// getWindowHandles() )

		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("http://www.popuptest.com/goodpopups.html");
		WebElement Btn = driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #3')]"));
		Btn.click();
		Thread.sleep(2000);

		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String ParentwindowID = it.next();
		System.out.println("Parrent window ID is :" + ParentwindowID);
		String ChildWindowID = it.next();
		System.out.println("Child Window ID is :" + ChildWindowID);

		driver.switchTo().window(ChildWindowID);
		Thread.sleep(2000);

		System.out.println("Title of current window is" + driver.getTitle());
		driver.close();

		driver.switchTo().window(ParentwindowID);
		System.out.println("Title of current window is " + driver.getTitle());
		driver.close();

	}

}
