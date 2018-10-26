import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoSites;
import pages.IFramePage;

public class IFrameTest extends Base {

    IFramePage iFramePage;

    @BeforeMethod
    public void setUpBeforeMethod(){
        iFramePage = new IFramePage(driver);
    }

    @Test
    public void iframe() {

        homePage.clickDemoSites();
        DemoSites demoSites = new DemoSites(driver);
        demoSites.clickIFramePracticePage();

        iFramePage.switchToIFrameForm()
                .clickSubmitIFrameForm()
                .switchToDefaultContent()
                .switchToIFrameHello()
                .clickReadMoreIFrameHello()
                .switchToDefaultContent()
                .clickHomeButton();

    }
}
