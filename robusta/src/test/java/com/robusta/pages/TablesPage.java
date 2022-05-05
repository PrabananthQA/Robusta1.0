package com.robusta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.robusta.base.PSM;
@Test
public class TablesPage extends PSM{
	public TablesPage gotoTables() {
		startApp();
		WebElement more = locateElement("xpath", "//nav[@id='site-navigation']//descendant::a[text()='More']");
		Actions act = new Actions(driver);
		act.moveToElement(more);
		WebElement gototable = locateElement("xpath", "//a[text()='Automation Practice | WebTable']");
		gototable.click();
		WebElement selenium = locateElement("xpath", "//a[text()='Selenium']");
		selenium.click();
		return this;
	}
}
  