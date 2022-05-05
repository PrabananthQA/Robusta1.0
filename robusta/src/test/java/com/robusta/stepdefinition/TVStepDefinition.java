package com.robusta.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.robusta.pages.TablesPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TVStepDefinition extends TablesPage {
	TablesPage tpage = new TablesPage();
	
	@Given("^User is already on the Tables page$") 
	public void Tables_page()throws Throwable
	{
		tpage.gotoTables();
//        System.out.println(ActualTitle);
//        String ExpectedTitle="Automation Practice | WebTable – CosmoCode (Formerly TeachMeSelenium)";
//        if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
//        	System.out.println("Title verified");
//        }else {
//        	System.out.println("Title is wrong");
//        	driver.close();
//        }
	}


	@When("^user scroll down$")
	public void User_scrolldown() {		
        WebElement table = driver.findElement(By.xpath("//div[@class='entry-content']//following::table"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", table);
	}

	@Then("^user should be able to view countries table$") 
	public void content_verification() {
        WebElement table = driver.findElement(By.xpath("//div[@class='entry-content']//following::table"));
		List<WebElement> rowSize = table.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
        int size = rowSize.size();
        System.out.println("No of countries in list is "+size+ "\n"+"**********"+"\n"+" " );
        String x1="//*[@id=\"countries\"]/tbody/tr[";
        String x2="]/td[2]/strong";
        for(int i=2;i<139;i++)
        {
            String xp=x1+i+x2;
            WebElement ele = driver.findElement(By.xpath(xp));
            System.out.println((i-1)+"."+ele.getText());
        }
	}
	
	@Then("^Close the browser$")
	public void close_browser() {
		System.out.println("Test completed");
		driver.quit();
	}

}
