package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PerformancePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By headerLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    By performanceMenuLocator = By.xpath("//span[text()='Performance']/ancestor::a");
    By manageReviewsMenu = By.xpath("//span[text()='Manage Reviews ']");
    By manageReviews = By.xpath("//a[text()='Manage Reviews']");
    By addButton = By.xpath("//button[contains(., 'Add')]");
    By employeeNameField = By.cssSelector("input[placeholder='Type for hints...']");
    By startDateInput = By.xpath("//input[@placeholder='yyyy-dd-mm']");
    By endDateInput = By.xpath("//label[contains(text(),'Review Period End Date')]/following::input[contains(@class,'oxd-input')][1]");
    By dueDateInput = By.xpath("//label[contains(text(),'Due Date')]/following::input[contains(@class,'oxd-input')][1]");
    By supervisorField = By.xpath("//label[contains(.,'Supervisor Reviewer')]/following::input[@placeholder='Type for hints...'][1]");

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPerformance() {
        wait.until(ExpectedConditions.elementToBeClickable(performanceMenuLocator)).click();
    }

    public String getHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator)).getText();
    }

    public void navigateToManageReviews() {
        wait.until(ExpectedConditions.elementToBeClickable(manageReviewsMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(manageReviews)).click();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-toast-close-container")));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);
        addBtn.click();
    }

    public void enterEmployeeName(String partialName) throws InterruptedException {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(employeeNameField));
        field.clear();
        field.sendKeys(partialName);
        Thread.sleep(4000); // Consider replacing with proper wait
        field.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(500);
    }

    public void enterDates(String startDate, String endDate, String dueDate) {
        driver.findElement(startDateInput).sendKeys(startDate);
        driver.findElement(endDateInput).sendKeys(endDate);
        driver.findElement(dueDateInput).sendKeys(dueDate);
    }

    public void enterSupervisor(String partialName) throws InterruptedException {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(supervisorField));
        field.clear();
        field.sendKeys(partialName);
        Thread.sleep(5000); // Consider replacing with proper wait
        field.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public String getSupervisorValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(supervisorField)).getAttribute("value");
    }
}