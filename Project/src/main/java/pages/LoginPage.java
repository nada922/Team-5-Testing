package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        LoginDriver.findElement(UsernameLocator).sendKeys(username);
    }
    public void typePassword(String password){
        LoginDriver.findElement(UsernameLocator).sendKeys(password);
    }
    public HomePage clickLoginBtn(WebDriver driver){
     LoginDriver.findElement(loginBtn).click();
     return new HomePage(driver);
    }
    public String getLoginHeaderText(){
       return LoginDriver.findElement(LoginHeader).getText();
    }

}