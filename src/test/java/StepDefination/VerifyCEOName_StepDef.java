package StepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CommonUtilities.CommonUtils;
import PageObjects.DirectoryPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import WebDriverManager.DriverManager;
import io.cucumber.java.en.*;

public class VerifyCEOName_StepDef {

	private static Logger LOGGER = LogManager.getLogger(VerifyCEOName_StepDef.class);

	@Given("The user is logged in successfully and is on Home page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		
		try {		
			  String url = DriverManager.getDriver().getCurrentUrl();
			  if(url.contains("dashboard"))
			   {
				 LOGGER.info("The user is logged in successfully and is on Home page");						
			   }				
		   }
		   catch(Exception e)
		   {
			  LOGGER.error("Error Message Logged !!! " + e);
			 // CommonUtils.getcommonUtilsInstance().takeScreenShot();
			  Assert.fail(e.getMessage());
		   }	
	}

	@When("the user clicks on the directory option fron the Menu bar")
	public void the_user_clicks_on_the_directory_option_fron_the_menu_bar() {	
		
		try {
			   HomePage.getHomePageInstance().getDIRECTORY().click();	
			   LOGGER.info("User clicks on the directory option fron the side Menu");			
		}
		catch(Exception e)
		{
			LOGGER.error("Error Message Logged !!! " + e);
			//CommonUtils.getcommonUtilsInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}		
	}

	@When("the user selects the job title as {string} from the drop down")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String jobTitle) {
	
	try {
		DirectoryPage.getDirectoryPageInstance().getJOB_TITLE_DROPDOWN().click();
		Thread.sleep(3000);
		
		CommonUtils.getcommonUtilsInstance().selectFromDropDown(DirectoryPage.getDirectoryPageInstance().getJOB_TITLE_DROPDOWN(), "text", jobTitle);
		
//		Select selectJob = new Select();
//		selectJob.selectByVisibleText(jobTitle);
		
		LOGGER.info("The user clicks on job title dropdown.");			
		}
		catch(Exception e)
		{
			LOGGER.error("Error Message Logged !!! " + e);
			//CommonUtils.getcommonUtilsInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		
	try {
		DirectoryPage.getDirectoryPageInstance().getSEARCH_BTN().click();		
		LOGGER.info("The user clicks the search button");			
		}
		catch(Exception e)
		{
			LOGGER.error("Error Message Logged !!! " + e);
		//	CommonUtils.getcommonUtilsInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String ceoName) {
		
	try {
		String CEONAME = DirectoryPage.getDirectoryPageInstance().getCEONAME().getText();	
		Assert.assertEquals(ceoName, CEONAME);		
		LOGGER.info("User can see the CEO name");			
		}
		catch(Exception e)
		{
			LOGGER.error("Error Message Logged !!! " + e);
		//	CommonUtils.getcommonUtilsInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

}
