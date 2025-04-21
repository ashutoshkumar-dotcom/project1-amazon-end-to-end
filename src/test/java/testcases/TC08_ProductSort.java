package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

//TC08_ProductSortTest extends LaunchQuitTest, which likely handles browser setup
public class TC08_ProductSort extends LaunchQuitTest {
	// retryAnalyzer is used to retry the test if it fails
	@Test(dataProvider = "sortby", retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation(String sort)
			throws EncryptedDocumentException, IOException, InterruptedException

	{
		// Create an object of HomePage and perform hover and sign-in operations
		HomePage homepage = new HomePage(driver);
		homepage.hoverover(driver);
		homepage.signInClick(driver);

		// Create an object of LoginPage and enter valid login credentials
		LoginPage loginpage = new LoginPage(driver);
		loginpage.correct_username();
		loginpage.continue_btn();
		loginpage.correct_password();
		loginpage.sign_in();
		loginpage.assertSuccessfulLogin();

		// Search for a product on the homepage
		homepage.searchProduct();

		SearchPage searchpage = new SearchPage(driver);
		searchpage.sortByM();

		// Handle different payment methods based on DataProvider input
		switch (sort.toLowerCase()) {

		case "lowtohigh":
			searchpage.lowtoHigh();
			break;

		case "hightolow":
			searchpage.hightoLow();
			break;

		case "custreview":
			searchpage.custReview();
			break;

		case "newest":
			searchpage.newestOrder();
			break;

		case "seller":
			searchpage.bestSeller();
			break;

		default:
			throw new IllegalArgumentException("Invalid sorting option: " + sort);
		}

	}

	// DataProvider to run the test for multiple payment methods
	@DataProvider(name = "sortby")
	public Object[][] sortByAvailableOptions() {
		return new Object[][] { { "lowtohigh" }, { "hightolow" }, { "custreview" }, { "newest" }, { "seller" }, };

	}
}
