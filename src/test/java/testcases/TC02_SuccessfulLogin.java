package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

//This class performs a test case for successful login on Amazon
// It extends LaunchQuitTest, which handles browser setup
public class TC02_SuccessfulLogin extends LaunchQuitTest {

	// This test method will automatically retry if it fails, using RetryLogic class
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException {

		// Create an instance of HomePage using the WebDriver
		HomePage homepage = new HomePage(driver);

		// Hover over the account section to sign-in option
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Create an instance of LoginPage using the WebDriver
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		
		// Perform hard assertion to verify login successful
		loginpage.assertSuccessfulLogin();

	}
}
