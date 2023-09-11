package rahulSection12;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class Scroll extends BaseUtils {

    @Test
    void scrollTest(){

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) getDriver(); // Cast my driver to Javascript Executor
        js.executeScript("window.scrollBy(0,1000)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
    }

}
