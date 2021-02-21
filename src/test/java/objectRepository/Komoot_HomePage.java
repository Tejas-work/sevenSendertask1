package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Komoot_HomePage {

	WebDriver driver;

	public Komoot_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class*='tw-text-center tw-text-sm']")
	WebElement centerText;

	public WebElement centerText() {
		return centerText;
	}

}
