package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    List<WebElement> elements;

    public HomePage(WebDriver driver){
        super(driver);
        driver.get("http://toolsqa.com/");
        PageFactory.initElements(driver, this);
        waitToSetupElements();
    }

    @FindBy(css = ".main-nav .menu-item-17581")
    private WebElement home;

    @FindBy(css = ".main-nav .menu-item-17611")
    private WebElement demoSites;

    public void clickHome(){
        home.click();
    }

    public void clickDemoSites(){
        demoSites.click();
    }

    public void getHomePage(){
        driver.get("http://toolsqa.com/");
    }

    public void waitToSetupElements(){
        elements = new ArrayList<WebElement>();
        elements.add(home);
        elements.add(demoSites);
        waitForElements(elements);
    }
}
