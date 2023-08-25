package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Base {

    private WebDriver driver;
    protected WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    protected void beforeMethod(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*\", \"--window-size=1920,1080");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //ожидание пока элемент появится на странице.
        //getDriver().get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @AfterMethod
    protected void afterMethod(){
        //getDriver().quit();
    }


}
