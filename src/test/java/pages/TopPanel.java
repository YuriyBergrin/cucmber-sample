package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.driverfactory.WebDriverFactory;

/**
 * Верхняя панель сайта
 */
public class TopPanel extends BasePage {
	private AuthPopUp authPopUp;

	public TopPanel(WebDriver driver) {
		super(driver);
		authPopUp = new AuthPopUp(WebDriverFactory.getWebDriver());
	}

	/**
	 * Вебэлементы
	 */

	@FindBy(css = "button[data-modal-id=\"new-log-reg\"]")
	private WebElement logoButton;
	@FindBy(css = ".header2__right p")
	private WebElement userLogoName;
	@FindBy(css = "[title=\"Личный кабинет\"]")
	private WebElement personalAccount;

	/**
	 * Методы
	 */
	public TopPanel clickLogoButton() {
		wait.until(ExpectedConditions.elementToBeClickable(logoButton)).click();
		return this;
	}

	public AuthPopUp getAuthPopUp() {
		return authPopUp;
	}

	public TopPanel assertName(String name) {
		Assert.assertEquals(name.toLowerCase(), userLogoName.getText().trim().toLowerCase());
		return this;
	}

	public void goToAccount() {
		moveToElement(userLogoName);
		wait.until(ExpectedConditions.elementToBeClickable(personalAccount)).click();
	}
}
