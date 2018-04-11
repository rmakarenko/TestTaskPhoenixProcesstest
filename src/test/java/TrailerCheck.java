import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmakaren on 11.04.2018.
 */
public class TrailerCheck {

    @Test
    public void CheckYandexVideoTrailers() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/video/search?text=%D1%83%D1%80%D0%B0%D0%B3%D0%B0%D0%BD&path=main&reqid=1523288148193198-1047723415193269043788330-sas1-1664-V");
        List<WebElement> list; // = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath("//div[@class='serp-controller__content']/div[1]/descendant::*"));

        int i = 0;

        for (WebElement we : list) {
            String s = we.getAttribute("class");
            System.out.println("Attribute class: " + s);
            if (s.contains("preview_yes")) {
                System.out.println("Preview is presented on the page");
                return;
            }
        }

        driver.quit();
    }
}
