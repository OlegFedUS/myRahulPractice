package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class CheckboxAssignmentFirstAssign extends BaseUtils {

    @Test
    void checkboxes() throws Exception {

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        //Громоздкий - плохой вариант.

        /*
        WebElement check1 = getDriver().findElement(By.id("checkBoxOption1"));
        WebElement check2 = getDriver().findElement(By.cssSelector("input[value='option2']"));
        WebElement check3 = getDriver().findElement(By.cssSelector("input[value='option3']"));

        List<WebElement> boxes = new ArrayList<>();
        boxes.add(check1);
        boxes.add(check2);
        boxes.add(check3);

        for (WebElement value : boxes) {
            value.click();
            Assert.assertTrue(value.isSelected());
        }
         */

        //Компактный и без повторений - пока лучший вариант.

        List<WebElement> checkBoxes = getDriver().findElements(By.cssSelector("input[value*='option']"));

        for (WebElement value : checkBoxes){
            value.click();
            Assert.assertTrue(value.isSelected());
        }

    }
    @Test
    void countCheck(){
        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
        int checkboxes = getDriver().findElements(By.xpath("//input[contains(@value,'option')]")).size();
        Assert.assertEquals(checkboxes, 3);
    }

}
