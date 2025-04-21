package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.YourOrdersPage;

public class TC14_ProductReview extends LaunchQuitTest {

	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {
		// Create an instance of the HomePage class to interact with the homepage
		// elements
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Create an instance of the LoginPage class to interact with the login form
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();
		homepage.hoverover(driver);
		homepage.orderedPro();

		// Create an instance of the YourOrdersPage class to interact with order history page elements
		YourOrdersPage yourorderpage = new YourOrdersPage(driver);
		yourorderpage.selectOrderMonth(); // commented because the account which used not have past order 
		yourorderpage.selectOrderYear();
		yourorderpage.selectWriteProductReview();
		yourorderpage.clickFiveStar();
		yourorderpage.writeReviews();
		yourorderpage.reviewTitle();
		yourorderpage.reviewerName();
		yourorderpage.submitProductReview();

	}
}
