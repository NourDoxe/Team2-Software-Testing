package sitesTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class PerformanceReview extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void addPerformanceReview(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        homePage = loginPage.clickLoginBtn(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

        homePage.clickOnPerfomance();


    }
}
