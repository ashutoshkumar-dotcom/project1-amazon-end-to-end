package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class TC05_SearchPage extends LaunchQuitTest {
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {
		// Create an object of HomePage and perform hover and sign-in click
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Create an object of LoginPage and perform login steps
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product on the homepage
		homepage.searchProduct();

		// Verifying the title of the page
		String searchpagetitle = driver.getTitle();
		Reporter.log(searchpagetitle);
		Assert.assertEquals(searchpagetitle, "Amazon.in : shoes", "sorry the title is wrong");
	}
}