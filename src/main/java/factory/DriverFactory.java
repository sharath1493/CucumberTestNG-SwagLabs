package factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.FrameworkConstants;

public class DriverFactory {

	public WebDriver driver;
	public static final String runtype = FrameworkConstants.RUNTYPE;


	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser)
	{

		System.out.println("Browser selected is: "+browser);

		if(browser.equals("chrome"))
		{
			if(runtype.equals("REMOTE"))
			{
				String methodName = "SwagLabs Test "+ Math.random();
				MutableCapabilities sauceOpts = new MutableCapabilities();
				sauceOpts.setCapability("name", methodName);
				sauceOpts.setCapability("build", "Java-W3C-Examples");
				sauceOpts.setCapability("seleniumVersion", "4.0.0");
				sauceOpts.setCapability("username", "oauth-sharath1493-3f118");
				sauceOpts.setCapability("accessKey", "82e5cce2-53f3-448d-a43f-b8cef26236b7");
				sauceOpts.setCapability("tags", "w3c-chrome-tests");

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("sauce:options", sauceOpts);
				cap.setCapability("browserVersion", "latest");
				cap.setCapability("platformName", "Windows 10");
				cap.setCapability("browserName", browser);


				try {
					driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					tlDriver.set(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}

			}
			else {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
			}

		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());

		}
		else
		{
			System.out.println("Please pass correct browser value "+browser);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();

	}

	public static synchronized WebDriver getDriver() 
	{
		return tlDriver.get();

	}


}
