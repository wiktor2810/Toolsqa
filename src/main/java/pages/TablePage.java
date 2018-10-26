package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import template.Skyscraper;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage{

    ArrayList<Skyscraper> listOfScyscrapers;
    List<List<WebElement>> elements;

    public TablePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        waitToSetupElements();
    }

    @FindBy(tagName = "tr")
    private List<WebElement> rows;

    @FindBy(tagName = "td")
    private List<WebElement> cellsOfRow;

    public TablePage readingTable() {
        listOfScyscrapers = new ArrayList<Skyscraper>();

        List<WebElement> list = driver.findElements(By.tagName("tr"));

        for (int i = 2; i < 6; i++) {
            List<WebElement> cells = list.get(i).findElements(By.tagName("td"));
            String structure = list.get(i).findElement(By.cssSelector("th")).getText();
            String country = cells.get(0).getText();
            String city = cells.get(1).getText();
            int height = Integer.valueOf(cells.get(2).getText().substring(0, 3));
            int build = Integer.valueOf(cells.get(3).getText());
            int rank = Integer.valueOf(cells.get(4).getText());
            String details = cells.get(5).getText();
            Skyscraper skyscraper = new Skyscraper(structure, country, city, height, build, rank, details);
            listOfScyscrapers.add(skyscraper);
        }
        return this;
    }


        public TablePage verifySuccess(){
            for(int i = 0; i < listOfScyscrapers.size(); i++) {
                String structure = listOfScyscrapers.get(i).getStructure();
                String[] expectedList = {"Burj Khalifa", "Clock Tower Hotel", "Taipei 101", "Financial Center"};
                Assert.assertEquals(structure, expectedList[i]);
            }
            return this;
        }


        public void printStructuresHigherThanRandomNumber(){
            int n = 400 + (int)(Math.random() * ((800 - 400) + 1));

            System.out.println(n);

            for(int i = 0; i < listOfScyscrapers.size(); i++){
                int height = listOfScyscrapers.get(i).getHeight();
                if(height > n){
                    System.out.println(listOfScyscrapers.get(i).getStructure());
                }
            }
        }

    public void waitToSetupElements(){
        elements = new ArrayList<List<WebElement>>();
        elements.add(rows);
        elements.add(cellsOfRow);
        waitForElements2(elements);
    }

}
