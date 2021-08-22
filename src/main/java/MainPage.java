import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private String tagText;

    private By tags = By.cssSelector(".tag-list a");
    private By postsTags = By.cssSelector("ul[class=\"tag-list\"]");
    private By topTag = By.cssSelector("[class=\"nav-link active ng-binding\"]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getTags(){
        waitFor(tags);
        return driver.findElements(tags);
    }

    public void clickTag(WebElement tag){
        tag.click();
    }

    public void assertTopTagIsTheSame(WebElement tag) {
        tagText = tag.getText();
        String topTagText = driver.findElement(topTag).getText();
        Assert.assertEquals(topTagText, tagText);
    }

    public List<WebElement> getPostsTags(){
        waitFor(postsTags);
        return driver.findElements(postsTags);
    }

    public void assertPostTagIsTheSame(WebElement postTag){
        String postTagText = postTag.getText();
        Assert.assertTrue(postTagText.contains(tagText));
    }

    public void waitFor(By element){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
