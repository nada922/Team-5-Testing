package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeaveRequestPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

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
        WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input[@placeholder='yyyy-dd-mm']")));
        startDateInput.clear();
        startDateInput.sendKeys("2025-04-04");


        // End Date
        driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input[@placeholder='yyyy-dd-mm']"))
                .sendKeys("2025-05-05");
//        WebElement toDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input[@placeholder='yyyy-dd-mm']")));
//        toDateInput.clear();
//        toDateInput.sendKeys("2025-05-05");

        // Enter Due Date
//        driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input[@placeholder='yyyy-dd-mm']"))
//                .sendKeys("2025-01-05");
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

//        try {
//
//            WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("(//div[contains(@class, 'oxd-select-text-input')])[3]")));
//
//            employeeNameField.clear();
//            employeeNameField.getDomProperty("Administration");
//
//
//            Thread.sleep(4000); // Wait 4 seconds for dropdown
//
//            employeeNameField.sendKeys(Keys.ARROW_DOWN);
//            employeeNameField.sendKeys(Keys.ENTER);
//
//            Thread.sleep(500);
//
//        } catch (Exception e) {
//            Assert.fail("Failed to select employee: " + e.getMessage());
//        }


        // === 2. Leave Type Dropdown ===
//        WebElement leaveTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//label[contains(.,'Leave Type')]/following::div[contains(@class,'oxd-select-text-input')][1]")));
//        leaveTypeDropdown.click();
//
//        // Select the CAN-Bereavement option with better waiting
//        WebElement sickLeaveOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class, 'oxd-select-text-input') and contains(., 'Bereavement')]")));
//        sickLeaveOption.click();

        // 1. Click the Leave Type dropdown using JavaScript (more reliable than regular click)
        WebElement leaveDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[contains(.,'Leave Type')]/following::div[contains(@class,'oxd-select-text-input')]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", leaveDropdown);

// 2. Select the Bereavement option (case-insensitive, flexible spacing)
        WebElement bereavementOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option']//span[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'bereavement')]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", bereavementOption);

        // === 3. Sub Unit Dropdown ===
//        WebElement subUnitDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//div[contains(@class, 'oxd-select-text-input')])[3]")));
//        subUnitDropdown.click();
//
//        WebElement engineeringOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@role='option']//span[text()='Engineering']"))); // Change as needed
//        engineeringOption.click();

        WebElement subUnitDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Sub Unit')]/following::div[contains(@class,'oxd-select-text-input')][1]")));
        subUnitDropdown.click();

        // Select the "Engineering" option
        WebElement engineeringOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'oxd-select-text-input') and contains(., 'Administration')]")));
        engineeringOption.click();

        // Optional: Click Search
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit' and .=' Search ']")));
        searchButton.click();


    }

}

