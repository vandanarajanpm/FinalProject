package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority=1,description="verify user login with valid credentials.",groups = {"smoke"})
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=loginpage.signinButtonClick();
		boolean dashboardDisplayed=loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed,Constants.VALIDCREDENTIALSERROR);
	}
	@Test(priority=2,description="verify Login With ValidUsername And InvalidPassword")
	public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(1, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).signinButtonClick();
		String expected="7rmart supermarket";
		String actual=loginpage.getTheTitle();
		Assert.assertEquals(actual,expected,Constants.INVALIDLOGINERROR);
		
		}
	@Test(priority=3,description="verify Login With InvalidUsername And ValidPassword")
	public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(2, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).signinButtonClick();
		boolean adminusersDisplayed=loginpage.isadminusersDisplayed();
		Assert.assertTrue(adminusersDisplayed,Constants.VALIDLOGINFAILED);
		}
	@Test(priority=4,description="verify Login With InvalidUsername And InvalidPassword",groups = {"smoke"},dataProvider = "loginProvider")
	public void verifyWhetherUserIsAbleToLoginWithInValidUsernameAndInValidPassword(String usernamevalue,String passwordvalue) throws IOException {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).signinButtonClick();
		boolean alertmessageDisplayed = loginpage.isalertmessageDisplayed();
		Assert.assertTrue(alertmessageDisplayed, Constants.ERRORMESSAGENOTDISPLAYED);
		}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};

 }
	}

	


