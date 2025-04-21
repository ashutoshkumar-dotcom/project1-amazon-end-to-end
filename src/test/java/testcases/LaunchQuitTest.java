package testcases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import screenshot.ScreenshotsLogic;

@Listeners(screenshot.ScreenshotsLogic.class)

public class LaunchQuitTest extends ScreenshotsLogic {

	@Parameters("browser")
	@BeforeMethod
	public void launch(String nameofbrowser) {
		// Initialize browser driver based on parameter
		if (nameofbrowser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		if (nameofbrowser.equals("edge")) {
			driver = new EdgeDriver();
		}

		if (nameofbrowser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		// Open Amazon India home page and refresh once
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();

		// Maximize browser window and set implicit wait timeout
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod()
	public void quit() throws InterruptedException {
		// Wait for 2 seconds before closing the browser
		Thread.sleep(2000);
		driver.quit();

	}
}
