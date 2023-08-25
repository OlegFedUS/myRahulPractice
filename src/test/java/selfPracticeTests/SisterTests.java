package selfPracticeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class SisterTests extends BaseUtils {

    @Test
    void motivationWebPage() throws Exception{

        getDriver().get("https://octagonal-important-bottle.glitch.me/");
        System.out.println(getDriver().getCurrentUrl());
        String txt = getDriver().findElement(By.xpath("//h1[contains(text(),'Daily Motivation App')]")).getText();
        Assert.assertEquals(txt, "Daily Motivation App");

        WebElement button = getDriver().findElement(By.id("btn"));
        String motivationMessage = getDriver().findElement(By.id("par")).getText();


        for (int i = 0; i < 100; i++){
            button.click();
            Thread.sleep(1000);
            if (motivationMessage.contains("Do one thing every day that scares you. ―Eleanor Roosevelt")){
                break;
            }

        }






    }

}
