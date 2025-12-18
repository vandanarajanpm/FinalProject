package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
	
	public  ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[contains(text(),  'New')]")WebElement newbutton;
	@FindBy(id="news")WebElement newsTextArea;
	@FindBy(xpath="//button[@name='create']")WebElement saveButton;
	@FindBy(xpath="//button[@type='button']")WebElement alertmessage;
	@FindBy(xpath="//a[@type='button']")WebElement cancelButton;
	@FindBy(xpath="//a[contains(text(),' Search')]") WebElement searchButton;
	@FindBy(name="un")WebElement searchTitile;
	@FindBy(xpath="//button[text()='Search']")WebElement searchButton1;
	@FindBy(xpath=" //a[text()=' Reset']")WebElement resetButton;
	@FindBy(name="un")WebElement isSearchFieldEmpty;
	@FindBy(xpath="//h4[text()='Manage News']")WebElement manageNewsTitile;
	@FindBy(xpath="//th[text()='News']") WebElement newstableHeader;
	
	
	
	public  ManageNewsPage clickNewButtonInManageNewsPage() {
		newbutton.click();
		return this;
	}
	public ManageNewsPage enterNewsInManageNewsPage(String text) {
		newsTextArea.sendKeys(text);
		return this;
	}
	public ManageNewsPage clickSaveInManageNewsPage() {
		saveButton.click();
		return this;
	}
	public boolean alertMessage() {
		return alertmessage.isDisplayed();
	}
	public ManageNewsPage clickSearchButtonInManageNewsPage() {
		searchButton.click();
		return this;
		}
	public ManageNewsPage enterTheTitleToSearch(String text) {
		searchTitile.sendKeys("Automation course");
		return this;
		}
	public ManageNewsPage clickOnsearchButton1InManageNewsPage() {
		searchButton1.click();
		return this;
	}
	public ManageNewsPage clickOnResetButtonInManageNewsPage() {
		resetButton.click();
		return this;
	}
	public boolean ismanageNewsTitileDisplayed() {
		return manageNewsTitile.isDisplayed();
	}
	public boolean isnewstableHeaderDispalyed() {
		return newstableHeader.isDisplayed();
	}
	
	
	

}
