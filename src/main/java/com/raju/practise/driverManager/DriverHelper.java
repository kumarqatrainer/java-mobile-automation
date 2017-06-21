package com.raju.practise.driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DriverHelper {

    public DriverHelper(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public  static AppiumDriver<MobileElement> driver;
    public String device="4df1b7cd27616fa3";

    public void openApp(){
        try {
            driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + System.getProperty("env.PORT") + "/wd/hub"),buildCapabilities());
        }
        catch (MalformedURLException ex)
        {
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void killApp(){
        driver.quit();
    }

    public DesiredCapabilities buildCapabilities()  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/main/java/com/raju/practise/apps/com.riverisland.android__11.apk");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", System.getProperty("env.OS"));
        capabilities.setCapability("deviceName",  System.getProperty("env.DEVICE"));
        capabilities.setCapability("appPackage", "com.riverisland.android");
        capabilities.setCapability("appActivity", "com.riverisland.android.StartupActivity");
        capabilities.setCapability("noReset", false);

        return capabilities;
    }

    public WebElement waitForElement(WebElement element) {
        try {
            return new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            FluentWait<WebElement> fluentWait = new FluentWait<WebElement>(element);
            fluentWait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS);
            fluentWait.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class)
                    .ignoring(StaleElementReferenceException.class);
        }
        return element;
    }

    public WebElement waitForUpdates(WebElement element) {
        try {
            return new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            FluentWait<WebElement> fluentWait = new FluentWait<WebElement>(element);
            fluentWait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.MILLISECONDS);
            fluentWait.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class)
                    .ignoring(StaleElementReferenceException.class);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", element);
            return element;
        }
    }
    public List<WebElement> waitForElements(List<WebElement> elements) {
        try {
            return new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (WebDriverException e) {
            FluentWait<List<WebElement>> fluentWait = new FluentWait<List<WebElement>>(elements);
            fluentWait.withTimeout(15, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.MILLISECONDS);
            fluentWait.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class)
                    .ignoring(StaleElementReferenceException.class);

        }
        return elements;
    }

}
