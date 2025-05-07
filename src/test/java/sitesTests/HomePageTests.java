package sitesTests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HomePageTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;


    @Test
    public void loginTest(){
        // Perform login
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        homePage = loginPage.clickLoginBtn(driver);

        // Wait for dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard/index"));

        // Verify successful login
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        Assert.assertTrue(currentUrl.contains("dashboard/index"),
                "Login failed. Current URL: " + currentUrl);
    }




    @Test(dependsOnMethods = "loginTest")
    public void logoutTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));

        // Perform logout
        homePage.clickOnLogoutBtn(driver);

        // Wait for login page to load
        wait.until(ExpectedConditions.urlContains("auth/login"));

        // Verify logout was successful
        String loginHeader = loginPage.getLoginHeaderText();
        Assert.assertTrue(loginHeader.contains("Login"),
                "Logout failed. Page header: " + loginHeader);


    }

    @Test(dependsOnMethods = "logoutTest")
    public void backClick(){
        // Click on the return button
        driver.navigate().back();
        // Check if you're on the login page
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login","it returned you to home page!");
    }

}