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
    WebDriverWait wait;
    //locators
    By UsernameLocator = By.xpath("//input[@name='username']");
    By PasswordLocator = By.xpath("//input[@type='password']");
    By loginBtn = By.xpath("//button[@type='submit']");
    By LoginHeader = By.tagName("h5");

    //Constructor
    public LoginPage(WebDriver driver){

        LoginDriver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //Actions

    public void login(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        passwordField.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();
    }

    public String getLoginHeaderText(){
        return LoginDriver.findElement(LoginHeader).getText();
    }


}