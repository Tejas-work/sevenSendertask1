package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Komoot_LandingPage {

	WebDriver driver;

	public Komoot_LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Accept All')]")
	WebElement acceptAll;

	@FindBy(xpath = "(//span[contains(text(),'Sign up')])[1]")
	WebElement signUp;
	
	@FindBy(css = "div[class*='print:tw-hidden']")
	WebElement pageModule;
	
	public WebElement signUp() {
		return signUp;
	}

	public WebElement acceptAll() {
		return acceptAll;
	}

	public WebElement pageModule() {
		return pageModule;
	}

}
