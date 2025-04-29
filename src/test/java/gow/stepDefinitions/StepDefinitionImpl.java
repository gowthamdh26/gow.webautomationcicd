package gow.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import gow.TestComponents.BaseTest;
import gow.pageobjects.CartPage;
import gow.pageobjects.CheckoutPage;
import gow.pageobjects.ConfirmationPage;
import gow.pageobjects.LandingPage;
import gow.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")

	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchapplication();
	}

	@Given("^Logged in with username (.+) and passord (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		productCatalogue = landingpage.loginApplication(username, password);
	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String ProductName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(ProductName);
	}
	
//	@When("^I add product (.+) to Cart$")
//	public void i_add_product_to_cart(String productName) throws InterruptedException
//	{
//		List<WebElement> products = productCatalogue.getProductList();
//		productCatalogue.addProductToCart(productName);
//	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String ProductName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartPage.goToCheckout();
		checkoutpage.selectCountry("India");
		confirmationPage = checkoutpage.submitOrder();

	}

	// Then "THANKYOU FOR THE ORDER." message is dispalyed on confirmatioPage
	@Then("{string} message is displayed on confirmationPage")
	public void message_displayed_confirmationPage(String string) {
		String confirmMessage = confirmationPage.verifyconfirmationMessage();
		//Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	  //@Then("{string} message is displayed on confirmationPage")
	  // public void message_displayed_confirmationPage(String string)
	  // {
	// 	String confirmMessage = confirmationPage.verifyconfirmationMessage();
	//		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	//		driver.close();
	 //   }
	
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String str) throws Throwable {
		Assert.assertEquals(str,landingpage.getErrorMessage());
		driver.close();;
	}
	

}
