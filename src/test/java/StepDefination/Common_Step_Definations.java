package StepDefination;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CommonUtilities.CommonUtils;
import PageObjects.LoginPage;
import WebDriverManager.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Definations {

	private static Logger LOGGER = LogManager.getLogger(Common_Step_Definations.class);

	private static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.info("Execution Started.");

		try {
			  scenarioName = scenario.getName();

			LOGGER.info("Initiating CommonUtils and loading properties file");
			CommonUtils.getcommonUtilsInstance().loadProperties();
			LOGGER.info("Checking if driver is null or not.");
			if (DriverManager.getDriver() == null) {
				LOGGER.info("Driver is null initiating it.");
				DriverManager.launchBrowser();
				CommonUtils.getcommonUtilsInstance().initWebElements();

				login();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void login() {
		DriverManager.getDriver().get(Constants.Constants.APPURL);
		LoginPage.getLoginPageInstance().enterUserName(Constants.Constants.USERNAME);
		LoginPage.getLoginPageInstance().enterPassword(Constants.Constants.PASSWORD);
		LoginPage.getLoginPageInstance().clickingLoginButton();
	}

	
	@AfterStep
	public void attachScreenShot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] scrnshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scrnshotTaken, "image/png", "error_screen");
		}
	}
		
}
