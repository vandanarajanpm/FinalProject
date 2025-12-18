package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
 
public class ManageNewsTest extends Base{
	HomePage home;
	ManageNewsPage managenews;
	@Test(priority=9,description="verify Add NewNews")
	public void verifyWhetherUserIsAbleToAddANewNews() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=loginpage.signinButtonClick();
		managenews=home.clickOnManageNewsButton();
		managenews.clickNewButtonInManageNewsPage();
		String newsTitle = ExcelUtility.getStringData(0, 0, "ManagenewsPage");
		managenews.enterNewsInManageNewsPage(newsTitle).clickSaveInManageNewsPage();
		
		
		boolean alertMessage=managenews.alertMessage();
	    Assert.assertTrue(alertMessage,Constants.NEWSNOTADDED);

	}
	@Test(priority=10,description="verify Search Newly AddedUser")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=loginpage.signinButtonClick();
		managenews=home.clickOnManageNewsButton();
		managenews.clickSearchButtonInManageNewsPage();
		String newsTitle = ExcelUtility.getStringData(0, 0, "ManagenewsPage");
		managenews.enterTheTitleToSearch(newsTitle).clickOnsearchButton1InManageNewsPage();
		
		boolean manageNewsTitileDisplayed=managenews.ismanageNewsTitileDisplayed();
		Assert.assertTrue(manageNewsTitileDisplayed,Constants.MANAGENEWSTITLEVISIBLE);
		
	}
	@Test(priority=11,description="verify Reset NewsList")
	public void verifyWhetherUserIsAbleToResetTheNewsList() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=loginpage.signinButtonClick();
		managenews=home.clickOnManageNewsButton();
		managenews.clickOnResetButtonInManageNewsPage();
		
		boolean newstableHeaderDisplayed=managenews.isnewstableHeaderDispalyed();
		Assert.assertTrue(newstableHeaderDisplayed,Constants.NEWSTABLEHEADERVISIBLE);
		
	}	
		
}
