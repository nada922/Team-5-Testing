package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Test
    public void LoginTest(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        // Wait for username
        WebElement UsernameLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
        UsernameLocator.sendKeys("Admin");

        // Wait for password
        WebElement PasswordLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        PasswordLocator.sendKeys("admin123");

        // Wait for the login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();
    }

    @Test
    public void invalidLogin(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Wait for username
        WebElement UsernameLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
        UsernameLocator.sendKeys("adin");

        // Wait for password
        WebElement PasswordLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        PasswordLocator.sendKeys("admin123");

        // Wait for the login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();
//        WebElement errorMessage = driver.findElement(By.xpath(
//                "//div[@class='orangehrm-login-form']/div[@class='orangehrm-login-error']" +
//                        "//div[@role='alert']//p[text()='Invalid credentials']"));

//        Assert.assertTrue(loginPage.getLoginHeaderText().contains("Login"));

    }

}
