package gow.automation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import gow.TestComponents.BaseTest;
import gow.TestComponents.Retry;
import gow.pageobjects.CartPage;
import gow.pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest {
	@Test(groups= {"ErrorHandling"},retryAnalyzer = Retry.class )
	public void LoginErrorValidation() throws IOException, InterruptedException {
		//String ProductName = "ZARA COAT 3";
	 landingpage.loginApplication("gowthamdh1326@gmail.com", "Gaviranga13");
	 System.out.println("hi");
		//.ng-tns-c4-20.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error-Error Toast Container
		System.out.println(landingpage.getErrorMessage());
		 System.out.println("hi2");
		Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
		////div[@class='ng-tns-c4-24 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
		//name attribute is not available for this element id attribute is not available for this element

	}
	@Test
	public void ProductErrorOrder() throws IOException, InterruptedException {
		String ProductName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingpage.loginApplication("gowthamdh1326@gmail.com", "Gaviranga13@");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(ProductName);
		System.out.println("product added");
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertTrue(match);

}
    

}


