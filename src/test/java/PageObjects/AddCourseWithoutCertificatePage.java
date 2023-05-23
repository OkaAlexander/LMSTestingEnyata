package PageObjects;

import AbstratePages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddCourseWithoutCertificatePage extends AdminPage {
    public AddCourseWithoutCertificatePage(WebDriver driver) {
        super(driver);
    }
    private final By step1=By.cssSelector(".chakra-heading.css-1sa2osv");
    private final  By courseTitle=By.xpath("//input[@id='field-5']");
    private final By courseType=By.xpath("//select[@id='field-6']");
    private final By courseDescription=By.cssSelector("textarea[placeholder='Enter description']");
    private final By uploadCourseCoverPage=By.xpath("//span[@class='css-n2hqlu']");
    private final By benfit1=By.cssSelector("input[id='field-8']");
    private final By submitSept1=By.cssSelector("button[type='submit']");


    public boolean isStepOneFormsDisplay(){
       return driver.findElement(step1).isDisplayed();
    }
    public void setCourseTitle(String _courseTitle){
       waitAndFindElement (courseTitle).clear();
        driver.findElement(courseTitle).sendKeys(_courseTitle);
    }
    public void setCourseType( String visibleText){
        WebElement dropdownElement = waitAndFindElement(courseType);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
    public void setCourseDescription(String _courseDescription){
        waitAndFindElement(courseDescription).sendKeys(_courseDescription);
    }
    public void setUploadCourseCoverPage(){
        WebElement fileInput = waitAndFindElement(uploadCourseCoverPage);
        String filePath = System.getProperty("user.dir");
         uploadFile(fileInput, filePath);
    }
    public  void uploadFile(WebElement fileInput, String filePath) {
        // Make sure the file input element is displayed and enabled
        if (fileInput.isDisplayed() && fileInput.isEnabled()) {
            fileInput.click();
            WebElement fileChooser = findFileChooserElement();
            fileChooser.sendKeys(filePath+"\\files\\seleniumwithjavacoverpage.jpg");
        } else {
            System.out.println("File input element is not available or enabled.");
        }
    }
    public  WebElement findFileChooserElement() {
        return driver.findElement(By.cssSelector("input[type='file']"));
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }
    public void setBenefit1(String _benefit1){
        waitAndFindElement(benfit1).sendKeys(_benefit1);
    }
    public AddLessonsPage saveAndContinue(){
        waitAndFindElement(submitSept1).click();
        return new AddLessonsPage(driver);
    }
    public void print(){
        System.out.println("hello worldW");
    }


}
