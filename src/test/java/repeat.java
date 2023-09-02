import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class repeat extends BaseUtils {

    @Test
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
}
