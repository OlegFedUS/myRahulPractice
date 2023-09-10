package rahulSection11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import runner.BaseUtils;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OpenPageInNewWindow extends BaseUtils {

        @Test
        void newPagesTest() throws Exception {

            getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

            WebElement limitedDriver = getDriver().findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));

            //req1 To open new pages (in new windows) from List (using limitedDriver from Req3).
            //Using "Key Event", for keyboard simulation.

            List<WebElement> webList = limitedDriver.findElements(By.tagName("a"));

            for (int i = 1; i < webList.size(); i++) {

                String keyEvent = Keys.chord(Keys.CONTROL, Keys.ENTER); //Мы создаем строку в качестве "Key Event". "Control + Enter".
                webList.get(i).sendKeys(keyEvent); //Передаем строку, как аргумент, вместо использования метода Click();
                Thread.sleep(5000L);
            }

            //req2 Iterate through all opened pages, and gather all title text from it.
            Set<String> windows = getDriver().getWindowHandles();
            Iterator<String> iteration = windows.iterator();

            while (iteration.hasNext()) {
                getDriver().switchTo().window(iteration.next());
                System.out.println(getDriver().getTitle());
            }
        }

    }

