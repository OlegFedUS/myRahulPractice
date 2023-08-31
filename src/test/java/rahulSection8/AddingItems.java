package rahulSection8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddingItems extends BaseUtils {

    @Test
    @Ignore
    void addItemTest() throws Exception{

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

        Thread.sleep(1500);

        List<WebElement> products = getDriver().findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++){

            String product = products.get(i).getText().toLowerCase();
            if (product.contains("cucumber")){
                getDriver().findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }
    }

    @Test
    void addingSeveralItems(){

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

        addToCart();

    }

}
