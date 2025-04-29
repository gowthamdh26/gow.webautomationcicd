package gow.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gow.AbstractComponents.AbstractComponent;

public class ProductCatalogue  extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
   By addToCart= By.cssSelector(".card-body button:last-of-type");
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
    By poductsBy=	By.cssSelector(".mb-3");
    By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(poductsBy);
		return products;
	}
	public WebElement getProductByName(String ProductName) {
		WebElement prod=
		 getProductList() .stream()
		.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName))
		.findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String ProductName) throws InterruptedException {
	WebElement prod= getProductByName( ProductName);
	prod.findElement(addToCart).click();
	
	//waitForElementToAppear(toastMessage);
	//waitForElementToDisappear(spinner);
	Thread.sleep(3000);
	
	}

}
