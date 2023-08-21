package CommonUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import PageObjects.DirectoryPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import StepDefination.Common_Step_Definations;
import StepDefination.VerifyCEOName_StepDef;
import WebDriverManager.DriverManager;

public class CommonUtils {

	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtils.getcommonUtilsInstance());
	
	// Singleton design pattern to create POM page object
	private static CommonUtils commonUtilsInstance = null;

	private CommonUtils() {
	}

	public static CommonUtils getcommonUtilsInstance() {
		if (commonUtilsInstance == null) {
			commonUtilsInstance = new CommonUtils();
		}
		return commonUtilsInstance;
	}

	public void loadProperties() {

		Properties properties = new Properties();

		try {

			properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.Constants.APPURL = properties.getProperty("APP_URL");
		Constants.Constants.USERNAME = properties.getProperty("USERNAME");
		Constants.Constants.PASSWORD = properties.getProperty("PASSWORD");

	}

	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getLoginPageInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomePageInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getDirectoryPageInstance());

	}

	public static void highLightWebElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border: 3px solid red');", element);
	}

	public void takeScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new Date());
		File scrnshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrnshotFile, new File(Common_Step_Definations.getScenarioName() + "_" + date + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectFromDropDown(WebElement dropDown, String howTo, String value) {

		Select se = new Select(dropDown);
		switch (howTo) {
		        case "index":
			                 se.selectByIndex(Integer.parseInt(value));
			          break;
		        case "value":
			                  se.selectByValue(value);
			          break;
		        case "text":
			                se.selectByVisibleText(value);
			          break;
		       default:
		    	   LOGGER.info("Please provide valid selection. Valid selections are : text,value,index.");
			           break;

		}
	}

}
