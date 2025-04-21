package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {

	// Web element representing the "Get It in 2 Days" delivery filter
	@FindBy(xpath = "//span[.='Get It in 2 Days']")
	WebElement deliveryday;

	// Web element representing a specific brand filter (3rd checkbox in the list)
	@FindBy(xpath = "(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[3]")
	WebElement brand;

	// Web element representing the men's size 7 filter
	@FindBy(xpath = "//button[@value='7']")
	WebElement mensize;

	// Web element representing the "Premium Brands" fashion filter
	@FindBy(xpath = "//span[.='Premium Brands']")
	WebElement shoesfashionbrand;

	// Web element representing the "Sort By" dropdown menu
	@FindBy(xpath = "//span[@class='a-button-text a-declarative']")
	WebElement sortby;

	// Web element representing the "Price: Low to High" sorting option
	@FindBy(xpath = "//a[.='Price: Low to High']")
	WebElement lowtohigh;

	// Web element representing the "Price: High to Low" sorting option
	@FindBy(xpath = "//a[.='Price: High to Low']")
	WebElement hightolow;

	// Web element representing the "Avg. Customer Review" sorting option
	@FindBy(xpath = "//a[.='Avg. Customer Review']")
	WebElement custreview;

	// Web element representing the "Newest Arrivals" sorting option
	@FindBy(xpath = "//a[.='Newest Arrivals']")
	WebElement newestorder;

	// Web element representing the "Best Sellers" sorting option
	@FindBy(xpath = "//a[.='Best Sellers']")
	WebElement bestseller;

	// Clicks the "Get It in 2 Days" filter option.
	public void deliveryDay() {
		deliveryday.click();
	}

	// Clicks on a specific brand filter (3rd in the list).
	public void brands() {
		brand.click();
	}

	// Clicks on the men's size 7 filter.
	public void menSize() {
		mensize.click();
	}

	// Clicks on the "Premium Brands" filter under fashion category.
	public void shoesFashionBrand() {
		shoesfashionbrand.click();
	}

	// Opens the sort by dropdown menu.
	public void sortByM() {
		sortby.click();
	}

	// Selects the "Price: Low to High" sorting option.
	public void lowtoHigh() {
		lowtohigh.click();
	}

	// Selects the "Price: High to Low" sorting option.
	public void hightoLow() {
		hightolow.click();
	}

	// Selects the "Avg. Customer Review" sorting option.
	public void custReview() {
		custreview.click();
	}

	// Selects the "Newest Arrivals" sorting option.
	public void newestOrder() {
		newestorder.click();
	}

	// Selects the "Best Sellers" sorting option.
	public void bestSeller() {
		bestseller.click();
	}

	// Constructor initializes the WebElements using PageFactory.
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
