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
	@Test
	
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
	@Test
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
		boolean adminUserInformationTabDisplayed=adminuserpage.isAdminUsersIformationTabDisplayed();
		Assert.assertTrue(adminUserInformationTabDisplayed,"user not able to see the information tab");
	}
	@Test
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
		boolean adminUserInformationlistDisplayed=adminuserpage.isAdminUsersIformationTabDisplayed();
		Assert.assertTrue(adminUserInformationlistDisplayed,"user not able to see the information list");
		
	}
	

}
