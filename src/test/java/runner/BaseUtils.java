package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

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




}
