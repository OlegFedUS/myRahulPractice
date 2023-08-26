package rahulSection7;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import runner.BaseUtils;

public class CalendarUI extends BaseUtils {

    @Test
    void calendarTest() throws Exception{

        getDriver().findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        getDriver().findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Dehradun')]")).click();
        getDriver().findElement(By.xpath("(//a[@value='STV'][normalize-space()='Surat (STV)'])[2]")).click();
        getDriver().findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();


    }

}
