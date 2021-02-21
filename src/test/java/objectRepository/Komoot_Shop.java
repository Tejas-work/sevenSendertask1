package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Komoot_Shop {

	WebDriver driver;

	public Komoot_Shop(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Shop')]")
	WebElement shop;

	@FindBy(xpath = "//p[@class='css-15shjt2']")
	List<WebElement> packType;

	@FindBy(xpath = "(//*[contains(text(),'World Pack')])[1]")
	WebElement worldPack;

	public WebElement worldPack() {
		return worldPack;
	}

	public WebElement shop() {
		return shop;
	}

	public List<WebElement> packType() {
		return packType;
	}

}
