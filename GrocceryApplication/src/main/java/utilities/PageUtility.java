package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	 
	public void selectDropdownWithValue(WebElement element, String value) {
        Select object = new Select(element);
		object.selectByValue(value);
		}
	public void selectDropdownByVisibleText(WebElement element,String text) {
		Select object=new Select(element);
		object.selectByVisibleText(text);
	}
	public void selectDropdownByIndex(WebElement element,int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}
	
	public void mouseOver(WebElement element,WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void rightClick(WebElement element, WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	public void dragAndDrop(WebElement dragMe, WebElement dropHere, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragMe, dropHere).build().perform();
	}
	
}
