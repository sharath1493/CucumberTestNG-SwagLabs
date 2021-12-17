package StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hook {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty()
	{
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchDriver()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void closeDriver()

	{
		driver.close();
	}

	@After (order =1)
	public void takeScreenshot(Scenario scenario)
	{	
		if(scenario.isFailed())
		{
			String methodname= scenario.getName();
			byte[] filebytestream = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(filebytestream, "image/png", methodname);
		}

	}

}
