package PageObjects;

import AbstratePages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends AbstractPage {
    protected AdminPage(WebDriver driver) {
        super(driver);
    }

    private final By loginUser=By.cssSelector(".chakra-text.css-r5firy");
    //private final By coursesBtn=By.xpath("//p[@class='chakra-text css-7n116r']");
    private final By coursesBtn=By.cssSelector("p.chakra-text.css-7n116r");
    private final By addCourseBtn=By.cssSelector(".chakra-button.css-1wd62wy");

    private final By getStartedWithCreatingCourseHeader=By.xpath("//h2[normalize-space()='Get started with creating a course']");

    private final By adminOverView=By.cssSelector(".chakra-heading.css-1sa2osv");
    private final By crateCourseWithOutCert=By.xpath("//button[@data-testid='create-without-quiz']");
    public WebElement waitAndFindElement(By locator){
        return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getLoginUserName(){
       return waitAndFindElement(loginUser).getText();
    }
    public String getCurrentUrl(){
       return driver.getCurrentUrl();

    }

    public void navigateToAdminDashboard(){
          driver.navigate().to("https://tutor.enyata.com/dashboard/home");
    }
    public  boolean isPageNotNavigated(WebDriver driver, String initialUrl) {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(initialUrl);
    }
    public boolean isPageNavigated(WebDriver driver,String initialUrl){
        String currentUrl= driver.getCurrentUrl();
        return !currentUrl.equals(initialUrl);
    }

    public void clickCourseBtn(){
     WebElement tab=  waitAndFindElement(coursesBtn);
     tab.click();
     driver.navigate().to("https://tutor.enyata.com/dashboard/courses");
    }
    public void clickAddCourse(){
        driver.findElement(addCourseBtn).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
    public boolean isGetStartedWithCreatingCourseDisplay(){
        return waitAndFindElement(getStartedWithCreatingCourseHeader).isDisplayed();
    }
    public void print(){
        System.out.println("this is admin page");
    }
    public AddCourseWithoutCertificatePage clickCreateCourse(){
        driver.findElement(crateCourseWithOutCert).click();
        return new AddCourseWithoutCertificatePage(driver);
    }
}
