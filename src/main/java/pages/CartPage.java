package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//This class represents the Cart Page of Amazon using the Page Object Model (POM)
public class CartPage {

	// WebElement representing the 'Add to Cart' button
	@FindBy(xpath = "//input[@name='submit.add-to-cart']")
	WebElement addtocart;

	// WebElement for the 'Go to Cart' button
	@FindBy(xpath = "//*[@id='sw-gtc']")
	WebElement gotocart;

	// WebElement for increasing quantity (add one more)
	@FindBy(xpath = "(//span[@class='a-icon a-icon-small-add'])[1]")
	WebElement quantityupdate;

	// WebElement for decreasing quantity by one
	@FindBy(xpath = "//button[@aria-label='Decrease quantity by one']")
	WebElement quantitydecrement;

	// WebElement for removing an item from the cart
	@FindBy(xpath = "(//input[@class='a-color-link'])")
	WebElement removeitem;

	// WebElement for proceeding to buy (Proceed to checkout)
	@FindBy(xpath = "(//input[@class='a-button-input'])[1]")
	WebElement proceedtobuy;
	
	// Assertion
	@FindBy(xpath = "//h2[@id='sc-active-items-header']")
	WebElement assertshoppincart;
	

	// Method to click on 'Add to Cart'
	public void addToCart() {
		addtocart.click();
	}

	// Method to click on 'Go to Cart'
	public void goToCart() {
		gotocart.click();
	}

	// Method to increase the quantity of an item in the cart
	public void quantityUpdate() {
		quantityupdate.click();
	}

	// Method to decrease the quantity using JavaScriptExecutor for cases where
	// normal click may fail
	public void quantityDecremented(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(quantitydecrement));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", quantitydecrement);
		// quantitydecrement.click();
	}

	// Method to remove an item from the cart
	public void removeItem(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(removeitem));
		removeitem.click();
	}

	public void proceedToBuy(WebDriver driver) {
		proceedtobuy.click();
	}
	
	public void assertShoppinCart()
	{
		String shoppingcart=assertshoppincart.getText();
		Assert.assertEquals(shoppingcart, "Shopping Cart");
		
	}

	// Constructor initializes WebElements using PageFactory
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
