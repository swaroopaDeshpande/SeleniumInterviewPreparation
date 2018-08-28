package WebdriverPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsTagNameConcepts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println(listOfLinks.size());

		for (int i = 0; i < listOfLinks.size(); i++) {
			String text = listOfLinks.get(i).getText();
			System.out.println(text);
			if (!text.equals(null)) {
				listOfLinks.get(i).click();
				driver.navigate().back();
				listOfLinks = driver.findElements(By.tagName("a"));
			}
		
		}
	}
}
