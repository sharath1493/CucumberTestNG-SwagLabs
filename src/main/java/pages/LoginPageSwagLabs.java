package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageSwagLabs extends BaseActions {

	private WebDriver driver;
	//1. Constructor
	public LoginPageSwagLabs(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	//2. Locators
	private By textbox_username = By.id("user-name");
	private By textbox_password = By.id("password");
	private By button_signin = By.id("login-button");

	//3. Behaviors
	public void doLogin(String uname, String pwd)
	{
		doSendKeys(textbox_username, uname);
		doSendKeys(textbox_password, pwd);
		doClick(button_signin);
	}
	


}
