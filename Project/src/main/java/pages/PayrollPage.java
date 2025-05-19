package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayrollPage {

    WebDriver driver;

    public PayrollPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.tagName("button");
    private By payrollMenu = By.xpath("//span[text()='Payroll']");
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By salaryComponentField = By.xpath("//input[@placeholder='Type here']"); // adjust as needed
    private By amountField = By.xpath("//label[text()='Amount']/following::input[1]");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");
    private By errorMessage = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

    // Actions
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void openPayrollSection() {
        driver.findElement(payrollMenu).click();
    }

    public void clickAdd() {
        driver.findElement(addButton).click();
    }

    public void enterSalaryComponent(String name) {
        driver.findElement(salaryComponentField).sendKeys(name);
    }

    public void enterAmount(String amount) {
        driver.findElement(amountField).sendKeys(amount);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
