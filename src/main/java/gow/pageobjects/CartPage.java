package gow.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gow.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;

	public CartPage(WebDriver driver)      
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> cartPproducts = driver.findElements(By.cssSelector(".cartSection h3"));
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	public Boolean VerifyProductDisplay(String Productname) {
	Boolean	match=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(Productname));
		return match;
			
	}
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return	 new CheckoutPage(driver);
	//	return checkoutpage;
		
	}
  

}
