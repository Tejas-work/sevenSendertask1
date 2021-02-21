package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Komoot_Discover {

	WebDriver driver;

	public Komoot_Discover(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class*='tw-text-xl']")
	List<WebElement> routesTitle;

	@FindBy(xpath = "//h2[contains(text(),'Discover Routes')]")
	WebElement discoverRoutes;

	public List<WebElement> routesTitle() {
		return routesTitle;
	}

	public WebElement discoverRoutes() {
		return discoverRoutes;
	}

}
