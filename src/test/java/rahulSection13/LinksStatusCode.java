package rahulSection13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import runner.BaseUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LinksStatusCode extends BaseUtils {

    @Test
    void linksTest() throws Exception{

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

       String url =  getDriver().findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int code = conn.getResponseCode();

        System.out.println(code);

        //Req2

        SoftAssert a = new SoftAssert();

        List<WebElement> links = getDriver().findElements(By.cssSelector("li[class='gf-li'] a"));

        for (WebElement options : links){

            String urlLoop = options.getAttribute("href");

            HttpURLConnection connLoop = (HttpURLConnection) new URL(urlLoop).openConnection();
            connLoop.setRequestMethod("HEAD");
            connLoop.connect();
            int codeLoop = connLoop.getResponseCode();
            System.out.println(codeLoop);

            a.assertTrue(codeLoop<400, "=Fail=Chao PoKa!!!");
        }

        a.assertAll();


    }

}
