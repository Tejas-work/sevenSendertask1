package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Komoot_LoginPage {
	WebDriver driver;

	public Komoot_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement email;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueWithEmail;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logIn;
	@FindBy(css = "div[class*='indicator--user']")
	WebElement user;

	public WebElement email() {
		return email;
	}

	public WebElement continueWithEmail() {
		return continueWithEmail;
	}

	public WebElement password() {
		return password;
	}

	public WebElement logIn() {
		return logIn;
	}

	public WebElement user() {
		return user;
	}

}
