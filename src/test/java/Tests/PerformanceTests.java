package Tests;

import org.testng.annotations.Test;
import pages.PerformancePage;

public class PerformanceTests extends BaseTest{

    PerformancePage performancePage;

    @Test
    public void addReview(){
        performancePage = new PerformancePage(driver);

    }

}
