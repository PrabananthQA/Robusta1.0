package com.robusta.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverServiceImpl implements WebDriverService{

	public static WebDriver driver;

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "link" : return driver.findElement(By.linkText(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "tagName": return driver.findElement(By.tagName(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "plink": return driver.findElement(By.partialLinkText(locValue));
			default:
				break;
			}
		} catch (NoSuchElementException e) {
			throw new RuntimeException();
		}
		return null;
	}

	public void type(WebElement ele, String data) {

		try {
			ele.sendKeys(data);
		} catch (Exception e) {

		}

	}
	public void clearAndType(WebElement ele, String data) {

	}

	public void click(WebElement ele) {
		ele.click();		
	}

	public String getText(WebElement ele) {
		return ele.getText();
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		new Select(ele).selectByVisibleText(value);

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele).selectByValue(value);

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);		
	}

	public boolean verifyExactTitle(String expectedTitle) {
		if (driver.getTitle().equals(expectedTitle)) {
			System.out.println("title equal matched");
			return true;
		}
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		if (driver.getTitle().contains(expectedTitle)) {
			System.out.println("title partially matched");
			return true;
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		String text = ele.getText();
		if(text.equals(expectedText)) {
			System.out.println("Expected text "+expectedText+" matched with the actual text"+text);
		}else {
			System.out.println("Expected text "+expectedText+" does not match with the actual text"+text);
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		String text = ele.getText();
		if(text.contains(expectedText)) {
			System.out.println("Expected text "+expectedText+" matched with the actual text"+text);
		}else {
			System.out.println("Expected text "+expectedText+" does not match with the actual text"+text);
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		String actualAtb = ele.getAttribute(attribute);
		if(actualAtb.equals(value)) {
			System.out.println("Attribute is matched exactly");
		}else {
			System.out.println("Attribute is not matched exactly");
		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		String actualAtb = ele.getAttribute(attribute);
		if(actualAtb.equals(value)) {
			System.out.println("Attribute is partially matched");
		}else {
			System.out.println("Attribute is not matched");
		}

	}

	public void verifySelected(WebElement ele) {
		if(ele.isSelected()) {
			System.out.println(ele+" is Selected");
		}
		else {
			System.out.println(ele+" is not Selected");
		}

	}

	public void verifyDisplayed(WebElement ele) {
		if(ele.isDisplayed()) {
			System.out.println(ele+" is Selected");
		}
		else {
			System.out.println(ele+" is not Selected");
		}
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allwindowHandles = driver.getWindowHandles();
			List<String> list = new ArrayList<String>();
			System.out.println(list.size());
			list.addAll(allwindowHandles);
			driver.switchTo().window(list.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("NoSuchWindowException");
			throw new RuntimeException();
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException");
			throw new RuntimeException();
		}

	}

	public void switchtoFrame(String frameID) {
		driver.switchTo().frame(frameID);
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void acceptAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void closeActiveBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		driver.quit();
	}
	public void actions(WebElement ele, String actionToBePerformed) {

		Actions act = new Actions(driver);
		switch (actionToBePerformed) {
		case "moveToElement":
			act.moveToElement(ele).perform();
			break;
		case "click":
			act.click(ele).perform();
			break;
		default:
			break;
		}
	}
	public void driverActions(String actionToBePerformed) {


	}
	public void clickable(String locator, String locValue) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(locateElement(locator,locValue)));

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}
}
