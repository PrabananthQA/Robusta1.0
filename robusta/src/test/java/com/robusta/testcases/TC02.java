package com.robusta.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TC02 {
    public static void main(String args[]){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();
        WebElement table = driver.findElement(By.xpath("//div[@class='entry-content']//following::table"));
        List<WebElement> rowSize = table.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
        int size = rowSize.size();
        System.out.println(size);
        String test = driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[16]/td[2]")).getText();
        System.out.println(test);
        String x1="//*[@id=\"countries\"]/tbody/tr[";
        String x2="]/td[2]/strong";
        ArrayList<String> Tblele = new ArrayList<String>();
        for(int i=2;i<139;i++)
        {
            String xp=x1+i+x2;
            WebElement ele = driver.findElement(By.xpath(xp));
            Tblele.add(ele.getText());
        }
        System.out.println(Tblele);
        try {
            if (Tblele.contains("Check")) {
                System.out.println("India is in list");
            } else {
                System.out.println("India is not in list");
            }
        }
             catch (Exception e) {
                e.printStackTrace();

        driver.close();
    }
        }
    }

