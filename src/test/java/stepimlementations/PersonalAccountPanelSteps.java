package stepimlementations;

import cucumber.api.java.ru.И;
import org.aeonbits.owner.ConfigFactory;
import pages.PersonalAccountPanel;
import utils.config.ServerConfig;
import utils.driverfactory.WebDriverFactory;

public class PersonalAccountPanelSteps {
	private PersonalAccountPanel personalAccountPanel = new PersonalAccountPanel(WebDriverFactory.getWebDriver());
	private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

	@И("(?:.*) переходит на вкладку \"([^\"]*)\"$")
	public void openTabByName(String tabName) {
		personalAccountPanel.openTabByName(tabName);
	}
}
