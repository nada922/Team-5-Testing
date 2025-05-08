package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    //webdriver
    WebDriver LoginDriver;
    private WebDriverWait wait;

    //locators
    By UsernameLocator = By.xpath("//input[@name='username']");
    By PasswordLocator = By.xpath("//input[@type='password']");
    By loginBtn = By.xpath("//button[@type='submit']");
    By LoginHeader = By.tagName("h5");

    //Constructor
    public LoginPage(WebDriver driver){
        LoginDriver = driver;
        this.wait = new WebDriverWait(LoginDriver, Duration.ofSeconds(10));
    }

    //Actions
    public void typeUsername(String username){
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(UsernameLocator));
        usernameElement.sendKeys(username);
    }

    public void typePassword(String password){
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(PasswordLocator));
        passwordElement.sendKeys(password);
    }

    public HomePage clickLoginBtn(WebDriver driver){
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginButton.click();
        return new HomePage(driver);
    }

    public String getLoginHeaderText(){
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeader));
        return header.getText();
    }

    //New convenience method for login
    public HomePage login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return clickLoginBtn(LoginDriver);
    }
}