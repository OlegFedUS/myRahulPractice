import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class repeat extends BaseUtils {

    @Test
    @Ignore
    void repeat() {

        getDriver().get("https://rahulshettyacademy.com/loginpagePractise/");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement click = getDriver().findElement(By.xpath("//a[@class='blinkingText']"));

        //Actions (Mouse, keyboard interactions & etc.)
        Actions act = new Actions(getDriver());
        act.moveToElement(click).click().build().perform();

        //Windows Handle.
        Set<String> windows = getDriver().getWindowHandles(); //id окон
        Iterator<String> iterate = windows.iterator(); // Я вытаскиваю ID's из Set-структуры, итерация по id окон (child/parent id's).
        String parent = iterate.next(); // it gets "next" id from Set, grub it.
        String child = iterate.next();
        getDriver().switchTo().window(child);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong/a"))).getText();
        getDriver().switchTo().window(parent);

        System.out.println(text);
        System.out.println(parent);
        System.out.println(child);

    }

    @Test
    @Ignore
    void repeat2() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        int j = 0;
        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> allItems = getDriver().findElements(By.xpath("//div[@class='product']"));

        String[] arr = {"Brocolli", "Potato", "Carrot", "Onion", "Cucumber"};

        List<String> prNames = Arrays.asList(arr);

        for (int i = 0; i < allItems.size(); i++) {

            String[] names = allItems.get(i).getText().split("-");
            String format = names[0].trim();

            if (prNames.contains(format)) {
                j++;
                List<WebElement> buttons = getDriver().findElements(By.xpath("//div[@class='product-action']"));
                buttons.get(i).click();

                if (j == arr.length) {
                    break;
                }
            }
        }

        getDriver().findElement(By.xpath("//img[@alt='Cart']")).click();
        getDriver().findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']"))).sendKeys("123");
        WebElement button = getDriver().findElement(By.xpath("//button[text()='Apply']"));
        button.click();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))).getText();

        getDriver().navigate().back();

        System.out.println(message);

    }

    @Test
    @Ignore
    void repeat3() {

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement iframe = getDriver().findElement(By.id("courses-iframe"));
        getDriver().switchTo().frame(iframe);

        System.out.println(getDriver().findElement(By.xpath("//div[@class='price-title']")).getText());

        getDriver().navigate().back();

        Actions actions = new Actions(getDriver());
        WebElement radioButton = getDriver().findElement(By.xpath("//input[@value='radio2']"));

        actions.moveToElement(radioButton).click().build().perform();


    }

    @Test
    void repeat4() {



    }

}
