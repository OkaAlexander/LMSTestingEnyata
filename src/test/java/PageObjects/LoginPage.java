package PageObjects;

import AbstratePages.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By emailField=By.cssSelector("input[type='email']");
    private final By passwordField=By.cssSelector("input[type='password']");
    private final By loginBtn=By.cssSelector("button[type='submit']");
    private final By invalidEmailErrorMessage=By.cssSelector(".chakra-text.css-1idufjr");




    public void setEmailField(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    public AdminPage clickLogin(){
        driver.findElement(loginBtn).click();
        return new AdminPage(driver);
    }
    public boolean isLoginBtnDisabled(){
      return driver.findElement(loginBtn).isEnabled();

    }
    public String getInvalidEmailAddressErrorMessage(){
        return driver.findElement(invalidEmailErrorMessage).getText();
    }
    public String getInvalidUser(){
        Alert alert = (Alert) wait.until(ExpectedConditions.alertIsPresent());
        String errorMessage=alert.getText();
        return errorMessage;

    }

}
