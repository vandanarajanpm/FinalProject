package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		boolean dashboardDislayed=loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDislayed,"user was unable to login with valid credentials");
	}
	@Test
	public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(1, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		String expected="7rmart supermarket";
		String actual=loginpage.getTheTitle();
		Assert.assertEquals(actual,expected,"user was able to login with invalid password");
		
		}
	@Test
	public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(2, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		}
	@Test
	public void verifyWhetherUserIsAbleToLoginWithInValidUsernameAndInValidPassword() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(3, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		}
	}
	


