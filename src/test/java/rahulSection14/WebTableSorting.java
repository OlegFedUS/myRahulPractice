package rahulSection14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WebTableSorting extends BaseUtils {

    @Test
    @Ignore
    void tableSort() {

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebElement driverLimit = getDriver().findElement(By.xpath("//tbody "));

        //REQ1

        driverLimit.findElement(By.xpath("//tr[1]/th[1]")).click();

        List<WebElement> list = driverLimit.findElements(By.xpath("//tr/td[1]"));

        List<String> origText = list.stream().map(s -> s.getText()).collect(Collectors.toList());

        System.out.println(origText);

        List<String> sortedText = origText.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(origText.equals(sortedText));

        //REQ2
/*
        do {
            List<String> price = list.stream()
                    .filter(s -> s.getText().contains("Almond"))
                    .map(s -> getValueText(s))
                    .collect(Collectors.toList());

            System.out.println(price);

            if (price.size() < 1) {
                getDriver().findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
            while (price.size() < 1) ;


        } while

 */

    }

    @Test
    void repeat(){

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        getDriver().findElement(By.xpath("//span[text()='Veg/fruit name']")).click();

        List<WebElement> gridList = getDriver().findElements(By.xpath("//tr/td[1]"));

        List<String> strList = gridList.stream().map(s->s.getText()).collect(Collectors.toList());

        // Pagination

        List<String> intStr;

        do {

            List<WebElement> gridListLoops = getDriver().findElements(By.xpath("//tr/td[1]"));

             intStr = gridListLoops.stream()
                    .filter(s -> s.getText().equalsIgnoreCase("Wheat"))
                    .map(s -> getValueText(s))
                    .collect(Collectors.toList());

            if (intStr.size() < 1) {
                getDriver().findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        } while (intStr.size() < 1);

    }

}
