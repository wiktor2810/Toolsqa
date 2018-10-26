package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FormPage extends BasePage{

    List<WebElement> elements;

    public FormPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        waitToSetupElements();
    }
    @FindBy(css = "input[name='firstname']")
    private WebElement firstName;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastName;

    @FindBy(css = "#sex-0")
    private WebElement sexCheckbox;

    @FindBy(css = "#exp-0")
    private WebElement experienceCheckbox;

    @FindBy(css = "input[id='datepicker']")
    private WebElement date;

    @FindBy(css = "#profession-1")
    private WebElement profession;

    @FindBy(css = "#photo")
    private WebElement photo;

    @FindBy(css = "#tool-0")
    private WebElement tool;

    @FindBy(css = "#continents")
    private WebElement continents;

    @FindBy(xpath = "//*[.='Australia']")
    private WebElement australia;

    @FindBy(xpath = "//*[.='Switch Commands']")
    private WebElement switchCommands;

    @FindBy(css = "#submit")
    private WebElement submit;


    public FormPage typeFirstName(String name){
        this.firstName.sendKeys(name);
        return this;
    }

    public FormPage typeLastName(String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage chooseSex(){
        this.sexCheckbox.click();
        return this;
    }

    public FormPage chooseExperience(){
        this.experienceCheckbox.click();
        return this;
    }

    public FormPage chooseDate(){
        this.date.click();
        return this;
    }

    public FormPage chooseProfession(){
        this.profession.click();
        return this;
    }

    public FormPage choosePhoto(){
        File file = new File(getClass().getClassLoader().getResource("css.png").getFile());
        this.photo.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage chooseTool(){
        this.tool.click();
        return this;
    }

    public FormPage chooseContinent(){
        this.continents.click();
        return this;
    }

    public FormPage chooseAustralia(){
        this.australia.click();
        return this;
    }

    public FormPage chooseSwitchCommand(){
        this.switchCommands.click();
        return this;
    }

    public FormPage submitForm(){
        this.submit.click();
        return this;
    }

    public void verifySuccess(){
        WebElement firstName2 = driver.findElement(By.cssSelector("input[name='firstname']"));
        String value = firstName2.getAttribute("value");
        Assert.assertEquals(value, "");


        WebElement sexCheckbox2 = driver.findElement(By.cssSelector("#sex-0"));
        boolean isSexSelected = sexCheckbox2.isSelected();
        Assert.assertEquals(isSexSelected, false);
    }

    public void waitToSetupElements(){
        elements = new ArrayList<WebElement>();
        elements.add(firstName);
        elements.add(lastName);
        elements.add(sexCheckbox);
        elements.add(experienceCheckbox);
        elements.add(profession);
        elements.add(photo);
        elements.add(date);
        elements.add(tool);
        elements.add(continents);
        elements.add(switchCommands);
        elements.add(submit);
        waitForElements(elements);
    }
}
