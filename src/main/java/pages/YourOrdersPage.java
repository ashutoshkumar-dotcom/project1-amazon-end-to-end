package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourOrdersPage {

	// Dropdown button to select the order month
	@FindBy(xpath = "//span[@data-action='a-dropdown-button']")
	WebElement selectordermonth;

	// Dropdown item to select a specific order year
	@FindBy(xpath = "(//li[@class='a-dropdown-item'])[4]")
	WebElement selectorderyear;

	// Link to write a product review for a past order
	@FindBy(xpath = "(//*[contains(text(),'Write a product review')])[1]")
	WebElement selectwriteproductreview;

	// Element representing a 5-star rating selection
	@FindBy(xpath = "(//span[@class='in-context-ryp__form-field--starRating-single'])[5]")
	WebElement clickfivestar;

	// Textarea for entering the review content
	@FindBy(xpath = "//textarea[@name='reviewText']")
	WebElement writereview;

	// Input field for the review title
	@FindBy(xpath = "//input[@name='reviewTitle']")
	WebElement reviewtitle;

	// Input field for the reviewer's display name
	@FindBy(xpath = "//input[@name='profileName']")
	WebElement reviewername;

	// Submit button for posting the product review
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement submitproductreview;

	// Clicks the dropdown to select order month.
	public void selectOrderMonth() {
		selectordermonth.click();
	}

	// Selects the order year from the dropdown.
	public void selectOrderYear() {
		selectorderyear.click();
	}

	// Clicks the option to write a product review.
	public void selectWriteProductReview() {
		selectwriteproductreview.click();
	}

	// Clicks on the 5-star rating to rate the product.
	public void clickFiveStar() {
		clickfivestar.click();
	}

	// Types the main review text.
	public void writeReviews() {
		writereview.sendKeys("This is Great Product");
	}

	// Fills in the title for the review.
	public void reviewTitle() {
		reviewtitle.sendKeys("Quality of Product");
	}

	// Clears and fills in the reviewer name.
	public void reviewerName() {
		reviewername.clear();
		reviewername.sendKeys("Ashutosh");
	}

	// Submits the product review.
	public void submitProductReview() {
		submitproductreview.click();
	}

	// Constructor that initializes the web elements on this page.
	public YourOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
