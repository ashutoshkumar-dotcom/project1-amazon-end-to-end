package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

//This test class performs an end-to-end search and filter operation on the Amazon website.
public class TC06_SearchFilter extends LaunchQuitTest {

	// Test method to perform the end-to-end operation with retry logic in case of failure
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {
		// Create object of HomePage and perform hover and click on Sign-In
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Create object of LoginPage and perform login with valid credentials
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Perform product search from homepage
		homepage.searchProduct();

		// Create object of SearchPage and apply various filters
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();
		
		// Verifying the title of the page
		String searchpagetitle = driver.getTitle();
		Reporter.log(searchpagetitle);
		Assert.assertEquals(searchpagetitle, "Amazon.in : shoes", "sorry the title is wrong");

	}
}
