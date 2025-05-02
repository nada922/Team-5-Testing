package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformancePage {

    //Webdriver
    WebDriver PerformancePage;

    //Locators
    By headerLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");



    //constructors

    public PerformancePage(WebDriver driver){
        PerformancePage = driver;
    }

    //actions
    public String gePerformacePageHeaderText(){
        return PerformancePage.findElement(headerLocator).getText();
    }


}
