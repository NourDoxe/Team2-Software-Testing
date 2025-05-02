package sitesTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        homePage = loginPage.clickLoginBtn(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","You have not logged in!");

    }
    @Test
    public void invalidLoginTest(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admi");
        loginPage.typePassword("admin123");
        homePage = loginPage.clickLoginBtn(driver);


        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login","You have not been blocked!");
        Assert.assertTrue(loginPage.getLoginHeaderText().contains("Login"),"You have not been blocked! 2");


    }


}
