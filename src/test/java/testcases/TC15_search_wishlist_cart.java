package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TC15_search_wishlist_cart extends LaunchQuitTest {

	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {

		// Create an object for HomePage class to interact with the homepage of the
		// Amazon site
		HomePage homepage = new HomePage(driver);
		homepage.searchProduct();

		// Create an object for ProductPage to interact with the selected product page
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);

		// Create an object for CartPage to interact with the cart page
		CartPage cartpage = new CartPage(driver);
		cartpage.addToCart();
		cartpage.goToCart();
		
		// Verify with assertion 
		cartpage.assertShoppinCart();

	}
}
