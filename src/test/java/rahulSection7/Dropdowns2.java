package rahulSection7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class Dropdowns2 extends BaseUtils {

    @Test
    void autoSuggestiveDropdown(){

         getDriver().findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]"))
                 .sendKeys("Ger");

        int list = getDriver().findElements(By.cssSelector("li[class='ui-menu-item']")).size();

        for (int i = 1; i < list; i++){
            getDriver().findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]")).sendKeys(Keys.DOWN);
            getDriver().findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]")).click();
            break;
        }

        System.out.println(getDriver().findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]")).getAttribute("Value"));

    }

}
