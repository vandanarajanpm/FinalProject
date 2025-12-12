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
	
	
	
	public void clickNewButton() {
		newbutton.click();
	}
	public void enterNews(String text) {
		newsTextArea.sendKeys(text);
	}
	public void clickSave() {
		saveButton.click();
	}
	public boolean alertMessage() {
		return alertmessage.isDisplayed();
	}
	public void clickOnsearchButton() {
		searchButton.click();
		}
	public void enterTheTitle(String text) {
		searchTitile.sendKeys("Automation course");
		}
	public void clickOnsearchButton1() {
		searchButton1.click();
	}
	public void clickOnResetButton() {
		resetButton.click();
	}
	public boolean ismanageNewsTitileDisplayed() {
		return manageNewsTitile.isDisplayed();
	}
	public boolean isnewstableHeaderDispalyed() {
		return newstableHeader.isDisplayed();
	}
	
	
	

}
