package rahulSection7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.util.List;

public class Dropdowns extends BaseUtils {

    @Test
    @Ignore
    void staticDropdown(){

        WebElement elementDrop = getDriver().findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDrop = new Select(elementDrop);
        staticDrop.selectByVisibleText("USD");
        String staticTxt = staticDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(staticTxt, "USD");
    }

    @Test
    @Ignore
    void dropdownButtonClick() throws Exception{

        getDriver().findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        WebElement button = getDriver().findElement(By.id("hrefIncInf"));
        for (int i = 0; i < 4; i++){
            button.click();
        }
        Assert.assertEquals(getDriver().findElement(By.id("spanInfant")).getText(), "4");
    }

    @Test
    @Ignore
    void dynamicDropdown() throws Exception{

        getDriver().findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        Thread.sleep(2000);

        List<WebElement> dropList = getDriver().findElements(By.cssSelector("td.mapbg"));
        for (WebElement option : dropList){
            String getText = option.getText();
            if (getText.contains("Dehradun")){
                option.click();
                break;
            }
        }

    }

}
