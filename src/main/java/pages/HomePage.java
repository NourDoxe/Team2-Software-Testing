package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //WebDriver of the page
    WebDriver HomeDriver;
    WebDriverWait wait = new WebDriverWait(HomeDriver, Duration.ofSeconds(10));
    //Locators idk yet
    By personalSubMenu = By.className("oxd-userdropdown-tab");
    By logoutBtnLocator = By.xpath("//a[@href='/web/index.php/auth/logout']");

    //Constructor !
    public HomePage(WebDriver driver){
        HomeDriver=driver;
    }

    //actions on the page !
    public LoginPage clickOnLogoutBtn(WebDriver driver){

        WebElement tempPersonalMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(personalSubMenu));
        tempPersonalMenu.click();

        WebElement templogoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator));
        templogoutBtn.click();

        //HomeDriver.findElement(personalSubMenu).click();
        //HomeDriver.findElement(logoutBtnLocator).click();
        return new LoginPage(driver);
    }


}
