package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class BaseUtils extends Base{

    protected String getPassword () throws Exception{

        getDriver().findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
        Thread.sleep(1000); //waiting util stable state
        getDriver().findElement(By.xpath("//button[contains(@class,'reset-pwd-btn')]")).click();
        String message = getDriver().findElement(By.xpath("//p[@class='infoMsg']")).getText();
        String[] arrMessage = message.split("'", 3);
        String messageTxt = arrMessage[1];
        getDriver().findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        return messageTxt;
    }
    protected <T> void addToCart(T[] items) {

        List<T> fruitList = Arrays.asList(items);
        int count = 0;

        List<WebElement> products = getDriver().findElements(By.cssSelector("h4[class='product-name']"));

        for (int i = 0; i < products.size(); i++) {

            String[] fruitNameArr = products.get(i).getText().split("-");
            String fruitName = fruitNameArr[0].trim();

            if (fruitList.contains(fruitName)) {
                count++;
                List<WebElement> buttons = getDriver().findElements(By.xpath("//div[@class='product-action']"));
                buttons.get(i).click();
                if (count == items.length) {
                    break;
                }
            }

        }
    }


}
