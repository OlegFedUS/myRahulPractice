package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class AssignmentSixthTabelsText extends BaseUtils {

    @Test
    void tableTest(){

        int count = 0;

     getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement tableDriver = getDriver().findElement(By.id("product"));

        tableDriver.findElements(By.tagName("tr"));

        System.out.println(tableDriver.findElements(By.tagName("tr")).size()); // column
        System.out.println(tableDriver.findElements(By.tagName("th")).size()); // raw

        System.out.println(tableDriver.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

        List<WebElement> raw = tableDriver.findElements(By.tagName("tr")).get(9).findElements(By.tagName("td"));

        System.out.println(raw.get(0).getText());
        System.out.println(raw.get(1).getText());
        System.out.println(raw.get(2).getText());



    }
}
