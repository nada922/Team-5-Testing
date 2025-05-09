package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import java.time.Duration;

public class LeaveRequestPage {
    WebDriver driver;
    WebDriverWait wait;

    public LeaveRequestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setStartDate(String date) {
        WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input[@placeholder='yyyy-dd-mm']")));
        startDateInput.sendKeys(Keys.CONTROL + "a");
        startDateInput.sendKeys(Keys.DELETE);
        startDateInput.sendKeys(date);
    }

    public void setToDate(String date) {
        WebElement toDateInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input[@placeholder='yyyy-dd-mm']")));
        toDateInput.sendKeys(Keys.CONTROL + "a");
        toDateInput.sendKeys(Keys.DELETE);
        toDateInput.sendKeys(date);
    }

    public void selectEmployee(String partialName) {
        try {
            WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Type for hints...']")));
            employeeNameField.clear();
            employeeNameField.sendKeys(partialName);

            Thread.sleep(4000);
            employeeNameField.sendKeys(Keys.ARROW_DOWN);
            employeeNameField.sendKeys(Keys.ENTER);
            Thread.sleep(500);
        } catch (Exception e) {
            //Assert.fail("Failed to select employee: " + e.getMessage());
        }
    }

    public void selectLeaveType(String type) {
        WebElement leaveTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(.,'Leave Type')]/following::div[contains(@class,'oxd-select-text-input')]")));
        leaveTypeDropdown.click();

        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']/span[contains(.,'%s')]", type))));
        desiredOption.click();
    }

    public void selectSubUnit(String subUnit) {
        WebElement subUnitDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Sub Unit')]/following::div[contains(@class,'oxd-select-text-input')]")));
        subUnitDropdown.click();

        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']/span[text()='%s']", subUnit))));
        desiredOption.click();
    }

    public void clickSearch() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit' and .=' Search ']")));
        searchButton.click();
    }
}
