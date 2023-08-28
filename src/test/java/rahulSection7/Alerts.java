package rahulSection7;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class Alerts extends BaseUtils {

    @Test
    void alerts(){

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

     getDriver().findElement(By.id("name")).sendKeys("Oleg");
     getDriver().findElement(By.id("confirmbtn")).click();

        System.out.println(getDriver().switchTo().alert().getText());
     getDriver().switchTo().alert().dismiss();

        getDriver().findElement(By.id("name")).sendKeys("Maslaev");
        getDriver().findElement(By.id("alertbtn")).click();

        System.out.println(getDriver().switchTo().alert().getText());
        getDriver().switchTo().alert().accept();

    }
}
