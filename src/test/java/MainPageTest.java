import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest(description = "run browser, open page")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        driver.get("https://demo.realworld.io/");
    }

    @AfterTest(description = "close browser")
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "check filtering by tags")
    public void test() {
        List<WebElement> tags = mainPage.getTags();
        for (WebElement tag : tags) {
            mainPage.clickTag(tag);
            mainPage.assertTopTagIsTheSame(tag);
            List<WebElement> postTags = mainPage.getPostsTags();
            for (WebElement postTag : postTags) {
                mainPage.assertPostTagIsTheSame(postTag);
            }
        }
    }
}
