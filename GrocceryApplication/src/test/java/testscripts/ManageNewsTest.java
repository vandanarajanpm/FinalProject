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
	@Test(priority=9,description="verify Add NewNews")
	public void verifyWhetherUserIsAbleToAddANewNews() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnManageNewsButton();
		
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickNewButton();
		
		String newsTitle = ExcelUtility.getStringData(0, 0, "ManagenewsPage");
		
		news.enterNews(newsTitle);
		news.clickSave();
		
		
		boolean alertMessage=news.alertMessage();
	    Assert.assertTrue(alertMessage,Constants.NEWSNOTADDED);

	}
	@Test(priority=10,description="verify Search Newly AddedUser")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnManageNewsButton();
		
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnsearchButton();
		String newsTitle = ExcelUtility.getStringData(0, 0, "ManagenewsPage");
		news.enterTheTitle(newsTitle);
		news.clickOnsearchButton1();
		
		boolean manageNewsTitileDisplayed=news.ismanageNewsTitileDisplayed();
		Assert.assertTrue(manageNewsTitileDisplayed,Constants.MANAGENEWSTITLEVISIBLE);
		
	}
	@Test(priority=11,description="verify Reset NewsList")
	public void verifyWhetherUserIsAbleToResetTheNewsList() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.signinButtonClick();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnManageNewsButton();
		
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnResetButton();
		boolean newstableHeaderDisplayed=news.isnewstableHeaderDispalyed();
		Assert.assertTrue(newstableHeaderDisplayed,Constants.NEWSTABLEHEADERVISIBLE);
		
	}	
		
}
