package testcases;

import org.testng.annotations.Test;

import pages.HomePage;

//Test class for new user scenario, extending base setup from LaunchQuitTest
public class TC01_NewUser extends LaunchQuitTest {

	// Uses a retry in case the test fails
	@Test(retryAnalyzer = retry.RetryLogic.class)
	public void performEndToEndOperation() {

		// Create an instance of the HomePage, passing the driver to access web elements 
		HomePage homepage = new HomePage(driver);
		
		//hovering over the "Account & Lists"
		homepage.hoverover(driver);
		
		// Click on the "Start here" link for new users to begin registration
		homepage.startHere();

	}
}
