package com.way2automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webtable {

    public static void main(String[] args)  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
        driver.findElement(By.xpath("/html/body/table/thead/tr[2]/td/button")).click();
        driver.findElement(By.name("FirstName")).sendKeys("John");
        driver.findElement(By.name("LastName")).sendKeys("Barikdar");
        driver.findElement(By.name("UserName")).sendKeys("jbarikdar");
        driver.findElement(By.name("Password")).sendKeys("pass123");
        driver.findElement(By.xpath("//input[@type='radio']")).click();
        Select sel = new Select(driver.findElement(By.name("RoleId")));
        sel.selectByVisibleText("Customer");
        driver.findElement(By.name("Email")).sendKeys("john@barikdar.com");
        driver.findElement(By.name("Mobilephone")).sendKeys("555-555-5555");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        String uName = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[3]")).getText();

        if(uName.equals("jbarikdar")){
            System.out.println(uName+" successfully created");
        }else{
            System.out.println(uName+" not created");
        }


        String nameToDelete = "novak";
        String beforeXp = "/html/body/table/tbody/tr[";
        String afterXp = "]/td[3]";
        for(int i=1;i<8;i++){
            String names = driver.findElement(By.xpath(beforeXp+i+afterXp)).getText();
            if(names.equals(nameToDelete)){
                driver.findElement(By.xpath(beforeXp+i+"]/td[11]")).click();
                driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

            }
        }

        for(int i=1;i<8;i++){
            String names = driver.findElement(By.xpath(beforeXp+i+afterXp)).getText();
            if(names.equals(nameToDelete)){
                System.out.println(nameToDelete+" not deleted!");
            }else{
                System.out.println(nameToDelete+" successfully deleted!");
                break;
            }
        }



    }
}
