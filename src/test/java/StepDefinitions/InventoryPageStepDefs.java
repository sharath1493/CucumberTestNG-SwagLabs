package StepDefinitions;

import java.util.List;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;
import pages.LoginPageSwagLabs;
import utils.FrameworkConstants;

public class InventoryPageStepDefs {

	LoginPageSwagLabs login;
	InventoryPage inventory;


	@Given("Standard User logged into SwagLabs")
	public void standard_user_logged_into_swag_labs() {
		login = new LoginPageSwagLabs(DriverFactory.getDriver());
		login.lauchApplication(FrameworkConstants.URL);
		inventory = login.doLogin(FrameworkConstants.STANDARD_USER, FrameworkConstants.PASSWORD);

	}

	@Given("User is on Inventory Page")
	public void user_is_on_inventory_page() {
		Assert.assertEquals(inventory.getInventoryPageURL(), FrameworkConstants.INVENTORY_PAGE_URL);
	}

	@Then("Verify Cart button is dispalyed on Inventory Page")
	public void verify_cart_button_is_dispalyed_on_inventory_page() {
		Assert.assertTrue(inventory.isCartDisplayed());

	}

	@Then("Verify Page Header title displayed as {string}")
	public void verify_page_header_title_displayed_as(String text) {
		Assert.assertEquals(inventory.getHeaderTitle(), text);

	}

	@Then("Verify the default order of the product catalog is {string}")
	public void verify_the_default_order_of_the_product_catalog_is(String order) {
		Assert.assertEquals(inventory.getProductsOrderText(), order);

	}

	@Then("Verify the default product order as below")
	public void verify_the_default_product_order_as_below(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		
		
		List<String> expectedProductList = dataTable.asList();
		Assert.assertEquals(inventory.getProductNamesasList(), expectedProductList);

	}


	@Then("Verify the ProductName, Descritption, Price as below")
	public void verify_the_productname_description_price_as_below(DataTable dataTable) {
	}



	@Then("No. of products displayed on inventory page is {int}")
	public void no_of_products_displayed_on_inventory_page_is(Integer int1) {

	}



	@When("User changes the order of product catalog to {string}")
	public void user_changes_the_order_of_product_catalog_to(String string) {

	}




	@Then("No. of Add to Cart buttons displayed are {int}")
	public void no_of_add_to_cart_buttons_displayed_are(Integer int1) {

	}


}
