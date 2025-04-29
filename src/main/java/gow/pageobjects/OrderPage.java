package gow.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gow.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
WebDriver  driver;
@FindBy(css=".cartSection h3")
private List<WebElement> cartProducts;
@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productname;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}



	public Boolean VerifyOderDisplay(String Productname) {
	Boolean	match=productname.stream().anyMatch(product->product.getText().equalsIgnoreCase(Productname));
		return match;
			
	}
	

}
