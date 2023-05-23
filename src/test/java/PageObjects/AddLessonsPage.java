package PageObjects;

import AbstratePages.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddLessonsPage extends AddCourseWithoutCertificatePage {
    protected AddLessonsPage(WebDriver driver) {
        super(driver);
    }
    private final By addLessonsPage=By.cssSelector(".chakra-text.css-180s7jm");
    private final By topic=By.cssSelector("input[id='field-6']");
    private final By lesson1=By.cssSelector("input[id='field-7']");
    private final By browseForDocs=By.xpath("//span[normalize-space()='browse']");
                                                         //input[@name='content_url']
    private final By saveTopic=By.xpath("//*[name()='path' and contains(@d,'M15.5773 2')]");
    private final By confirmSavePopUp=By.xpath("//button[normalize-space()='Save Content']");
    private final By addTopic=By.cssSelector("p[class='chakra-text css-1vg6q84']");
    private final By continueBtn=By.xpath("(//button[normalize-space()='Continue'])[1]");
    private final By continueFromCourseInfo=By.xpath("//button[normalize-space()='Continue']");
    private final By badge=By.xpath("//div[@class=' css-ackcql']");
    private final By saveAndCont=By.xpath("//button[normalize-space()='Save & Continue']");
    private final By closeBtn=By.xpath("//button[normalize-space()='Close']");
    private final By publishBtn=By.xpath("//button[normalize-space()='Publish']");
    private final By finalPublishBtn=By.xpath("(//button[@class='chakra-button css-4sgot3'])[1]");
    private final By allCourse=By.xpath("//h2[normalize-space()='All Courses']");





    public boolean isAddLessonsPageDisplay(){
      return  waitAndFindElement (addLessonsPage).isDisplayed();
    }
    public void setTopic(String _topic){
        waitAndFindElement(topic).sendKeys(_topic);
    }
    public void setLesson1(String _lesson1){
        waitAndFindElement(lesson1).sendKeys(_lesson1);
    }
    public void setUploadCourseCoverPage(){
        WebElement fileInput = waitAndFindElement(browseForDocs);
        String filePath = System.getProperty("user.dir");
        uploadFile(fileInput, filePath);
    }
    public  void uploadFile(WebElement fileInput, String filePath) {
        // Make sure the file input element is displayed and enabled
        if (fileInput.isDisplayed() && fileInput.isEnabled()) {
            fileInput.click();
            WebElement fileChooser = findFileChooserElement();
            fileChooser.sendKeys(filePath+"\\files\\selenium_tutorial.pdf");
        } else {
            System.out.println("File input element is not available or enabled.");
        }
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }
    public  WebElement findFileChooserElement() {
        return driver.findElement(By.cssSelector("input[type='file']"));
    }
    public WebElement clickSaveTopic() {
        WebElement x = waitAndFindElement(saveTopic);
        return x;
    }
    public void clickOkayOnPopUp(){
        //wait.until(ExpectedConditions.alertIsPresent());
        waitAndFindElement(confirmSavePopUp).click();
    }
    public void clickAddTopics(){
        waitAndFindElement(addTopic).click();
    }
    public void clickContinue(){
        waitAndFindElement(continueBtn).click();
    }
    public void clickContinueFromCourseDisplay(){
        waitAndFindElement(continueFromCourseInfo).click();
    }
    public void selectBadge(){
        WebElement dropdownElement = waitAndFindElement(badge);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(0);

    }
    public void clickSaveAndContinue(){
        waitAndFindElement(saveAndCont).click();
    }
    public void clickCLose(){
        waitAndFindElement(closeBtn).click();
    }
    public void clickPublish(){
        waitAndFindElement(publishBtn).click();
    }
    public void clickFinalPublish(){
        waitAndFindElement(finalPublishBtn).click();
    }
    public boolean isAllCourseDisplay(){
      return   waitAndFindElement(allCourse).isDisplayed();
    }

    public void Test(){
        System.out.println("yes men...");
    }
}
