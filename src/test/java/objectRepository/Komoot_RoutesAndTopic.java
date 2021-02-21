package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Komoot_RoutesAndTopic {

	WebDriver driver;

	public Komoot_RoutesAndTopic(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Browse routes')]")
	WebElement browseRoutesTopics;

	public WebElement browseRoutesTopics() {
		return browseRoutesTopics;
	}

}
