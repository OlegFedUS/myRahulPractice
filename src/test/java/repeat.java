import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import runner.BaseUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class repeat extends BaseUtils {

    @Test
    @Ignore
    void repeat() {

        getDriver().get("https://rahulshettyacademy.com/loginpagePractise/");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement click = getDriver().findElement(By.xpath("//a[@class='blinkingText']"));

        //Actions (Mouse, keyboard interactions & etc.)
        Actions act = new Actions(getDriver());
        act.moveToElement(click).click().build().perform();

        //Windows Handle.
        Set<String> windows = getDriver().getWindowHandles(); //id окон
        Iterator<String> iterate = windows.iterator(); // Я вытаскиваю ID's из Set-структуры, итерация по id окон (child/parent id's).
        String parent = iterate.next(); // it gets "next" id from Set, grub it.
        String child = iterate.next();
        getDriver().switchTo().window(child);
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong/a"))).getText();
        getDriver().switchTo().window(parent);

        System.out.println(text);
        System.out.println(parent);
        System.out.println(child);

    }

    @Test
    @Ignore
    void repeat2() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        int j = 0;
        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> allItems = getDriver().findElements(By.xpath("//div[@class='product']"));

        String[] arr = {"Brocolli", "Potato", "Carrot", "Onion", "Cucumber"};

        List<String> prNames = Arrays.asList(arr);

        for (int i = 0; i < allItems.size(); i++) {

            String[] names = allItems.get(i).getText().split("-");
            String format = names[0].trim();

            if (prNames.contains(format)) {
                j++;
                List<WebElement> buttons = getDriver().findElements(By.xpath("//div[@class='product-action']"));
                buttons.get(i).click();

                if (j == arr.length) {
                    break;
                }
            }
        }

        getDriver().findElement(By.xpath("//img[@alt='Cart']")).click();
        getDriver().findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']"))).sendKeys("123");
        WebElement button = getDriver().findElement(By.xpath("//button[text()='Apply']"));
        button.click();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))).getText();

        getDriver().navigate().back();

        System.out.println(message);

    }

    @Test
    @Ignore
    void repeat3() {

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement iframe = getDriver().findElement(By.id("courses-iframe"));
        getDriver().switchTo().frame(iframe);

        System.out.println(getDriver().findElement(By.xpath("//div[@class='price-title']")).getText());

        getDriver().navigate().back();

        Actions actions = new Actions(getDriver());
        WebElement radioButton = getDriver().findElement(By.xpath("//input[@value='radio2']"));

        actions.moveToElement(radioButton).click().build().perform();


    }

    @Test
    @Ignore
    void repeat4() {

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

    }

    @Test
    @Ignore
    void repeat5(){

        getDriver().get("https://expired.badssl.com/");

    }

    @Test
    @Ignore
    void repeatMajor1AddGrids() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //REQ1 add items to cart and proceed to checkout
        String[] names = {"Beans", "Onion", "Walnuts"};
        List<String> formNames = Arrays.asList(names);

        List<WebElement> itemsList = getDriver().findElements(By.xpath("//div[@class='product']"));

        for (int i = 0; i < itemsList.size(); i++) {

            String[] arr = itemsList.get(i).getText().split("-");
            String strimText = arr[0].trim();

            if (formNames.contains(strimText)) {
                getDriver().findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();

                if (i < names.length) {
                    break;
                }
            }
        }

        getDriver().findElement(By.cssSelector("img[alt='Cart']")).click();
        getDriver().findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        //REQ2 grab text from table grid, cast it from String to Integer,

        Integer num = 0;

       WebElement tableDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productCartTables")));
       List<WebElement> grids = tableDriver.findElements(By.cssSelector(".cartTable td:nth-child(5)"));

       for (int i = 1; i < grids.size(); i++){
          num = num + Integer.parseInt(grids.get(i).getText());
       }
       System.out.println(num);

       //REQ3 grab direct text from grid

        List<WebElement> text = tableDriver.findElements(By.tagName("tr")).get(3).findElements(By.tagName("td"));

        System.out.println(text.get(1).getText());

        //REQ5 Send keys, explicitWait

        getDriver().findElement(By.cssSelector("input[type='text']")).sendKeys("rahulshetty");
        getDriver().findElement(By.cssSelector("button[class='promoBtn']")).click();

        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']"))).getText());

        getDriver().findElement(By.xpath("//button[text()='Place Order']")).click();

        //REQ6 static dropdown, Checkbox

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[style='width: 200px;']")));

        Select select = new Select(element);
        select.selectByVisibleText("Russia");

        WebElement checkbox = getDriver().findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();

       WebElement buttonX = getDriver().findElement(By.xpath("//button[text()='Proceed']"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(buttonX).click().build().perform();;
    }

    @Test
    @Ignore
    void repeatStatusCodeTest() throws Exception{

        SoftAssert softAssert = new SoftAssert();

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement limitedDr = getDriver().findElement(By.id("gf-BIG"));

        List<WebElement> listLinks = limitedDr.findElements(By.cssSelector("li[class='gf-li'] a"));

        for (WebElement options : listLinks){

            String url = options.getAttribute("href");

            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int code = con.getResponseCode();
            System.out.println(con.getResponseCode());

            softAssert.assertTrue(code < 400, "Some of assertions are failed.");
        }
        softAssert.assertAll();

    }
}
