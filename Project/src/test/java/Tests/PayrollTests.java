package Tests;

import pages.LoginPage;
import pages.PayrollPage;  // Ensure this import matches your package
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class PayrollTests extends BaseTest {

    @Test
    public void testCase5_requiredFieldsValidation() {
        LoginPage loginPage= new LoginPage(driver);
        PayrollPage payrollPage = new PayrollPage(driver);

        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLoginBtn(driver);


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Employee List']"))).click();

        WebElement employee = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[@role='row'])[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", employee);
        wait.until(ExpectedConditions.elementToBeClickable(employee)).click();

        // Step 5: Go to Salary tab
        WebElement salaryTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Salary']")));
        salaryTab.click();

        // Step 6: Click Add
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()=' Add ']"))).click();

               wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()=' Save ']"))).click();

        String error = payrollPage.getErrorMessage();
        assert error.contains("Required") : "Validation failed: 'Required' message not found.";
    }

}

//