package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoSites extends BasePage{

    List<WebElement> elements;

    public DemoSites(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        waitToSetupElements();
    }

    @FindBy(css = ".menu-item-22594")
    private WebElement automationPracticeForm;

    @FindBy(css = ".menu-item-22593")
    private WebElement automationPracticeSwitchWindows;

    @FindBy(css = ".menu-item-22592")
    private WebElement automationPracticeTable;

    @FindBy(css = ".menu-item-23109")
    private WebElement handlingAlerts;

    @FindBy(css = ".menu-item-23300")
    private WebElement iframePracticePage;

    public void clickAutomationPracticeForm(){
        automationPracticeForm.click();
    }

    public void clickAutomationPracticeSwitchWindow(){
        automationPracticeSwitchWindows.click();
    }

    public void clickAutomationPracticeTable(){
        automationPracticeTable.click();
    }

    public void clickHandlingAlerts(){
        handlingAlerts.click();
    }

    public void clickIFramePracticePage(){
        iframePracticePage.click();
    }

    public void waitToSetupElements(){
        elements = new ArrayList<WebElement>();
        elements.add(automationPracticeTable);
        elements.add(automationPracticeForm);
        elements.add(automationPracticeSwitchWindows);
        elements.add(handlingAlerts);
        elements.add(iframePracticePage);
        waitForElements(elements);
    }
}
