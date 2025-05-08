package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PerformancePage;

public class PerformanceTests extends BaseTest {
    PerformancePage performancePage;
    LoginPage loginPage;

    @Test
    public void addReview() throws InterruptedException {
        // Initialize pages
        loginPage = new LoginPage(driver);
        performancePage = new PerformancePage(driver);


        loginPage.login("Admin", "admin123");

        // Performance test
        performancePage.navigateToPerformance();
        Assert.assertEquals(performancePage.getHeaderText(), "Performance");

        performancePage.navigateToManageReviews();
        performancePage.clickAddButton();

        // Fill review form
        performancePage.enterEmployeeName("a");
        performancePage.enterDates("2025-04-23", "2025-30-04", "2025-01-05");
        performancePage.enterSupervisor("a");

        // Assertions
        String selectedValue = performancePage.getSupervisorValue();
        Assert.assertNotEquals(selectedValue, "", "Supervisor was not selected");
        Assert.assertNotEquals(selectedValue, "a", "Supervisor was not properly selected");
    }
}