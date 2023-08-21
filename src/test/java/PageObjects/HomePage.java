package PageObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
private static HomePage homePageInstance;
	
	private HomePage()
	{
		
	}
	
	public static HomePage getHomePageInstance()
	{
		if(homePageInstance == null)
		{
			homePageInstance = new HomePage();
		}
		return homePageInstance;
	}
	
	//adding logger
	private static final Logger LOGGER = LogManager.getLogger(HomePage.getHomePageInstance());
	
	@FindBy(xpath = "//span[text()='Directory']")
	private WebElement DIRECTORY;

	public WebElement getDIRECTORY() {
		return DIRECTORY;
	}
	
	

}
