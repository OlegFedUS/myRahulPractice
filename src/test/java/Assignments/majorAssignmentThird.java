package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.time.Duration;
import java.util.List;

public class majorAssignmentThird extends BaseUtils {

    @Test
    void e2eMajorAssignmentTest(){

        WebDriverWait explicit = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        getDriver().get("https://rahulshettyacademy.com/loginpagePractise/");

        getDriver().findElement(By.id("username")).sendKeys("rahulshettyacademy");
        getDriver().findElement(By.id("password")).sendKeys("learning");

        getDriver().findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();

        WebElement button = getDriver().findElement(By.xpath("//select[@class='form-control']"));
        Select buttonsSelection = new Select(button);
        buttonsSelection.selectByIndex(2);

        getDriver().findElement(By.id("terms")).click();

        getDriver().findElement(By.id("signInBtn")).click();

        explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card[@class='col-lg-3 col-md-6 mb-3']")));
        List<WebElement> phoneList = getDriver().findElements(By.xpath("//app-card[@class='col-lg-3 col-md-6 mb-3']"));

        for (int i = 0; i < phoneList.size(); i++){
            List<WebElement> buttons = getDriver().findElements(By.xpath("//button[@class='btn btn-info']"));
            buttons.get(i).click();
        }

        getDriver().findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

    }
}
