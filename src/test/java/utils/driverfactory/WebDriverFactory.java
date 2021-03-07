package utils.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	private static final int IMPLICIT_TIMEOUT_TIME = 5;

	private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

//	public WebDriverFactory() {
//	} зачем в образце пустой конструктор?

	public static void setupDriver() {
		logger.info("Инициализируем драйвер");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();//инициализируем опции драйвера
		options.addArguments("start-maximized");//задаем максимальный размер окна
		WebDriver driver = new ChromeDriver(options);//инициализируем драйвер
		driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT_TIME, TimeUnit.SECONDS);//задаем неявное ожидание
		webDriverThreadLocal.set(driver);
	}

	public static WebDriver getWebDriver() {
		return webDriverThreadLocal.get();
	}

	public static void quitDriver() {
		logger.info("Выходим из драйвера");
		Optional.ofNullable(getWebDriver()).ifPresent(WebDriver::quit);
	}
}
