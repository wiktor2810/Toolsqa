package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElements(List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    //dlaczego nie mogę przeciążyć tej metody? nie bierze pod uwage generics ?

    public void waitForElements2(List<List<WebElement>> elements1){
        for(List<WebElement> elements : elements1) {
            waitForElements(elements);
        }
    }
}
