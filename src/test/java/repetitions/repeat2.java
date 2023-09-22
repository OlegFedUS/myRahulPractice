package repetitions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class repeat2 extends BaseUtils {

    @Test
    void repeat() throws Exception {

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement link = getDriver().findElement(By.xpath("//a[@class='blinkingText']"));
        link.sendKeys(Keys.CONTROL, Keys.ENTER);

        Thread.sleep(2000L);

        Set<String> window = getDriver().getWindowHandles();
        Iterator<String> iterator = window.iterator();

        String parent = iterator.next();
        String child = iterator.next();

        getDriver().switchTo().window(child);

        System.out.println(getDriver().getTitle());

        //REQ *** Screenshot

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");

        Thread.sleep(2000L);

            File screen = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File("d:\\screenTest.png"));

    }

    @Test
    void repeat2() {

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement grid = getDriver().findElement(By.id("product"));

        System.out.println(grid.findElements(By.tagName("tr")).size());
        System.out.println(grid.findElements(By.tagName("th")).size());

        System.out.println(grid.findElements(By.tagName("tr")));

        //List<WebElement> listGrid = grid.findElements(By.tagName("tr").findElements());




        //List<WebElement> grids =

    }

}