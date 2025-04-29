package gow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gow.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver)      
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	//String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		public String verifyconfirmationMessage() {
			CheckoutPage cp = new CheckoutPage(driver);
	String message=		confirmationMessage.getText();
	return message;
		}
	}
  


