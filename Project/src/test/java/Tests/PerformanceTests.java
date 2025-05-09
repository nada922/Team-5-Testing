package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PerformancePage;

public class PerformanceTests extends BaseTest {

    @Test
    public void addReview() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("Admin", "admin123");

        // Navigate to Performance
        PerformancePage performancePage = homePage.navigateToPerformance();
        Assert.assertEquals(performancePage.getHeaderText(), "Performance");

        // Create review
        performancePage.navigateToManageReviews();
        performancePage.clickAddButton();

        // Fill review form
        performancePage.enterEmployeeName("a");
        performancePage.enterDates("2025-04-23", "2025-30-04", "2025-01-05");
        performancePage.enterSupervisor("a");

        // Verify
        String selectedValue = performancePage.getSupervisorValue();
        Assert.assertNotEquals(selectedValue, "", "Supervisor was not selected");
        Assert.assertNotEquals(selectedValue, "a", "Supervisor was not properly selected");
    }
}