package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;
	@Test(priority=5,description="verifySuccessfullyogout",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException, InterruptedException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=loginpage.signinButtonClick();
		
		home.clickOnAdminIcon();
		//Thread.sleep(2000);
		loginpage=home.clickOnLogoutButton();
		//Thread.sleep(2000);
		String expected="7rmart supermarket";
		String actual = loginpage.getTheTitle();
		Assert.assertEquals(actual,expected,Constants.LOGOUTFAILEDFROMHOMEPAGE);
				
}
	
	
		
	}
	
