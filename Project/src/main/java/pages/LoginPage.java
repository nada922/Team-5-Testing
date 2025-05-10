package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //webdriver
    WebDriver LoginDriver;

    //locators
    By UsernameLocator = By.xpath("//input[@name='username']");
    By PasswordLocator = By.xpath("//input[@type='password']");
    By loginBtn = By.xpath("//button[@type='submit']");
    By LoginHeader = By.tagName("h5");

    //Constructor
    public LoginPage(WebDriver driver){
    LoginDriver = driver;
    }
    //Actions
    public void typeUsername(String username){
        WebDriverWait wait = new WebDriverWait(LoginDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(UsernameLocator));
        LoginDriver.findElement(UsernameLocator).sendKeys(username);

    }
    public void typePassword(String password){
        WebDriverWait wait = new WebDriverWait(LoginDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(PasswordLocator));
        LoginDriver.findElement(PasswordLocator).sendKeys(password);

    }
    public HomePage clickLoginBtn(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(LoginDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
     LoginDriver.findElement(loginBtn).click();
     return new HomePage(driver);
    }
    public String getLoginHeaderText(){
       return LoginDriver.findElement(LoginHeader).getText();
    }

}