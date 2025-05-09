package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //webdriver
    WebDriver homePageDriver;
    WebDriverWait wait;

    //Locators
    By headerLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    By performancelocator = By.xpath("//span[text()='Performance']/ancestor::a");


    //constructors

    public HomePage(WebDriver driver){

        homePageDriver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //actions
    public String getHomepageHeaderText(){
        return homePageDriver.findElement(headerLocator).getText();
    }

    public PerformancePage clickPerformance(WebDriver driver){
        homePageDriver.findElement(performancelocator).click();
        return new PerformancePage(driver);
    }

    public void clickLeaveModule() {
        WebElement leaveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']")));
        leaveBtn.click();
    }

}
