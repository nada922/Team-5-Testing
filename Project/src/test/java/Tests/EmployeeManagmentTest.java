package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class EmployeeManagmentTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;










    @Test
    public void addEmployeeTest() {


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for username
        WebElement UsernameLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")));
        UsernameLocator.sendKeys("Admin");

        // Wait for password
        WebElement PasswordLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        PasswordLocator.sendKeys("admin123");

        // Wait for the login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();
        //Leave button
        WebElement PimBtnLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'oxd-main-menu-item')]//span[text()='PIM']/parent::a")));
        PimBtnLocator.click();
        WebElement AddBtnLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(., 'Add')]")));
        AddBtnLocator.click();
        //Type Employee name
        try {

            WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, '--name-grouped-field')]//input[@name='firstName']")));

            employeeNameField.clear();
            employeeNameField.sendKeys("adam");


            Thread.sleep(4000); // Wait 4 seconds for dropdown

            //employeeNameField.sendKeys(Keys.ARROW_DOWN);
            //employeeNameField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

        } catch (Exception e) {
            Assert.fail("Failed to select employee: " + e.getMessage());
        }
//button[@type='button' and contains(., 'Add')]
//Type Employee name
        try {

            WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Last Name']")));

            employeeNameField.clear();
            employeeNameField.sendKeys("mike");


            Thread.sleep(4000); // Wait 4 seconds for dropdown

            //employeeNameField.sendKeys(Keys.ARROW_DOWN);
            //employeeNameField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

        } catch (Exception e) {

            Assert.fail("Failed to select employee: " + e.getMessage());

        }
        WebElement SaveBtnLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]")));
        SaveBtnLocator.click();

        //button[@type='submit' and contains(@class, 'oxd-button--secondary')]

    }
}
