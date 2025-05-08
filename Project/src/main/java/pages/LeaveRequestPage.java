package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveRequestPage {

    //WebDriver
    WebDriver leaveRequestPageDriver;
    //Locators
    By LeaveRequestHeaderLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    //    By statusLocator = By.xpath("(//div[contains(@class, 'oxd-select-text-input')])[1]");
//    By leaveTypeLocator = By.xpath("(//div[contains(@class, 'oxd-select-text-input')])[2]");
//    By subUnitLocator = By.xpath("(//div[contains(@class, 'oxd-select-text-input')])[3]");
    //constructor
    public LeaveRequestPage(WebDriver driver){
        leaveRequestPageDriver = driver;
    }
    //Actions
    public String getLeaveHeaderText(){
        return leaveRequestPageDriver.findElement(LeaveRequestHeaderLocator).getText();
    }



}
