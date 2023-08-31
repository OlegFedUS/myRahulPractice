package rahulSection8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.Arrays;
import java.util.List;

public class repeat extends BaseUtils {

    @Test
    void repeat(){

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
        int count = 0;

        List<WebElement> itemList = getDriver().findElements(By.xpath("//h4[@class='product-name']"));

        String[] itemArray = {"Cucumber", "Beans", "Pumpkin"};

        List<String> arrayToList = Arrays.asList(itemArray);

        for (int i = 0; i < itemList.size(); i++){

            String[] txt = itemList.get(i).getText().split("-");
            String str = txt[0].trim();

            if (arrayToList.contains(str)){

                count++;
                List<WebElement> buttons = getDriver().findElements(By.xpath("//div[@class='product-action']"));
                buttons.get(i).click();

                if (count == 3){
                    break;
                }

            }

        }

    }
}
