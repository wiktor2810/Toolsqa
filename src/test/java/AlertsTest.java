import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.DemoSites;

public class AlertsTest extends Base{

    AlertsPage alertsPage;

    @BeforeMethod
    public void setUpBeforeMethod(){
        alertsPage = new AlertsPage(driver);
    }

    @Test
    public void alert(){

        homePage.clickDemoSites();
        DemoSites demoSites = new DemoSites(driver);
        demoSites.clickHandlingAlerts();

        alertsPage.clickButton1Alert()
                .acceptSimpleAlert()
                .clickButton2Alert()
                .handleConfirmationAlert()
                .clickButton3Alert()
                .handlePromptAlert();
    }

}
