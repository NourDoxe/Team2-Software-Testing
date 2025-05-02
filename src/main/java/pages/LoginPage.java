package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //WebDriver of the page !
    WebDriver loginDriver;


    //Locators !
    By usernameFieldLocator = By.xpath("//input[@name='username']");
    By passwordFieldLocator = By.xpath("//input[@name='password']");
    By loginBtnLocator = By.tagName("button");
    By loginHeaderLocator = By.tagName("h5");


    //Constructor !
    public LoginPage(WebDriver driver){
        loginDriver = driver;
    }

    //actions on the page !
    public void typeUsername(String username){
       // loginDriver.findElement(usernameFieldLocator).sendKeys(username);
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
        tempUsername.sendKeys(username);
    }

    public void typePassword(String password){
       // loginDriver.findElement(passwordFieldLocator).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        tempPassword.sendKeys(password);
    }

    public HomePage clickLoginBtn(WebDriver driver){
        //loginDriver.findElement(loginBtnLocator).click();
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempLoginBtnClick = wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator));
        tempLoginBtnClick.click();
        return new HomePage(driver);
    }

    public String getLoginHeaderText(){
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempLoginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeaderLocator));
        return tempLoginHeader.getText();
    }

}
