package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class AssignmentFifthMajor2 extends BaseUtils {

    @Test
    void testAssignment(){

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        getDriver().manage().window().maximize();

        //Req1 Button click + Req2 Button text
        getDriver().findElement(By.id("checkBoxOption1")).click();
        String buttonText = getDriver().findElement(By.xpath("//label[@for='bmw']")).getText().trim();


        //Req3 dropdown
        WebElement select = getDriver().findElement(By.id("dropdown-class-example"));
        Select option = new Select(select);
        option.selectByVisibleText(buttonText);

        //Req4
        getDriver().findElement(By.id("name")).sendKeys(buttonText);
        getDriver().findElement(By.id("alertbtn")).click();

        //extraReq

        String messageText = getDriver().switchTo().alert().getText();

        if (messageText.contains(buttonText)){
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }

        getDriver().switchTo().alert().accept();
        getDriver().quit();
    }

}
