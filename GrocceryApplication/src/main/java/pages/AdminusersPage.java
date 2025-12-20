package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminusersPage {
public WebDriver driver;
PageUtility pageUtility = new PageUtility();
	
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
		return new AdminusersPage(driver);
	}
	public AdminusersPage enterUsernameInAdminUserPage( String usernamevalue) {
		username.sendKeys(usernamevalue);
		return new AdminusersPage(driver);
	}
	public AdminusersPage enterPasswordInAdminUserPage(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return new AdminusersPage(driver);
	}
	public AdminusersPage selectUserType(String usertype) {
		PageUtility page= new PageUtility() ;
		page.selectDropdownWithValue(dropdown, usertype);
		return new AdminusersPage(driver);
		}
	
   public AdminusersPage clickOnSaveButtonInAdminUserPage() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, saveButton);
		saveButton.click();
		return new AdminusersPage(driver);
		
	}
	public AdminusersPage clickOnSearchButtonInAdminUserPage() {
		searchButton.click();
		return new AdminusersPage(driver);
	}
	public AdminusersPage enterUsernameInSearchAdminUserPage(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
		return new AdminusersPage(driver);
	}
	public AdminusersPage clickSearchButton2InAdminUserPage() {
		searchButton2.click();
		return new AdminusersPage(driver);
	}
	
	public AdminusersPage clickOnResetButtonInAdminUserPage() {
		resetButton.click();
		return new AdminusersPage(driver);
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
