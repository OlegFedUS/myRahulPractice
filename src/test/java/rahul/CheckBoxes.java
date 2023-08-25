package rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class CheckBoxes extends BaseUtils {

    @Test
    @Ignore
    void checkBox(){

       WebElement checkBox = getDriver().findElement(By.xpath("//input[contains(@name,'chk_friendsandfamily')]"));
       checkBox.click();
       assert checkBox.isSelected();
    }

    @Test
    void allCheckBoxesCount () throws Exception{

        System.out.println(getDriver().findElements(By.cssSelector("input[type='checkbox']")).size());

        /*
        List<WebElement> x = getDriver().findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement option : x){
            Thread.sleep(1000);
            option.click();
        }

        Тут я пытаюсь поставить галочки во всех Чебоксарах сразу
         */

    }

}
