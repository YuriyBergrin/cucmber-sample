package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthPopUp extends BasePage{
	public AuthPopUp(WebDriver driver) {
		super(driver);
	}

	/**
	 * Вебэлементы
	 */
	@FindBy(css = "[class=\"new-log-reg__form js-login\"] [name=\"email\"]")
	private WebElement emailInput;
	@FindBy(css = "[type=\"password\"]")
	private WebElement passwordInput;
	@FindBy(css = "[class=\"new-log-reg__form js-login\"] [type=\"submit\"]")
	private WebElement submitButton;
	@FindBy(xpath = "(//*[@class=\"new-log-reg__form js-login\"]//*[contains(@class,\"input-error\")])[1]")
	private WebElement errorMessage;

	/**
	 * Методы
	 */
	public AuthPopUp setEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}

	public AuthPopUp setPassword(String password) {
		passwordInput.sendKeys(password);
		return this;
	}

	public AuthPopUp clickSubmitButton() {
		submitButton.click();
		return this;
	}

	public AuthPopUp assertError(String message) {
		wait.until(ExpectedConditions.textToBePresentInElement(errorMessage,message));
		return this;
	}
}
