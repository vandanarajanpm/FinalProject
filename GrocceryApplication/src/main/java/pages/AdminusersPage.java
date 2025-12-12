package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminusersPage {
public WebDriver driver;
	
	public  AdminusersPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[contains(@class,'btn-danger')]")WebElement newButton;
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="user_type")WebElement dropdown;
	@FindBy(xpath="//button[@name='Create']")WebElement saveButton;
	@FindBy(xpath="//a[contains(text(),' Search')]") WebElement searchButton;
	@FindBy(id="un")WebElement searchUserName;
	@FindBy(name="Search")WebElement searchButton2;
	@FindBy(xpath="//a[text()=' Reset']") WebElement resetButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' or @class='alert-danger alert-dismissible']")WebElement userAddAlert;
	@FindBy(xpath="//th[text()='Username']") WebElement userNameTitile;
	@FindBy(xpath="//h4[text()='Admin Users']")WebElement adminUserList;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	public void enterUserNameOnUserNameField( String usernamevalue) {
		username.sendKeys(usernamevalue);
	}
	public void enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
	}
	public void selectUserType(String usertype) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(usertype);
	}
	
	public void clickOnDropdownIcon() {
		dropdown.click();
		
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void clickOnSearchButton() {
		searchButton.click();
	}
	public void enterTheUserNameToSearch(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
	}
	public void clickOnSearchButton2() {
		searchButton2.click();
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}
	public boolean userAddedAlertMessage() {
		return userAddAlert.isDisplayed();
		}
	public boolean isuserNameTitileDisplayed() {
		return userNameTitile.isDisplayed();
	}
	public boolean isAdminUserListDisplayed() {
		return adminUserList.isDisplayed();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
