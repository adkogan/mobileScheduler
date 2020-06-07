package com.scheduler.mobile.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;


    public void init() throws InterruptedException, IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa23");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("app", "/home/adkogan/git/mobileScheduler/apk/v.0.0.3.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver
                .manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void stop() {
        driver.quit();
    }

    public void fillLoginForm(String email, String password) {
        click(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']"));
        type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']"), email);

        type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']"), password);
        driver.hideKeyboard();

    }

    private void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }


    public void confirmLogin() {
        click(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']"));

    }
}



