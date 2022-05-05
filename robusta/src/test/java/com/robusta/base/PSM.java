package com.robusta.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PSM extends WebDriverServiceImpl{
	public void startApp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://cosmocode.io/");
	}

	@AfterTest
	public void afterMethod(){
		closeAllBrowsers();
	}


}

