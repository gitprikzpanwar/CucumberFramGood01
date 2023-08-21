package PageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import CommonUtilities.CommonUtils;
import WebDriverManager.DriverManager;

public class LoginPage {

	// Singleton design pattern to create POM page object
	private static LoginPage loginPageInstance;

	private LoginPage() {

	}

	public static LoginPage getLoginPageInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new LoginPage();
		}
		return loginPageInstance;
	}

	//adding logger
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.getLoginPageInstance());
	
	/*
	 * Using PageFactory
	 * 
	 * //getting page webelements
	 * 
	 * @FindBy(name="username") 
	 * private WebElement USERNAME;
	 * 
	 * @FindBy(name="password") 
	 * private WebElement PASSWORD;
	 * 
	 * @FindBy(xpath="//button[@type='submit']") 
	 * private WebElement LOGIN_BTN;
	 * 
	 */

	
	// Using By Locators
	By USERNAME = By.name("username");
	By PASSWORD = By.name("password");
	By LOGIN_BTN = By.xpath("//button[@type='submit']");	
	
	
	WebDriver driver = DriverManager.getDriver();
	

	// creating action methods
	public void enterUserName(String username) {
		try {
			 CommonUtils.getcommonUtilsInstance().highLightWebElement(driver.findElement(USERNAME));
			 driver.findElement(USERNAME).sendKeys(username);
			 LOGGER.info("Username is entered");
		} catch (Exception e) {
			          System.out.println("Element Not Found. Trying to find again using explicit wait.");

			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
			} catch (Exception e2) {
			               System.out.println("Element Not Found. Check locator used");
			}
		}
	}

	public void enterPassword(String password) {
		try {
			CommonUtils.getcommonUtilsInstance().highLightWebElement(driver.findElement(PASSWORD));
			driver.findElement(PASSWORD).sendKeys(password);
			LOGGER.info("Password is entered.");
		} catch (Exception e) {
			        e.printStackTrace();
		}
	}

	public void clickingLoginButton() {
		try {
			CommonUtils.getcommonUtilsInstance().highLightWebElement(driver.findElement(LOGIN_BTN));
			driver.findElement(LOGIN_BTN).click();
			LOGGER.info("Login button is clicked.");
		} catch (Exception e) {
			         e.printStackTrace();
		}
	}
}

