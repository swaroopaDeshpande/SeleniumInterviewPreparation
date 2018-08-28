package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassRightClick {

	public static void main(String[] args) {
		// https://swisnl.github.io/jQuery-contextMenu/demo.html
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(" https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions action=new Actions(driver);
		WebElement rightClickBtn=driver.findElement(By.cssSelector(".context-menu-one"));
		action.contextClick(rightClickBtn).build().perform();
		//ul[@class='context-menu-list context-menu-root']//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']
		WebElement copy= driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		String copyText= copy.getText();
		System.out.println(copyText);
		copy.click();
	}

}
