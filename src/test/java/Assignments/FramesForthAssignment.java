package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.time.Duration;

public class FramesForthAssignment extends BaseUtils {

    @Test
    void nestedFramesTest() {

        getDriver().get("https://the-internet.herokuapp.com/nested_frames");

        getDriver().switchTo().frame("frame-top");
        getDriver().switchTo().frame("frame-middle");

        System.out.println(getDriver().findElement(By.id("content")).getText());

        
    }
}

