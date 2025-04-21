package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {

	WebDriver driver;

	// locate elements for Account and List
	@FindBy(xpath = "//span[@class='nav-line-2 ']")
	WebElement clickAccountsandList;

	// locate elements for order
	@FindBy(xpath = "(//*[.='Your Orders'])[3]")
	WebElement order;

	// locate elements for Start here hover over
	@FindBy(linkText = "Start here.")
	WebElement clickStartHere;

	// locate elements for signIn
	@FindBy(xpath = "//span[.='Sign in']/parent::a") // (//span[.='Sign in'])[1]
	WebElement signIn;

	// locate elements for ManageProfiles
	@FindBy(xpath = "//button[.='Manage Profiles']")
	WebElement clickManageProfiles;

	// locate elements for WhoIsShopping page view
	@FindBy(xpath = "//a[@data-testid='profile-view-button']")
	WebElement clickViewWhoIsShopping;

	// locate search box for search product
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchproduct;

	// locate search box for search product
	@FindBy(xpath = "//div[text()='Your Profile']")
	WebElement yourprofileasser;

	// method for hover over action
	public void hoverover(WebDriver driver) {

		Actions ac = new Actions(driver);
		ac.moveToElement(clickAccountsandList).perform();
	}

	public void orderedPro() {
		order.click();
	}

	// method for Start here. hyperlink
	public void startHere() {

		clickStartHere.click();
	}

	public void signInClick(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signIn));
		signIn.click();
	}

	public void manageProfile() {
		clickManageProfiles.click();

	}

	public void viewWhoIsShopping() {
		clickViewWhoIsShopping.click();
	}

	public void assertSuccessfulProfile() {
		// Perform hard assertion to verify page title
		String profile = yourprofileasser.getText();
		Reporter.log(profile);
		Assert.assertEquals(profile, "Your Profile");
	}

	public void searchProduct() {
		searchproduct.sendKeys("shoes" + Keys.ENTER);
	}

	// initialize the constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
