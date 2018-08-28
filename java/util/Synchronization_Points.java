package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization_Points {

	public static int implicitely_Wait = 30;
	public static int page_Load_timeout = 50;
	


public static void main(String args[])
{
	
}

public static void clickOn(WebDriver driver,WebElement element,int timeout)
{
	new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
	element.click();
}
}