package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

//TC09_CartTest extends LaunchQuitTest, which likely handles browser setup
public class TC09_Cart extends LaunchQuitTest {
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {

		// Navigate to the homepage and start the sign-in process
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Login with correct credentials
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product
		homepage.searchProduct();

		// Apply filters on the search results
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();

		// Interact with the product page
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);
		
		// verify with assertion
		pdpage.AsserrtPriceCheck();
		pdpage.AssertPublicReviews();
		pdpage.AssertProductDescriptions();

		// Add product to cart and navigate to cart
		CartPage cartpage = new CartPage(driver);
		cartpage.addToCart();
		cartpage.goToCart();
		
		// Verifying the title of the page to ensure profile update was successful
		String carttitle = driver.getTitle();
		Reporter.log(carttitle);
		Assert.assertEquals(carttitle, "Amazon.in Shopping Cart", "sorry the title is wrong");
	}

}
