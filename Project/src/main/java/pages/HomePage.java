package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By headerLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private final By performanceLocator = By.xpath("//span[text()='Performance']/ancestor::a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHomepageHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator)).getText();
    }

    public PerformancePage navigateToPerformance() {
        wait.until(ExpectedConditions.elementToBeClickable(performanceLocator)).click();
        return new PerformancePage(driver);
    }
}