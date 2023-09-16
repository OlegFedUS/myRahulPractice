package rahulSection12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;
import java.util.List;

public class TableGrids extends BaseUtils {

    @Test
    void gridTest(){

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        int count = 0;

        //Req1
        List<WebElement> tableValues = getDriver().findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        for (int i = 0; i < tableValues.size(); i++){

            count = count +  Integer.parseInt(tableValues.get(i).getText());
        }

        //Req2
        String text = getDriver().findElement(By.xpath("//div[@class='totalAmount']")).getText();
        String[] arr = text.split(":");
        String formText = arr[1].trim();

        Integer intText = Integer.parseInt(formText);

        System.out.println(intText);
        Assert.assertEquals(count, intText);
    }

}
