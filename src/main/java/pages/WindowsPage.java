package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button1")
    private WebElement button1;

    @FindBy(css = "button[onclick='newMsgWin()']")
    private WebElement button2;

    @FindBy(css = "button[onclick='newBrwTab()']")
    private WebElement button3;

    @FindBy(linkText = "Selenium Training")
    private WebElement enroll;

    @FindBy(tagName = "body")
    private WebElement body;


    public WindowsPage clickButton1(){
        explicitWaitMethod(button1);
        button1.click();
        return this;
    }

    public WindowsPage clickButton2(){
        explicitWaitMethod(button2);
        button2.click();
        return this;
    }

    public WindowsPage clickButton3(){
        explicitWaitMethod(button3);
        button3.click();
        return this;
    }

    public WindowsPage switchToParentHandle(String parentHandle){
        driver.switchTo().window(parentHandle);
        return this;
    }

    public WindowsPage switchToAnotherWindow(String parentHandle){
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        windowHandles.remove(parentHandle);
        String secondHandle = windowHandles.iterator().next();
        driver.switchTo().window(secondHandle);
        return this;
    }

    public WindowsPage clickElementAndCloseWindow(){
        explicitWaitMethod(enroll);
        enroll.click();
        driver.close();
        return this;
    }

    public WindowsPage clickElementAndCloseWindow2(){
        explicitWaitMethod(body);
        body.click();
        driver.close();
        return this;
    }

    public WindowsPage getTextAndPrint(){
        System.out.println(body.getText());
        return this;
    }

    public void explicitWaitMethod(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

}
