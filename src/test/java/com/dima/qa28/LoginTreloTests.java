package com.dima.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTreloTests  {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }
    @Test
    public void loginTest() throws InterruptedException {
        click(By.xpath("//a[@href='/login']"));

        wd.findElement(By.xpath("//*[@name='user']")).click();
        wd.findElement(By.xpath("//*[@name='user']")).clear();
        wd.findElement(By.xpath("//*[@name='user']")).sendKeys("rochman.elena@gmail.com");

        Thread.sleep(2000);
        click(By.xpath("//input[@id='login']"));

        wd.findElement(By.xpath("//*[@name='password']")).click();
        wd.findElement(By.xpath("//*[@name='password']")).clear();
        wd.findElement(By.xpath("//*[@name='password']")).sendKeys("12345.com");

        click(By.xpath("//button[@id='login-submit']"));
        new WebDriverWait(wd,30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//ul[@class = 'boards-page-board-section-list']")));
    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
