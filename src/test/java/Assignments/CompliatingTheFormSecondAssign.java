package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class CompliatingTheFormSecondAssign extends BaseUtils {

    @Test
    void form() {

        getDriver().get("https://rahulshettyacademy.com/angularpractice/");
        getDriver().findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("Vanessa Paradis");
        getDriver().findElement(By.cssSelector("input[name='email']")).sendKeys("polkovnik@mail.ru");
        getDriver().findElement(By.id("exampleInputPassword1")).sendKeys("12345k");

        WebElement iceCreamBox = getDriver().findElement(By.id("exampleCheck1"));

        iceCreamBox.click();
        Assert.assertTrue(iceCreamBox.isSelected());

        WebElement genders = getDriver().findElement(By.id("exampleFormControlSelect1"));
        genders.click();
        Select gender = new Select(genders);
        gender.selectByIndex(1);

        getDriver().findElement(By.id("inlineRadio2")).click();
        System.out.println(getDriver().findElement(By.id("inlineRadio3")).isEnabled());

        getDriver().findElement(By.xpath("//input[@name='bday']")).sendKeys("20.09.1994");

        getDriver().findElement((By.xpath("//input[@value='Submit']"))).click();

        String alert = getDriver().findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        Assert.assertEquals(alert, "×\n" +
                "Success! The Form has been submitted successfully!.");

    }
}
