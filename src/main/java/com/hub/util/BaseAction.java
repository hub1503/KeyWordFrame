package com.hub.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseAction {

    WebDriver driver;

    public void open(Locator locator,String browser){
        if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver","driver/FirefoxDriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","driver/ChromeDriver.exe");
            driver = new ChromeDriver();
        }
    }

    public void navigate(Locator locator,String url){
        driver.navigate().to(url);
    }

    public void input(Locator locator,String value){
        getElement(locator).sendKeys(value);
    }

    public void click(Locator locator,String name){
        getElement(locator).click();
    }



    public void quite(){
        driver.quit();
    }

    public WebElement getElement(Locator locator){
        WebElement element = null;
        switch (locator.getByType()){
            case partialLinkText:
                element = driver.findElement(By.partialLinkText(locator.getValue()));
                break;
            case cssSelector:
                element = driver.findElement(By.cssSelector(locator.getValue()));
                break;
            case className:
                element = driver.findElement(By.className(locator.getValue()));
                break;
            case linkText:
                element = driver.findElement(By.linkText(locator.getValue()));
                break;
            case tagName:
                element = driver.findElement(By.tagName(locator.getValue()));
                break;
            case name:
                element = driver.findElement(By.name(locator.getValue()));
                break;
            case id:
                element = driver.findElement(By.id(locator.getValue()));
                break;
            case xpath:
                element = driver.findElement(By.xpath(locator.getValue()));
        }
        return element;
    }
}
