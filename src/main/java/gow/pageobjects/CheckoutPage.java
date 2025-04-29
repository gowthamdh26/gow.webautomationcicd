package gow.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gow.AbstractComponents.AbstractComponent;


public class CheckoutPage extends AbstractComponent{
	WebDriver driver;

	public CheckoutPage(WebDriver driver)      
	{
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*Actions a = new Actions(driver);
	
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();

	wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".ta-results"))));
	driver.findElement(By.xpath(("(//button[contains(@class,'ta-item')])[2]"))).click();
	WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", placeOrder);*/
@FindBy(css="[placeholder='Select Country']")
WebElement Country;
@FindBy(css=".action__submit")
WebElement submit;
@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
WebElement selectCountry;
By results=By.cssSelector(".ta-results");

public void selectCountry(String countryName) {
Actions a = new Actions(driver);
	
	a.sendKeys(Country, countryName).build().perform();

	waitForElementToAppear(results);
	driver.findElement(By.xpath(("(//button[contains(@class,'ta-item')])[2]"))).click();
	WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", placeOrder);
	
	
}
public ConfirmationPage submitOrder()
{
	//submit.click();
	
	return new ConfirmationPage(driver);
	//return confirmationPage;
}
	
	
	
	
	
	
	
	}
  


