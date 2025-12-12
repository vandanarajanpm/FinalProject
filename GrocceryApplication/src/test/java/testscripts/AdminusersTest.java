package testscripts;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminusersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminusersTest extends Base{
	@Test(priority=6,description="verify Add NewUser")
	
	public void verifyWhetherUserIsAbleToAddANewUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMoreinfoButton();
		
		AdminusersPage adminuserpage = new AdminusersPage(driver);
		adminuserpage.clickOnNewButton();
		FakerUtility fakerutility =new FakerUtility();
		
		
		String username=fakerutility.createRandomUsername();
		String password=fakerutility.createFakePassword();
		String usertype=ExcelUtility.getStringData(0, 2, "AdminuserPage");
		adminuserpage.enterUserNameOnUserNameField(username);
		adminuserpage.enterPasswordOnPasswordField(password);
		adminuserpage.selectUserType(usertype);
		adminuserpage.clickOnSaveButton();
		boolean userAddedAlertDisplayed=adminuserpage.userAddedAlertMessage();
	    Assert.assertTrue(userAddedAlertDisplayed,"user not able to add new user");
		
	}
	@Test(priority=7,description="verify Search For NewlyAddedUser")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMoreinfoButton();
		
		AdminusersPage adminuserpage = new AdminusersPage(driver);
		adminuserpage.clickOnSearchButton();
		
		String usernames=ExcelUtility.getStringData(0, 0,"AdminuserPage");
		adminuserpage.enterTheUserNameToSearch(usernamevalue);
		adminuserpage.clickOnSearchButton2();
		boolean userNameDisplayed=adminuserpage.isuserNameTitileDisplayed();
		Assert.assertTrue(userNameDisplayed," user is able to see username titile");
		
	}
	@Test(priority=8,description="verify Reset UserList")
	public void verifyWhetherUserIsAbleToResetTheUserList() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMoreinfoButton();
		
		AdminusersPage adminuserpage = new AdminusersPage(driver);
		adminuserpage.clickOnResetButton();
		
		boolean adminUserListDisplayed=adminuserpage.isAdminUserListDisplayed();
		Assert.assertTrue(adminUserListDisplayed,"user list not reset");
		
	}
	

}
