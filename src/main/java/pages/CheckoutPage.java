package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CheckoutPage {

//	@FindBy(xpath="(//input[@name='destinationSubmissionUrl'])[2]")
//	WebElement chooseaddress;

	// Button to deliver to the selected address
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement delivertoaddress;

	// Button to proceed to checkout
	@FindBy(xpath = "//span[@class='a-button-text']")
	WebElement continuecheckout;

	// Payment method options
	@FindBy(xpath = "(//input[@type='radio'])[1]") // (//input[@name='ppw-instrumentRowSelection'])[2]
	WebElement creditdebit;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement netbanking;

	@FindBy(xpath = "(//input[@type='radio'])[3]")
	WebElement otherupiapps;

	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement emi;

	@FindBy(xpath = "(//input[@type='radio'])[5]")
	WebElement cod;

	// Assertion elements for payment methods

	@FindBy(xpath = "(//span[text()='Cash on Delivery/Pay on Delivery'])[2]")
	WebElement cod_assertion;

	@FindBy(xpath = "//span[text()='Credit or debit card']")
	WebElement creditdebit_assertion;

	@FindBy(xpath = "(//span[text()='Net Banking'])[2]")
	WebElement netbanking_asser;

	@FindBy(xpath = "//span[text()='Other UPI Apps']")
	WebElement otherupiapps_asser;

	@FindBy(xpath = "(//span[text()='EMI'])[2]")
	WebElement emi_asser;

//	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[2]")
//	WebElement amazonpaybalance;
//	
//	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[3]")
//	WebElement upi;
//	
//	@FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[4]")
//	WebElement creditdebit2;

	// Coupon Code input and apply button
	@FindBy(xpath = "//input[@name='ppw-claimCode']")
	WebElement couponcode;

	@FindBy(xpath = "//input[@name='ppw-claimCodeApplyPressed']")
	WebElement applycoupon;

	// Button to use the selected payment method
	@FindBy(xpath = "//input[@data-csa-c-slot-id='checkout-primary-continue-payselect']")
	WebElement usethispaymentmethod;

	// Review order and place order buttons
	@FindBy(xpath = "//*[@id=\"checkout-item-block-panel\"]/div[2]/div/div[2]/span/a")
	WebElement orderreview;

	@FindBy(xpath = "(//input[@value='Place your order'])[3]")
	WebElement placeorder;

	@FindBy(xpath = "//*[.='Review or edit your recent orders']")
	WebElement revieworder;
	
	@FindBy(xpath = "//h4[.='Your available balance']")
	WebElement assertcouponapply;

//	public void chooseAddress()
//	{
//		chooseaddress.click();
//	}

	public void deliverToAddress() {
		delivertoaddress.click();
	}

	public void continueCheckout(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(continuecheckout));
	}

	// select payment methods
	public void selectCreditDebit(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(creditdebit));
		if (!creditdebit.isSelected()) {
			creditdebit.click();
			wait.until(ExpectedConditions.elementToBeSelected(creditdebit));
		} else {
			Reporter.log("By default Credit Debit Card option was selected.");
		}
	}

	public void selectNetBanking(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(netbanking));
		if (!netbanking.isSelected()) {
			netbanking.click();
			wait.until(ExpectedConditions.elementToBeSelected(netbanking));
		} else {
			Reporter.log("By default NetBanking option was selected.");
		}
	}

	public void selectOtherUpiApps(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(otherupiapps));
		if (!otherupiapps.isSelected()) {
			otherupiapps.click();
			wait.until(ExpectedConditions.elementToBeSelected(otherupiapps));
		} else {
			Reporter.log("By default Other UPI option was selected.");
		}
	}

	public void selectEmi(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(emi));
		if (!emi.isSelected()) {
			emi.click();
			wait.until(ExpectedConditions.elementToBeSelected(emi));
		} else {
			Reporter.log("By default EMI option was selected.");
		}
	}

	public void selectCod(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cod));

		if (!cod.isSelected()) {
			cod.click();
			wait.until(ExpectedConditions.elementToBeSelected(cod));
		} else {
			Reporter.log("By default Cash on delivery option was selected.");
		}
	}

	public void codAssertion(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(cod_assertion));

		String codasser = cod_assertion.getText();
		System.out.println(codasser);
		Assert.assertEquals(codasser, "Cash on Delivery/Pay on Delivery", "Payment method mismatch detected!");

	}

	public void creditdebitAssertion(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(creditdebit_assertion));

		String cdasser = creditdebit_assertion.getText();
		System.out.println(cdasser);
		Assert.assertEquals(cdasser, "Credit or debit card", "Payment method mismatch detected!");

	}

	public void netbankingAsser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(netbanking_asser));

		String netasser = netbanking_asser.getText();
		System.out.println(netasser);
		Assert.assertEquals(netasser, "Net Banking", "Payment method mismatch detected!");

	}

	public void otherupiappsAsser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(otherupiapps_asser));

		String otherupiasser = otherupiapps_asser.getText();
		System.out.println(otherupiasser);
		Assert.assertEquals(otherupiasser, "Other UPI Apps", "Payment method mismatch detected!");
	}

	public void emiAsser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(emi_asser));

		String emiasser = emi_asser.getText();
		System.out.println(emiasser);
		Assert.assertEquals(emiasser, "EMI", "Payment method mismatch detected!");
	}

//	public void selectAmzpayBalance(WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); 
//		wait.until(ExpectedConditions.visibilityOf(amazonpaybalance));
//        wait.until(ExpectedConditions.elementToBeClickable(amazonpaybalance));
//		amazonpaybalance.click();
//	}

//	public void selectUpi(WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); 
//		wait.until(ExpectedConditions.visibilityOf(upi));
//        wait.until(ExpectedConditions.elementToBeClickable(upi));
//		upi.click();
//	}

//	public void creditDebit2(WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); 
//        wait.until(ExpectedConditions.elementToBeClickable(creditdebit2));
//		creditdebit2.click();
//	}

	public void couponCode() {
		couponcode.sendKeys("AMZSAVE10");
	}

	public void applyCouponCode() {

		applycoupon.click();
	}

	public void usePaymentMethod(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(usethispaymentmethod));
		button.click();
	}

	public void orderReview() {

		orderreview.click();
	}

	public void placeOrder() {
		placeorder.click();
	}

	public void reviewOrder() {
		revieworder.click();
	}

	public void assertApplyCoupon()
	{
		String assertcoupon=assertcouponapply.getText();
		Assert.assertEquals(assertcoupon, "Your available balance");
	}
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
