package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//This class represents the Product Page in the Amazon application.
public class ProductPage {

	// SoftAssert object allows assertions to continue even after failure
	SoftAssert softassert = new SoftAssert();

	// WebElement to locate the second product in the search results
	@FindBy(xpath = "(//a[@class='a-link-normal s-no-outline'])[2]")
	WebElement clickonfirstproduct;

	// WebElement to get the price of the first product
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement pricecheck;

	// WebElement to locate the reviews section of the product
	@FindBy(xpath = "//a[@class='a-profile']")
	WebElement reviews;

	// WebElement to locate the description section of the product
	@FindBy(xpath = "(//div[@class='a-section a-spacing-small'])[2]")
	WebElement descriptions;

	// Constructor to initialize all WebElements using PageFactory
	public void firstProduct(WebDriver driver) throws InterruptedException {
		clickonfirstproduct.click();

		// Switching control to the newly opened window
		Set<String> pcid = driver.getWindowHandles();
		Iterator<String> pc = pcid.iterator();
		String parentid = pc.next();
		System.out.println(parentid);
		String childid = pc.next();
		driver.switchTo().window(childid);

		Thread.sleep(2000);
	}

	// Method to check if the product price is above a certain threshold
	public void AsserrtPriceCheck() {

		String pricetag = pricecheck.getText();
		System.out.println(pricetag);

		// Remove commas and convert to integer
		int price = Integer.parseInt(pricetag.replaceAll(",", ""));
		System.out.println(price);

		// Assert that the price is greater than 700
		Assert.assertTrue(price > 700, "Price is less than expected: " + price);
	}

	// Method to check if public reviews are displayed
	public void AssertPublicReviews() {
		String review = reviews.getText();
		System.out.println(review);

		// Soft assert that review text is not empty
		softassert.assertFalse(review.isEmpty(), "Review expected text");
	}

	// Method to check if product description is available
	public void AssertProductDescriptions() {
		String descr = descriptions.getText();
		System.out.println(descr);

		// Soft assert that description is not empty
		softassert.assertFalse(descr.isEmpty(), "Description expected text.");
	}

	// Constructor initializes WebElements using PageFactory
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
