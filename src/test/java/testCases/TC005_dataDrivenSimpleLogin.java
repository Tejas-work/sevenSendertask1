package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepository.Komoot_LandingPage;
import objectRepository.Komoot_LoginPage;

public class TC005_dataDrivenSimpleLogin {
	public static WebDriver driver;

	public static String decodedStr(String encodedStr) {
		byte[] decoded = Base64.decodeBase64(encodedStr);
		return new String(decoded);
	}

	@BeforeTest
	public void LaunchBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\resources\\data.properties");
		prop.load(fis);

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String userName = prop.getProperty("userName");
		System.out.println("Browser = " + browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		System.out.println("URL : " + url);
		System.out.println("User : " + userName);
		driver.get(url);

	}

	@Test
	public void DataDrivernLoginTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		Komoot_LandingPage LandingPage = new Komoot_LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage.acceptAll()));
		LandingPage.acceptAll().click();
		LandingPage.signUp().click();

		Komoot_LoginPage LoginPage = new Komoot_LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPage.email()));
		LoginPage.email().sendKeys("joan34p_y743a@hexud.com");
		LoginPage.continueWithEmail().click();
		wait.until(ExpectedConditions.visibilityOf(LoginPage.password()));
		LoginPage.password().sendKeys(decodedStr("am9hbjM0cF95NzQzYUBoZXh1ZC5jb21N"));
		LoginPage.logIn().click();
		wait.until(ExpectedConditions.visibilityOf(LoginPage.user()));
		String actualUser = LoginPage.user().getText();
		String expectedUser = "Admin User";
		Assert.assertEquals(expectedUser, actualUser);
		System.out.println("Expected User = " + actualUser);
	}

	@AfterTest(alwaysRun = true)
	public void CloseBrowser() {
		System.out.println("#### Test End ####");
		driver.quit();
	}

}
