package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //webdriver
    WebDriver homePageDriver;

    //Locators
    By headerLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    By performancelocator = By.xpath("//span[text()='Performance']/ancestor::a");


    //constructors

    public HomePage(WebDriver driver){
        homePageDriver = driver;
    }
    //actions
    public String getHomepageHeaderText(){
        return homePageDriver.findElement(headerLocator).getText();
    }

    public PerformancePage clickPerformance(WebDriver driver){
        homePageDriver.findElement(performancelocator).click();
        return new PerformancePage(driver);
    }

}
