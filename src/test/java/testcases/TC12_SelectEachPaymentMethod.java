package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

//This test class extends LaunchQuitTest, which handles setup
public class TC12_SelectEachPaymentMethod extends LaunchQuitTest {

	// Test method with DataProvider and Retry Logic enabled
	@Test(dataProvider = "paymentMethods", retryAnalyzer = retry.RetryLogic.class)

	public void performEndToEndOperation(String paymentMethod)
			throws EncryptedDocumentException, IOException, InterruptedException {

		// Home Page - Hover and click sign-in
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Login Page - Enter credentials and log in
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product
		homepage.searchProduct();

		// Search Results Page - Apply filters
		SearchPage productsearchpage = new SearchPage(driver);
		productsearchpage.deliveryDay();
		// productsearchpage.brands();
		productsearchpage.menSize();
		productsearchpage.shoesFashionBrand();

		// Product Page - Select product and gather details
		ProductPage pdpage = new ProductPage(driver);
		pdpage.firstProduct(driver);
		pdpage.AsserrtPriceCheck();
		pdpage.AssertPublicReviews();
		pdpage.AssertProductDescriptions();

		// Cart Page - Add product to cart and proceed to buy
		CartPage cartpage = new CartPage(driver);
		cartpage.addToCart();
		cartpage.goToCart();
		cartpage.proceedToBuy(driver);

		// Checkout Page - Choose address, continue and select payment method
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		// checkoutpage.deliverToAddress();
		// checkoutpage.continueCheckout(driver);

		// Handle different payment methods based on DataProvider input
		switch (paymentMethod.toLowerCase()) {

		  case "cod": checkoutpage.selectCod(driver);
		  checkoutpage.codAssertion(driver); 
		  break;

		case "creditcard":
			checkoutpage.selectCreditDebit(driver);
			checkoutpage.creditdebitAssertion(driver);
			break;

		case "netbanking":
			checkoutpage.selectNetBanking(driver);
			checkoutpage.netbankingAsser(driver);
			break;

		case "otherupi":
			checkoutpage.selectOtherUpiApps(driver);
			checkoutpage.otherupiappsAsser(driver);
			break;

		case "emi":
			checkoutpage.selectEmi(driver);
			checkoutpage.emiAsser(driver);
			break;

		default:
			throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
		}

	}

	// DataProvider to run the test for multiple payment methods
	@DataProvider(name = "paymentMethods")
	public Object[][] getPaymentMethods() {
		return new Object[][] { 
			{ "cod" },
			{ "creditcard" },
			{ "netbanking" }, 
			{ "otherupi" }, 
			{ "emi" }, };
	}
}