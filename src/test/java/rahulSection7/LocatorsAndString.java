package rahulSection7;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class LocatorsAndString extends BaseUtils {

    @Test
    void test() throws Exception {

        getDriver().get("https://rahulshettyacademy.com/locatorspractice/");//a[contains(text(),'Forgot your password?')]
        getDriver().findElement(By.cssSelector("#inputUsername")).sendKeys("rahulSection7");
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(getPassword());
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("#chkboxOne")).click();
        getDriver().findElement(By.cssSelector("#chkboxTwo")).click();
        getDriver().findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        String welcomeMessage = getDriver().findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText();
        Assert.assertEquals(welcomeMessage, "You are successfully logged in.");
        getDriver().navigate().to("https://google.com");
        getDriver().navigate().back();




    }
}
