package rahulSection11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class LimitingWebDriverScope extends BaseUtils {

    @Test
    void limitFirst(){

        //req1 To count of all links on page
        System.out.println(getDriver().findElements(By.tagName("a")).size());

        //req2 To create limitedDriver for separate part of page and to count all links
        WebElement limitedDriver = getDriver().findElement(By.id("gf-BIG"));
        System.out.println(limitedDriver.findElements(By.tagName("a")).size());

        //req3 limited driver within a limitedDriver (count)
        WebElement limited2 = limitedDriver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        System.out.println(limited2.findElements(By.tagName("a")).size());

    }
}
