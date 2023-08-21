package WebDriverManager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static Logger LOGGER = LogManager.getLogger(DriverManager.class);

	public static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void launchBrowser() {

		try {

			switch (Constants.Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching " + Constants.Constants.BROWSER);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Launching " + Constants.Constants.BROWSER);
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				LOGGER.info("Launching " + Constants.Constants.BROWSER);
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching " + Constants.Constants.BROWSER);
				driver = new EdgeDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching " + Constants.Constants.BROWSER);
				ChromeOptions optionss = new ChromeOptions();
				optionss.addArguments("--disable-notifications");
				driver = new ChromeDriver(optionss);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				break;
			}

		} catch (Exception e) {
			LOGGER.error("Error Message Logged !!! " + e);
		}

	}

}
