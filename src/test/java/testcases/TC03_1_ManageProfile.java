package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

//This test class extends LaunchQuitTest
public class TC03_1_ManageProfile extends LaunchQuitTest {

	// This test method performs an end-to-end operation and retry on failure using
	// RetryLogic
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {
		// Instantiate the HomePage object using the WebDriver
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Initialize the LoginPage object using the WebDriver
		LoginPage loginpage = new LoginPage(driver);

		// Enter a correct username
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();

		// Verify that the user's name is displayed after successful login
		loginpage.assertSuccessfulLogin();
		homepage.hoverover(driver);
		homepage.manageProfile();
		homepage.viewWhoIsShopping();

		// Perform hard assertion to verify page title
		homepage.assertSuccessfulProfile();

	}
}
