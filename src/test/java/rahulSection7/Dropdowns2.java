package rahulSection7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class Dropdowns2 extends BaseUtils {

    @Test
    void autoSuggestiveDropdown(){

         getDriver().findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]"))
                 .sendKeys("Ger");

         List<WebElement> list = getDriver().findElements(By.cssSelector("li[class='ui-menu-item']")); //Нужно найти общий локатор. Который взаимодействует со всеми элементами.

         for (WebElement option : list){
             String optionTxt = option.getText().toLowerCase();
             if (optionTxt.contains("germany")){
                 System.out.println(option.getText());
                 option.click();
                 break;
             }
         }

    }

}
