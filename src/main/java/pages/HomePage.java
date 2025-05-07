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
    WebDriverWait wait;
    //Locators
    By personalSubMenu = By.className("oxd-userdropdown-tab");
    By logoutBtnLocator = By.xpath("//a[@href='/web/index.php/auth/logout']");
    By pimBtnLocator = By.xpath("//span[text()='PIM']");
    By RecordFoundTextLocator = By.xpath("//span[contains(.,' Records Found')]");

    //Constructor !
    public HomePage(WebDriver driver) {
        HomeDriver = driver;
    }

    //actions on the page !
    public void clickOnLogoutBtn(WebDriver driver) {
        wait = new WebDriverWait(HomeDriver, Duration.ofSeconds(10));
        WebElement tempPersonalMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(personalSubMenu));
        tempPersonalMenu.click();

        WebElement templogoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator));
        templogoutBtn.click();

        new LoginPage(driver);
    }

    // click on pim
    public HomePage clickOnPimBtn(){
        wait = new WebDriverWait(HomeDriver, Duration.ofSeconds(10));
        WebElement tempPimBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(pimBtnLocator));
        tempPimBtn.click();

        return this;
    }

    public String getRecordFoundText () {
        WebDriverWait wait = new WebDriverWait(HomeDriver, Duration.ofSeconds(10));
        WebElement tempRecordFoundText = wait.until(ExpectedConditions.visibilityOfElementLocated(RecordFoundTextLocator));
        return tempRecordFoundText.getText();
    }






}
