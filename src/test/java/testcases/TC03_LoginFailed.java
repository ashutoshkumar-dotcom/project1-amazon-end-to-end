package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

//This test class extends LaunchQuitTest
public class TC03_LoginFailed extends LaunchQuitTest {
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException {
		// Initialize the HomePage object using the WebDriver
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Verify that the user's name is displayed after successful login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.wrong_username();
		loginpage.continue_btn2();
		loginpage.wrong_password();
		loginpage.sign_in2();
		
		// Perform hard assertion
		loginpage.assertUnsuccessfulLogin();

	}
}
