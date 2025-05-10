package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BaseTest {
    WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
        public void setup(){
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--disable-popup");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
        driver.quit();}
    }
}
