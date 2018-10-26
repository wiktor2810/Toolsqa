import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoSites;
import pages.WindowsPage;

public class WindowTest extends Base {

    WindowsPage windowsPage;

    @BeforeMethod
    public void setUpBeforeMethod(){
        windowsPage = new WindowsPage(driver);
    }

    @Test
    public void window(){

        homePage.clickDemoSites();

        DemoSites demoSites = new DemoSites(driver);
        demoSites.clickAutomationPracticeSwitchWindow();

        String parentHandle = driver.getWindowHandle();
        windowsPage.clickButton1()
                .switchToAnotherWindow(parentHandle)
                .clickElementAndCloseWindow()
                .switchToParentHandle(parentHandle)
                .clickButton2()
                .switchToAnotherWindow(parentHandle)
                .getTextAndPrint()
                .clickElementAndCloseWindow2()
                .switchToParentHandle(parentHandle)
                .clickButton3()
                .switchToAnotherWindow(parentHandle)
                .clickElementAndCloseWindow()
                .switchToParentHandle(parentHandle)
                .clickButton1();


    }
}
