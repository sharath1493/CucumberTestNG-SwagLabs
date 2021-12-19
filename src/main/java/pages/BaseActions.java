package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

	/*
	 * Enter data in textbox by clearing before entering
	 * Pass By locator and Text to be entered
	 */
	public void doSendKeys(By by, String text)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.clear();
		element.sendKeys(text);
	}
	/*
	 * Clock on a button; pass By locator
	 */
	public void doClick(By by)
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();

	}

	/*
	 * Launch a URL; pass a URL String
	 */

	public void lauchApplication(String url)
	{
		this.driver.get(url);
	}

	/*
	 * Reading current URL on driver
	 */
	public String getURL()
	{
		return this.driver.getCurrentUrl();
	}

	/*
	 * Verify an Element is displayed; pass a by locator
	 */
	public boolean isElementDisplayed(By by)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();

	}

	/*
	 * to get text of an element; pass By locator
	 */
	public String getText(By by)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();

	}
	
	/*
	 * to get Element List of names; pass by locator
	 */
	public List<String> getElementTexts(By by)
	{
		List<WebElement> elements =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		List<String> l = new ArrayList<String>();
		for (WebElement e : elements)
		{
			l.add(e.getText());
		}
		return l;
		
	}
}
