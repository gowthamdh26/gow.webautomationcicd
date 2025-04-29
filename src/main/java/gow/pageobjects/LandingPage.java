package gow.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gow.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;

	public LandingPage(WebDriver driver)      
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#userEmail")
	WebElement userEmail;
	@FindBy(css="#userPassword")
	WebElement userPassword;
	@FindBy(css="#login")
	WebElement submit;
	//.ng-tns-c4-20.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error-Error Toast Container
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
   public ProductCatalogue loginApplication(String email,String password) {
	   userEmail.sendKeys(email);
	   userPassword.sendKeys(password);
	   submit.click();
	   return new ProductCatalogue(driver);
	//   return productCatalogue;
   }
   public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
   }
   public String getErrorMessage() throws InterruptedException {
	   waitForWebElementToAppear(errorMessage);
	  // Thread.sleep(3000);
	String erroressage=   errorMessage.getText();
	return erroressage;
   }

}
