package gow.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class SubmitOrderStandalone {

	public static void main(String[] args) throws InterruptedException {
		String ProductName = "ZARA COAT 3";
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		//LandingPage log = new LandingPage(driver);
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("gowthamdh1326@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Gaviranga13@");
		driver.findElement(By.cssSelector("#login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> ele = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = ele.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		System.out.println("hi");
		Thread.sleep(3000);
		List<WebElement> CartPproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		// String cart  .ng-tns-c4-20.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		// =CartPproducts.stream().anyMatch(pro->prod.getText().equalsIgnoreCase(ProductName).to)
		Boolean cart = CartPproducts.stream().anyMatch(pro -> pro.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(cart);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".ta-results"))));
		driver.findElement(By.xpath(("(//button[contains(@class,'ta-item')])[2]"))).click();
		WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", placeOrder);
		// driver.findElement(By.cssSelector(".action__submit")).click();
		// driver.findElement(By.cssSelector(".action__submit")).click();
		String ConfirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(ConfirmationMessage, "THANKYOU FOR THE ORDER.");
		driver.close();

	}

}
