package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException, InterruptedException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnAdminIcon();
		Thread.sleep(2000);
		homepage.clickOnLogoutButton();
		Thread.sleep(2000);
		String expected="7rmart supermarket";
		String actual = loginpage.getTheTitle();
		Assert.assertEquals(actual,expected,"user was unable to logout from the home page");
				
}
	
	
		
	}
	
