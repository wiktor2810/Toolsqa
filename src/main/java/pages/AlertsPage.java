package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage{

    JavascriptExecutor je = (JavascriptExecutor) driver;

    public AlertsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[onclick='pushAlert()']")
    private WebElement button1Alert;

    @FindBy(css = "button[onclick='pushConfirm()']")
    private WebElement button2Alert;

    @FindBy(css = "button[onclick='promptConfirm()']")
    private WebElement button3Alert;



    public AlertsPage clickButton1Alert(){
        explicitWaitMethod(button1Alert);
        button1Alert.click();
        return this;
    }

    public AlertsPage clickButton2Alert(){
        je.executeScript("window.scrollBy(0,500)");
        explicitWaitMethod(button2Alert);
        button2Alert.click();
        return this;
    }

    public AlertsPage clickButton3Alert(){
        explicitWaitMethod(button3Alert);
        button3Alert.click();
        return this;
    }


    public AlertsPage acceptSimpleAlert(){
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        return this;
    }

    public AlertsPage handleConfirmationAlert(){
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.dismiss();
        return this;
    }

    public void handlePromptAlert(){
        Alert confirmationAlert = driver.switchTo().alert();
        String textOfPromptAlert = confirmationAlert.getText();
        System.out.println(textOfPromptAlert);
        confirmationAlert.sendKeys("No");
        confirmationAlert.accept();
    }

    public void explicitWaitMethod(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
