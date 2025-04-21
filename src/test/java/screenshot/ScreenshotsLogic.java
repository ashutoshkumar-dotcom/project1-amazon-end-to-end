package screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ScreenshotsLogic implements ITestListener {

	// WebDriver instance to capture screenshots
	public static WebDriver driver;

	// This method is executed when a test passes
	@Override

	// Log the success of the test case
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test case is pass ");

		// Cast WebDriver instance to TakesScreenshot to capture screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture the screenshot and store it as a file
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Format the current date and time to append as part of the file name
		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		// Define the destination path where the screenshot will be saved (for pass cases)
		File destination = new File(
				"C:\\WorkEnvironment\\Projects_MKT\\project6\\project1-amazon-end-to-end\\screenshot\\pass\\screenshot_"
						+ timestamp + ".png");
		try {
			FileHandler.copy(source, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method is executed when a test fails
	@Override
	public void onTestFailure(ITestResult result) {
		// Log the failure of the test case
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test case is fail ");

		// Cast WebDriver instance to TakesScreenshot to capture screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture the screenshot and store it as a file
		File source1 = ts.getScreenshotAs(OutputType.FILE);

		// Format the current date and time to append as part of the file name
		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		// Define the destination path where the screenshot will be saved (for fail cases)
		File destination1 = new File(
				"C:\\WorkEnvironment\\Projects_MKT\\project6\\project1-amazon-end-to-end\\screenshot\\fail\\screenshot_"
						+ timestamp + ".png");

		try {
			FileHandler.copy(source1, destination1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}