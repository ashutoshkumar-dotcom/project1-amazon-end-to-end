package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class TC11_EntireCheckoutProcess extends LaunchQuitTest {

	@Test//(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {
		// Navigate to HomePage and sign in
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Perform login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product
		homepage.searchProduct();

		// Apply filters on the Search Page
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();

		// View Product details
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);
		
		// Verify with assertion
		pdpage.AsserrtPriceCheck();
		pdpage.AssertPublicReviews();
		pdpage.AssertProductDescriptions();

		// Add to cart and proceed to checkout
		CartPage cartpage = new CartPage(driver);
		cartpage.addToCart();
		cartpage.goToCart();
		cartpage.quantityUpdate();
		cartpage.proceedToBuy(driver);

		// Perform checkout steps
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		// checkoutpage.chooseAddress();
		checkoutpage.deliverToAddress();
		checkoutpage.continueCheckout(driver);
		checkoutpage.selectCod(driver);  
		checkoutpage.usePaymentMethod(driver);
		checkoutpage.orderReview();
		
//		checkoutpage.placeOrder();
//		checkoutpage.reviewOrder();

	}
}
