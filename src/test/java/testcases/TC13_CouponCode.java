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

public class TC13_CouponCode extends LaunchQuitTest {

	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() throws EncryptedDocumentException, IOException, InterruptedException {

		// Instantiate HomePage and perform sign-in flow
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Login using valid credentials
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product
		homepage.searchProduct();

		// Filter search results
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();

		// Select and view product details
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);
		
		// Verify with assertion
		pdpage.AsserrtPriceCheck();
		pdpage.AssertPublicReviews();
		pdpage.AssertProductDescriptions();

		// Add product to cart and proceed to checkout
		CartPage cartpage = new CartPage(driver);
		cartpage.addToCart();
		cartpage.goToCart();
		cartpage.proceedToBuy(driver);

		// Apply coupon code at checkout
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		// checkoutpage.chooseAddress();
		checkoutpage.couponCode();
		checkoutpage.applyCouponCode();
		
		//Verify with assertion
		checkoutpage.assertApplyCoupon();
		
	}
}
