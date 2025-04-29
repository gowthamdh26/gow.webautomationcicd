package gow.automation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gow.TestComponents.BaseTest;
import gow.pageobjects.CartPage;
import gow.pageobjects.CheckoutPage;
import gow.pageobjects.ConfirmationPage;
import gow.pageobjects.OrderPage;
import gow.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String ProductName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String>input)
			throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		System.out.println("hi");
		productCatalogue.addProductToCart(input.get("ProductName"));
		System.out.println("hi2");
		System.out.println("product added");
		
		CartPage cartPage = productCatalogue.goToCartPage();
		System.out.println("cartpage");
		Boolean match = cartPage.VerifyProductDisplay(input.get("ProductName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartPage.goToCheckout();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();
		String confirmMessage = confirmationPage.verifyconfirmationMessage();
		Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingpage.loginApplication("gowthamdh1326@gmail.com", "Gaviranga13@");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOderDisplay(ProductName));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {
	/*	HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "gowthamdh1326@gmail.com");
		map.put("password", "Gaviranga13@");
		map.put("ProductName", "ZARA COAT 3");
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "gauthamgowda1326@gmail.com");
		map1.put("password", "Gowthamdh1326@");
		map1.put("ProductName", "ADIDAS ORIGINAL");*/
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//gow//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
		
	}
	/*	@DataProvider
		public  void getData() {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			
			return new Object[][]
		}
*/
 

}
