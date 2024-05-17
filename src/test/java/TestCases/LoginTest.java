package TestCases;


import BaseClas.BaseClass;
import PageObjects.AdminPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import Listeners.ProjectListeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


@Listeners(ProjectListeners.class)
public class LoginTest extends BaseClass {
    AdminPage adminPage;
    @Test(testName = "Verify valid email and valid password",priority = 1)
    public void TC_001_validLoginDetails(){
        loginPage.setEmailField("argonoka@gmail.com"+ Keys.TAB);
        loginPage.setPasswordField("!@Password12345"+Keys.TAB);
        adminPage= loginPage.clickLogin();
        assertEquals(adminPage.getLoginUserName(),"Dennis","login failed");


    }
    @Test(testName = "Verify by   empty userName and empty password",priority = 2)
    public void TC_002_emptyEmailAndPasswordTextField(){
        loginPage.setEmailField(""+Keys.TAB);
        loginPage.setPasswordField(""+Keys.TAB);
        assertFalse(loginPage.isLoginBtnDisabled(),"login button message is enabled");
    }
    @Test(testName = "Verify by   empty userName and enter a valid  password",priority = 3)
    public void TC_003_verifyEmptyUserNameAndValidPassword(){
        loginPage.setEmailField(""+Keys.TAB);
        loginPage.setPasswordField("P@ssw0rd"+Keys.TAB);
        assertFalse(loginPage.isLoginBtnDisabled(),"login button message is enabled");
    }
    @Test(testName = "Verify by providing a valid  username and empty   password",priority = 4)
    public void TC_004_verifyValidUserNameAndEmptyPassword(){
        loginPage.setEmailField("Alexanderenyata@yopmail.com"+ Keys.TAB);
        loginPage.setPasswordField(""+Keys.TAB);
        assertFalse(loginPage.isLoginBtnDisabled(),"login button message is enabled");
    }
    @Test(testName = "Verify by providing invalid email address format and a valid password",priority = 5)
    public void TC_005_verifyInvalidEmailAddressFormatAndValidPassword(){
        loginPage.setEmailField("Alexanderenyata@yop"+Keys.TAB);
       assertEquals(loginPage.getInvalidEmailAddressErrorMessage(),"Email must be a valid email","error message for invalid email not display");
        loginPage.setPasswordField("P@ssw0rd"+Keys.TAB);
        assertFalse(loginPage.isLoginBtnDisabled(),"login button message is enabled");
    }
    @Test(testName = "Verify by providing invalid email address and invalid password",priority = 6)
    public void TC_006_verifyNonExistingUser() throws InterruptedException {
        loginPage.setEmailField("alexanderaffah@gmail.com"+ Keys.TAB);
        loginPage.setPasswordField("!@Password12345"+Keys.TAB);
        adminPage= loginPage.clickLogin();
        boolean isNotNavigated= adminPage.isPageNotNavigated(driver,"https://tutor.enyata.com/");
       assertTrue(isNotNavigated, " invalid user login successful");
    }
}
