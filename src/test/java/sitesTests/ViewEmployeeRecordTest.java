package sitesTests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class ViewEmployeeRecordTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void recordFoundTest() {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        homePage = loginPage.clickLoginBtn(driver);
        homePage.clickOnPimBtn();


        if (homePage.getRecordFoundText().contains("Records Found")) {
            takeScreenShot(driver, "src/test/resources/validViewEmployeeRecordTest.png");
        }
        else {
            takeScreenShot(driver, "src/test/resources/invalidViewEmployeeRecordTest.png");
            throw new AssertionError("Something occurred while getting records.");
        }

    }

}