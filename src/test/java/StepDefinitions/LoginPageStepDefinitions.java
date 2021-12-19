package StepDefinitions;

import java.util.List;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageSwagLabs;
import utils.FrameworkConstants;

public class LoginPageStepDefinitions {

	LoginPageSwagLabs login;


	@Given("User launches the SwagLabs")
	public void user_launches_the_swag_labs() {
		//login.lauchApplication(FrameworkConstants.URL);
		//DriverFactory.getDriver().get(FrameworkConstants.URL);

		login = new LoginPageSwagLabs(DriverFactory.getDriver());
		login.lauchApplication(FrameworkConstants.URL);

	}

	@Then("URL of the page should be {string}")
	public void url_of_the_page_should_be(String url) {

		String actURL = DriverFactory.getDriver().getCurrentUrl();

		Assert.assertEquals(url, actURL);

	}

	@Given("User landed on Swag Labs Application Home Page")
	public void user_landed_on_swag_labs_application_home_page() {

		String actURL = DriverFactory.getDriver().getCurrentUrl();

		Assert.assertEquals(actURL, FrameworkConstants.URL);

	}

	@When("User attempts to login with below credentials")
	public void user_attempts_to_login_with_below_credentials(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		
		List<String> credentials = dataTable.asList();
		System.out.println(credentials);
		login.doLogin(credentials.get(0), credentials.get(1));

	}

	@Then("user should be directed to product catalog page")
	public void user_should_be_directed_to_product_catalog_page() {
		
		String actURL = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertEquals(actURL, "https://www.saucedemo.com/inventory.html");
		

	}

}
