package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ddt.LoginDataProvider;

public class LoginPage {

	WebDriver driver;

	// creating object of DProvider class (DDT)
	LoginDataProvider provider = new LoginDataProvider();
	
	// step 1 locating
	@FindBy(name = "email")
	WebElement username;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signin;
	
	@FindBy(xpath="(//*[.='Hello, Manisha'])[1]")
	WebElement namedisplay;
	
	@FindBy(xpath="(//a[@class='a-link-normal'])[2]")
	WebElement loginfailedassertion;

	// step 2 initializing web elements: with correct credentials
	public void correct_username() throws EncryptedDocumentException, IOException {		
		provider.dProv();
		username.sendKeys(provider.un);		
	}

	public void continue_btn() {
		continueButton.click();
	}

	public void correct_password() throws EncryptedDocumentException, IOException {
		provider.dProv();
		password.sendKeys(provider.psw);
	}
	
	public void sign_in() {
		signin.click();
	}
	
	public void assertSuccessfulLogin()
	{
		String name=namedisplay.getText();
		Assert.assertEquals(name, "Hello, Manisha","Amazon Login Unsuccessful");
	}
	
//	public void searchTitleDisplay()
//	{
//		String producttitile=driver.getTitle();
////		System.out.println(producttitile);
////		Assert.assertEquals(producttitile, "Amazon.in : Shoes", "sorry the title is wrong");
//	}
	// step 3 initializing web elements: with incorrect credentials
	public void wrong_username() throws EncryptedDocumentException, IOException {		
		provider.dProv();
		username.sendKeys(provider.wrong_un);		
	}

	public void continue_btn2() {
		continueButton.click();
	}

	public void wrong_password() throws EncryptedDocumentException, IOException {
		provider.dProv();
		password.sendKeys(provider.wrong_psw);
	}
	
	public void sign_in2() {
		signin.click();
	}
	
	public void assertUnsuccessfulLogin()
	{
		String forgotText=loginfailedassertion.getText();
		Reporter.log(forgotText);
		Assert.assertEquals(forgotText, "Forgot password?","Amazon Login Unsuccessful");
	}
	

	// step 3 factory initialize the elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
