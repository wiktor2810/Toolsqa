import org.testng.annotations.Test;
import pages.DemoSites;
import pages.TablePage;


public class TableTest extends Base{

    TablePage tablePage;

    @Test
    public void table(){

        homePage.clickDemoSites();
        DemoSites demoSites = new DemoSites(driver);
        demoSites.clickAutomationPracticeTable();
        tablePage = new TablePage(driver);
        tablePage.readingTable()
                .verifySuccess()
                .printStructuresHigherThanRandomNumber();
    }
}
