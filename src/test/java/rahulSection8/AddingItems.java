package rahulSection8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.lang.reflect.Array;
import java.time.Duration;
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

        WebDriverWait loading = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] items = {"Mango", "Almonds", "Apple", "Orange", "Strawberry", "Tomato"};

        addToCart(items);

        getDriver().findElement(By.cssSelector("img[alt='Cart']")).click();
        getDriver().findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();

        loading.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']"))).sendKeys("rahulshettyacademy");
        getDriver().findElement(By.xpath("//button[text()='Apply']")).click();

        //Explicit Wait
        String message = loading.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))).getText();

        Assert.assertEquals(message, "Invalid code ..!");


    }

}
