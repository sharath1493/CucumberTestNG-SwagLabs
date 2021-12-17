package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	//1. Constructor
	BaseActions(WebDriver driver)
	{
		this.driver = driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//2. Generic Methods
	public void doSendKeys(By by, String text)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.clear();
		element.sendKeys(text);
	}
	
	public void doClick(By by)
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();

	}
	
	public void lauchApplication(String url)
	{
		this.driver.get(url);
	}


}
