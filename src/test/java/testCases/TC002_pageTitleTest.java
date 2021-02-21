package testCases;

import java.util.Iterator;
import java.util.Set;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import objectRepository.Komoot_LandingPage;

public class TC002_pageTitleTest {
	public static WebDriver driver;

	public static String decodedStr(String encodedStr) {
		byte[] decoded = Base64.decodeBase64(encodedStr);
		return new String(decoded);
	}

	@BeforeTest
	public void LaunchBrowser() {
		System.out.println("#### Test Begin ####");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.komoot.com/");
	}

	@Test
	public void PageTitleTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Komoot_LandingPage LandingPage = new Komoot_LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage.acceptAll()));
		LandingPage.acceptAll().click();

		WebElement moduleAll = LandingPage.pageModule();
		// Click on all Discover, RoutePlanner and Features and open in new tab
		for (int i = 0; i < 3; i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			moduleAll.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(500L); // Can be deleted, then it's hard to Visualize
		}

		Set<String> abc = driver.getWindowHandles();
		Iterator<String> IT = abc.iterator();

		while (IT.hasNext()) {
			driver.switchTo().window(IT.next());
			String Current_Url = driver.getTitle();
			System.out.println(Current_Url);
		}

	}

	@AfterTest(alwaysRun = true)
	public void CloseBrowser() {
		System.out.println("#### Test End ####");
		driver.quit();
	}
}
