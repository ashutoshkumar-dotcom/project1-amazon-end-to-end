package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

//Test case class for verifying product details and end-to-end flow on Amazon
public class TC07_ProductDetails extends LaunchQuitTest {

	// Test method to perform full user journey from login to product details view
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {

		// Initialize homepage object and perform hover + click sign-in
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Initialize login page object and perform login actions
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product from the homepage
		homepage.searchProduct();

		// Apply filters and refine search on the search result page
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();

		// Interact with product detail page
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);

		// Verifying with assertion
		pdpage.AsserrtPriceCheck();
		pdpage.AssertPublicReviews();
		pdpage.AssertProductDescriptions();
	}

}