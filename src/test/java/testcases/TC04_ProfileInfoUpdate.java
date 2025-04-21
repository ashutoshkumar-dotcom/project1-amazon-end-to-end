package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfileInformationPage;

//This class extends LaunchQuitTest, which handles setup
public class TC04_ProfileInfoUpdate extends LaunchQuitTest {

	// retryAnalyzer is used to retry the test case if it fails
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {
		// Creating an instance of HomePage and performing hover over the account menu
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Logging in using LoginPage object
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Navigating to Profile section
		homepage.hoverover(driver);
		homepage.manageProfile();
		homepage.viewWhoIsShopping();

		// Editing profile name
		ProfileInformationPage proinfopage = new ProfileInformationPage(driver);
		proinfopage.editProfile();
		proinfopage.renameProfile();
		proinfopage.continueProfile();

		// Verifying the title of the page to ensure profile update was successful
		String yourprofiletitile = driver.getTitle();
		Reporter.log(yourprofiletitile);
		Assert.assertEquals(yourprofiletitile, "Profile Hub", "sorry the title is wrong");

	}
}
