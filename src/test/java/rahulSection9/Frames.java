package rahulSection9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.time.Duration;

public class Frames extends BaseUtils {

    @Test
    void frameTest(){

        getDriver().get("https://jqueryui.com/droppable/");

        WebElement frame = getDriver().findElement(By.xpath("//iframe"));
        getDriver().switchTo().frame(frame);

        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(drag, drop).build().perform();

        String text = drop.getText();
        Assert.assertEquals(text, "Dropped!");
    }

}
