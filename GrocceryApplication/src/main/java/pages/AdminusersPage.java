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
	
	public AdminusersPage clickOnAdminuserNewButton() {
		newButton.click();
		return this;
	}
	public AdminusersPage enterUsernameInAdminUserPage( String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}
	public AdminusersPage enterPasswordInAdminUserPage(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}
	public AdminusersPage selectUserType(String usertype) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(usertype);
		return this;
	}
	
	public AdminusersPage clickOnDropdownIconInAdminUserPage() {
		dropdown.click();
		return this;
		
	}
	public AdminusersPage clickOnSaveButtonInAdminUserPage() {
		saveButton.click();
		return this;
		
	}
	public AdminusersPage clickOnSearchButtonInAdminUserPage() {
		searchButton.click();
		return this;
	}
	public AdminusersPage enterUsernameInSearchAdminUserPage(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
		return this;
	}
	public AdminusersPage clickSearchButton2InAdminUserPage() {
		searchButton2.click();
		return this;
	}
	
	public AdminusersPage clickOnResetButtonInAdminUserPage() {
		resetButton.click();
		return this;
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
