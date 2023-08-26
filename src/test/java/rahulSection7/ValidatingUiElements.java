package rahulSection7;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class ValidatingUiElements extends BaseUtils {

    @Test
    void disabledOrEnabled() throws Exception{

        System.out.println(getDriver().findElement(By.id("Div1")).getAttribute("style"));

        getDriver().findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        if (getDriver().findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("Is Enabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("Is Disabled");
            Assert.assertTrue(false);
        }




    }

}
