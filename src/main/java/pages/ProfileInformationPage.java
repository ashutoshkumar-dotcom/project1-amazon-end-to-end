package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileInformationPage {

	WebDriver driver;

	// Web element for the "Edit Profile" (pencil icon) button
	@FindBy(xpath = "//button[@class='edit-pencil-icon-button']")
	WebElement clickeditprofile;

	// Web element for the profile name input field
	@FindBy(xpath = "//input[@id='editProfileNameInputId']")
	WebElement renameprofile;

	// Web element for the "Continue" or "Save" button (3rd button of the specified class)
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement continueprofile;

	// Clicks the edit profile button to enable profile editing.
	public void editProfile() throws InterruptedException {
		clickeditprofile.click();
		Thread.sleep(2000);
	}

	// Clears the current profile name and enters a new one
	public void renameProfile() throws InterruptedException {
		renameprofile.clear();
		renameprofile.sendKeys("Manisha Kumari");
		Thread.sleep(2000);
	}

	// Clicks the continue button to save the changes made to the profile.
	public void continueProfile() throws InterruptedException {
		continueprofile.click();
		Thread.sleep(2000);
	}

	// Constructor initializes web elements using PageFactory.
	public ProfileInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
