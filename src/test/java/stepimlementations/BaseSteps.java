package stepimlementations;

import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import pages.BasePage;
import utils.driverfactory.WebDriverFactory;

public class BaseSteps {
	private BasePage basePage = new BasePage(WebDriverFactory.getWebDriver());
	@Пусть("(?:.*) заходит на сайт \"([^\"]*)\"$")
	public void openSite(String url) {
		basePage.openPage(url);
	}

	@Тогда("(?:.*) url будет \"([^\"]*)\"$")
	public void assertCurrentUrl(String url) {
		basePage.assertCurrentUrl(url);
	}
}
