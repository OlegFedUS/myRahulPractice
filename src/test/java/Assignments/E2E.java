package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class E2E extends BaseUtils {

    @Test
    void planeTicketTest() throws Exception {


        getDriver().findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]"))
                .sendKeys("Ind");
        List<WebElement> countries = getDriver().findElements(By.cssSelector("li[class='ui-menu-item']"));
        for (WebElement option : countries){
            String countryName = option.getText().toLowerCase();
            if (countryName.contains("indonesia")){
                option.click();
                break;
            }
        }

        getDriver().findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        getDriver().findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Lakhimpur (IXI)')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("(//a[@value='BLR'][normalize-space()='Bengaluru (BLR)'])[2]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        getDriver().findElement(By.id("divpaxinfo")).click();
        WebElement children = getDriver().findElement(By.id("hrefIncChd"));
        for (int i = 0; i < 4; i++){
            children.click();
        }

        WebElement currencyEmt = getDriver().findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currency = new Select(currencyEmt);
        currency.selectByIndex(2);

        getDriver().findElement(By.id("ctl00_mainContent_chk_Unmr")).click();

        getDriver().findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    }

}
