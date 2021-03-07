package stepimlementations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.aeonbits.owner.ConfigFactory;
import pages.TopPanel;
import utils.config.ServerConfig;
import utils.driverfactory.WebDriverFactory;

public class TopPanelSteps {
	private TopPanel topPanel = new TopPanel(WebDriverFactory.getWebDriver());
	private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

	@И("(?:.*) логинится в личном кабинете")
	public void login() {
		topPanel.clickLogoButton();
		topPanel.getAuthPopUp()
				.setEmail(cfg.userEmail())
				.setPassword(cfg.userPassword())
				.clickSubmitButton();
	}

	@И("(?:.*) логинится с некорректным паролем")
	public void loginWithIncorrectData() {
		topPanel.clickLogoButton();
		topPanel.getAuthPopUp()
				.setEmail(cfg.userEmail())
				.setPassword(cfg.incorrectPassword())
				.clickSubmitButton();
	}

	@И("(?:.*) переходит в личный кабинет")
	public void goToAccount() {
		topPanel.goToAccount();
	}

	@Тогда("^на верхней панеле отображается имя пользователя \"([^\"]*)\"$")
	public void assertUserName(String name) {
		topPanel.assertName(name);
	}

	@Тогда("(?:.*) на попапе авторизации сообщение \"([^\"]*)\"$")
	public void assertErrorMessage(String message) {
		topPanel.getAuthPopUp().assertError(message);
	}
}
