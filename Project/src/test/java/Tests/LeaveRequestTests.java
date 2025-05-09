package Tests;
import Tests.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeaveRequestPage;
import pages.LoginPage;

public class LeaveRequestTests extends BaseTest {
    LeaveRequestPage leavePage;
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void testLeavePage() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        leavePage = new LeaveRequestPage(driver);

        loginPage.login("Admin", "admin123");

        homePage.clickLeaveModule();
        leavePage.setStartDate("2025-04-04");
        leavePage.setToDate("2025-05-05");
        leavePage.selectEmployee("a");
        leavePage.selectLeaveType("CAN - Bereavement");
        leavePage.selectSubUnit("Administration");
        leavePage.clickSearch();
    }
}
