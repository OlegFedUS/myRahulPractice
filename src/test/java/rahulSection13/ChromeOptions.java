package rahulSection13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;


public class ChromeOptions {

    WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        org.openqa.selenium.chrome.ChromeOptions chromeOptions = new org.openqa.selenium.chrome.ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
