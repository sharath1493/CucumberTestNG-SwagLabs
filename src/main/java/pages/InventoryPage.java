package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BaseActions {

	private WebDriver driver;

	// Constructor
	InventoryPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	//Locators
	//Common Locators
	private By text_product_names = By.cssSelector("div.inventory_item_name");
	private By text_product_descrition = By.cssSelector("div.inventory_item_desc");
	private By button_add_to_cart = By.cssSelector("div.pricebar button");

	//Individual locators
	private By text_inventory_header_title = By.cssSelector("span.title");
	private By button_cart = By.cssSelector("a.shopping_cart_link");
	private By text_active_items_sort = By.cssSelector("span.active_option");

	//Behaviors
	public String getInventoryPageURL()
	{
		return getURL();
	}

	public boolean isCartDisplayed()
	{
		return isElementDisplayed(button_cart);
	}

	public String getHeaderTitle()
	{
		return getText(text_inventory_header_title);

	}

	public String getProductsOrderText()
	{
		return getText(text_active_items_sort);
	}
	
	public List<String> getProductNamesasList()
	{
		return getElementTexts(text_product_names);
	}

}
