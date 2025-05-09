package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



public class LoginTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;


    @Test
    public void LoginTest(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        //Successful Login
        loginPage.login("Admin", "admin123");



    }

    @Test
    public void invalidLogin(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        // Login With invalid credentials
        loginPage.login("Amin", "admin13");


//        Assert.assertTrue(loginPage.getLoginHeaderText().contains("Login"));

    }

}
