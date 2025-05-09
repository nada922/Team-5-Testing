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
      By manageReviewsMenu = By.xpath("//span[text()='Manage Reviews ']");
      By manageReviews = By.xpath("//a[text()='Manage Reviews']");
      By addButton = By.xpath("//button[contains(., 'Add')]");
      By employeeNameField = By.cssSelector("input[placeholder='Type for hints...']");
      By startDateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
      By endDateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
      By dueDateInput = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[3]");
      By supervisorField = By.xpath("(//input[@placeholder='Type for hints...'])[2]");
      By dropdownOptions = By.cssSelector(".oxd-autocomplete-option");

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addBtn);
        addBtn.click();
    }

    public void enterEmployeeName(String partialName) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(employeeNameField));
        field.clear();
        field.sendKeys(partialName);

        // Wait for dropdown to appear and select first option
        try {
            // Wait for at least one option to appear
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dropdownOptions, 0));

            // Get all visible options
            java.util.List<WebElement> options = driver.findElements(dropdownOptions);

            if (!options.isEmpty()) {
                // Scroll to the first option and click it
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        options.get(0)
                );
                options.get(0).click();

                // Verify selection was made
                wait.until(d -> !field.getAttribute("value").isEmpty());
            } else {
                throw new RuntimeException("No options found in dropdown");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to select employee: " + e.getMessage());
        }
    }

    public void enterDates(String startDate, String endDate, String dueDate) {
        enterDate(startDateInput, startDate);
        enterDate(endDateInput, endDate);
        enterDate(dueDateInput, dueDate);
    }

    public void enterSupervisor(String partialName) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(supervisorField));
        field.clear();
        field.sendKeys(partialName);
        waitForDropdownAndSelectFirstOption(field);
    }

    public String getSupervisorValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(supervisorField)).getAttribute("value");
    }

    private void enterDate(By locator, String date) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
        field.clear();
        field.sendKeys(date);
    }

    private void waitForDropdownAndSelectFirstOption(WebElement field) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(d -> {
                        field.sendKeys(Keys.ARROW_DOWN);
                        return !driver.findElements(By.cssSelector(".oxd-autocomplete-option")).isEmpty();
                    });
            field.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new RuntimeException("Failed to select dropdown option: " + e.getMessage());
        }
    }
}