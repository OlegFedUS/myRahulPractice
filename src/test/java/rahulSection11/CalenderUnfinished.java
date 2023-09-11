package rahulSection11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class CalenderUnfinished extends BaseUtils {

    @Test
    void calenderTest() throws Exception{

        getDriver().get("https://www.path2usa.com/travel-companion/");

        Thread.sleep(2000);
        getDriver().findElement(By.id("form-field-travel_comp_date")).click();


        //Months

        String month = getDriver().findElement(By.xpath("//span[@class='cur-month']")).getText();

        while (!month.contains("December")){
            getDriver().findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }
        System.out.println(getDriver().findElement(By.xpath("//span[@class='cur-month']")).getText());


        //Days
        List<WebElement> dates = getDriver().findElements(By.xpath("//span[@class='flatpickr-day ']"));
        int count = getDriver().findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

        for (int i = 0; i < count; i++){

            String text = getDriver().findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
            if (text.equalsIgnoreCase("21")){
                dates.get(i).click();
                break;
            }


        }

    }

}
