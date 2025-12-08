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
	
	
	public void clickOnAdminIcon() {
		adminIcon.click();
		
	}
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	public void clickOnMoreinfoButton() {
		moreinfoButton.click();
	}
	
    

}
