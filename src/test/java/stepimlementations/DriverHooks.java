package stepimlementations;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.driverfactory.WebDriverFactory;

public class DriverHooks {
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

	@Before()
	public void setupDriver() {
		WebDriverFactory.setupDriver();
	}

	@After()
	public void quitDriver() {
		WebDriverFactory.quitDriver();
	}
}

