package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFramePage extends BasePage{

    JavascriptExecutor je = (JavascriptExecutor) driver;


    public IFramePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".main-nav .menu-item-17581")
    private WebElement homeButton;

    @FindBy(id = "submit")
    private WebElement submitIFame1;

    @FindBy(partialLinkText = "Read more")
    private WebElement readmoreButtonIFrame2;

    @FindBy(name = "iframe1")
    private WebElement iframeForm;

    @FindBy(name = "iframe2")
    private WebElement iframeHello;

    public void clickHomeButton(){
        je.executeScript("window.scrollBy(0,0)");
        homeButton.click();
    }

    public IFramePage clickSubmitIFrameForm(){
        submitIFame1.click();
        return this;
    }

    public IFramePage clickReadMoreIFrameHello(){
        readmoreButtonIFrame2.click();
        return this;
    }

    public IFramePage switchToDefaultContent(){
        driver.switchTo().defaultContent();
        return this;
    }

    public IFramePage switchToIFrameForm(){
        explicitWaitMethod(iframeForm);
        driver.switchTo().frame(iframeForm);
        return this;
    }

    public IFramePage switchToIFrameHello(){
        explicitWaitMethod(iframeHello);
        driver.switchTo().frame(iframeHello);
        return this;
    }

    public void explicitWaitMethod(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

}
