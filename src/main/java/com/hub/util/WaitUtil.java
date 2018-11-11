package com.hub.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    public static void sleep(long milliscond){
        try{
            Thread.sleep(milliscond);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void waitElement(WebDriver driver, WebElement element,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
