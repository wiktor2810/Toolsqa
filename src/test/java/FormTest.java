import org.testng.annotations.Test;
import pages.DemoSites;
import pages.FormPage;

public class FormTest extends Base {

    FormPage formPage;

    @Test
    public void form(){

        homePage.clickDemoSites();
        DemoSites demoSites = new DemoSites(driver);
        demoSites.clickAutomationPracticeForm();
        formPage = new FormPage(driver);
        formPage.typeFirstName("Wiktor")
                .typeLastName("Szymanowski")
                .chooseSex()
                .chooseExperience()
                .chooseDate()
                .chooseProfession()
                .choosePhoto()
                .chooseTool()
                .chooseContinent()
                .chooseAustralia()
                .chooseSwitchCommand()
                .submitForm()
                .verifySuccess();
    }
}
