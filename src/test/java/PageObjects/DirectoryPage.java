package PageObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {
	
	
private static DirectoryPage directoryPageInstance;
	
	private DirectoryPage()
	{
		
	}
	
	public static DirectoryPage getDirectoryPageInstance()
	{
		if(directoryPageInstance == null)
		{
			directoryPageInstance = new DirectoryPage();
		}
		return directoryPageInstance;
	}
	
	
	//adding logger
	private static final Logger LOGGER = LogManager.getLogger(DirectoryPage.getDirectoryPageInstance());
	
	
	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
	private WebElement JOB_TITLE_DROPDOWN;
	
	@FindBy(xpath = "//span[text()='Chief Executive Officer']")
	private WebElement CEO_DROPDOWN_NAME;
	
	@FindBy(xpath = "//div[@class='oxd-form-actions']//following::button[@type='submit']")
	private WebElement SEARCH_BTN;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
	private WebElement CEONAME;

	public WebElement getJOB_TITLE_DROPDOWN() {
		return JOB_TITLE_DROPDOWN;
	}

	public WebElement getSEARCH_BTN() {
		return SEARCH_BTN;
	}

	public WebElement getCEONAME() {
		return CEONAME;
	}
		

}
