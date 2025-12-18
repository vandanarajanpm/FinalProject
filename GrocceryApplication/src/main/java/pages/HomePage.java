package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(linkText="Admin")WebElement adminIcon;
	@FindBy(linkText="Logout")WebElement logoutButton;
	@FindBy(xpath="//a[normalize-space()='More info']") WebElement moreinfoButton;
	@FindBy(xpath="//p[text()='Manage News']/ancestor::div[@class='small-box bg-info']//a")WebElement managenews;
	
	public HomePage clickOnAdminIcon() {
		adminIcon.click();
		return this;
		
	}
	public LoginPage clickOnLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}
	public AdminusersPage clickOnAdminUserMoreinfoButton() {
		moreinfoButton.click();
		return new AdminusersPage(driver);
	}
	public ManageNewsPage clickOnManageNewsButton() {
		managenews.click();
		return new ManageNewsPage(driver);
	}
	
    

}
