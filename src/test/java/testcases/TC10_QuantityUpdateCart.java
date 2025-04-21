package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class TC10_QuantityUpdateCart extends LaunchQuitTest {

	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {

		// Initialize the HomePage and perform mouse hover to reveal sign-in options
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// LoginPage actions, Enter valid credentials and log in
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product on the home page
		homepage.searchProduct();

		// Interact with search result filters and product list
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();

		// Product details page actions
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);
		
		// Verify with assertion
		pdpage.AsserrtPriceCheck();
		pdpage.AssertPublicReviews();
		pdpage.AssertProductDescriptions();

		// Cart actions
		CartPage cartpage = new CartPage(driver);
		cartpage.addToCart();
		cartpage.goToCart();
		cartpage.quantityUpdate();
		cartpage.quantityDecremented(driver);
		cartpage.removeItem(driver);
	}
}
