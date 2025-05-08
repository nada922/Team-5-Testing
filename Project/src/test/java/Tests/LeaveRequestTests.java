package Tests;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeaveRequestPage;
import pages.LoginPage;

import java.time.Duration;


public class LeaveRequestTests extends BaseTest {
    LeaveRequestPage leavePage;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void testReachingLeavePage() {

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
        WebElement leaveBtnLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']")));
        leaveBtnLocator.click();
    }


    @Test
    public void testLeavePage() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));



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
        WebElement leaveBtnLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']")));
        leaveBtnLocator.click();

        //start date
        WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input[@placeholder='yyyy-dd-mm']")
        ));

        // Select all and delete
        startDateInput.sendKeys(Keys.CONTROL + "a");
        startDateInput.sendKeys(Keys.DELETE);
        startDateInput.sendKeys("2025-04-04");


        //To Date
        WebElement toDateInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input[@placeholder='yyyy-dd-mm']")
        ));

        // Select all and delete
        toDateInput.sendKeys(Keys.CONTROL + "a");
        toDateInput.sendKeys(Keys.DELETE);
        toDateInput.sendKeys("2025-05-05");


        //Type Employee name
        try {

            WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Type for hints...']")));

            employeeNameField.clear();
            employeeNameField.sendKeys("a");


            Thread.sleep(4000); // Wait 4 seconds for dropdown

            employeeNameField.sendKeys(Keys.ARROW_DOWN);
            employeeNameField.sendKeys(Keys.ENTER);

            Thread.sleep(500);

        } catch (Exception e) {
            Assert.fail("Failed to select employee: " + e.getMessage());
        }


        //Leave Type DropDown menu
        WebElement leaveTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(.,'Leave Type')]/following::div[contains(@class,'oxd-select-text-input')]")
        ));
        leaveTypeDropdown.click();

        // Wait for the options to appear and select one
        String optionToSelect = "CAN - Bereavement"; // Change this to your desired option
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']/span[contains(.,'%s')]", optionToSelect))
        ));
        desiredOption.click();

        //Sub Unit DropDown menu
        WebElement subUnitDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Sub Unit')]/following::div[contains(@class,'oxd-select-text-input')]")
        ));
        subUnitDropdown.click();

        // Wait for the options to appear and select one
        String optionsToSelect = "Administration"; // Change this to your desired option
        WebElement desiredOptions = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']/span[text()='%s']", optionsToSelect))
        ));
        desiredOptions.click();


        //Click Search
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit' and .=' Search ']")));
        searchButton.click();


    }

}

