package WebdriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import util.Constantvars;
import util.Synchronization_Points;

public class ActionsClassDragDropConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.driver","C:\\Users\\HP\\workspace\\SeleniumInterviewPreparation\\java\\BrowserEXE\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Synchronization_Points.page_Load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Synchronization_Points.implicitely_Wait, TimeUnit.SECONDS);

		driver.get(Constantvars.dragAndDrop_url);
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		WebElement draggable=driver.findElement(By.id("draggable"));
		WebElement droppable= driver.findElement(By.id("droppable"));
		
		Actions action=new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();
	}

}
