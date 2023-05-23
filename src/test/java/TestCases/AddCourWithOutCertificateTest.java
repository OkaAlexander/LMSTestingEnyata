package TestCases;

import AbstratePages.AbstractPage;
import BaseClas.BaseClass;
import PageObjects.AddLessonsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import TestCases.AdminTest;
import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import Listeners.ProjectListeners;

@Listeners(ProjectListeners.class)
public class AddCourWithOutCertificateTest extends AdminTest {
    AddLessonsPage addLessonsPage;
    @Test(testName = "Verify create a course without Certificate")
    public void TC_008_verifyCreateCourseWithoutCert() throws InterruptedException {
        TC_007_verifyAddCourse();
        adminPage.clickCreateCourse();
        //addCourseWithoutCert.isStepOneFormsDisplay();
        addCourseWithoutCert.print();
        addCourseWithoutCert.setCourseTitle("Selenium  with Java");
        addCourseWithoutCert.setCourseType("Free");
        addCourseWithoutCert.setCourseDescription("Selenium Java is a powerful and widely used framework " +
                "for automating web browser interactions and " +
                "performing automated testing using the Java programming language.");
        addCourseWithoutCert.scrollDown();
        //String path=System.getProperty("C:\\Users\\alexa\\OneDrive\\Desktop\\QA\\Enyat_Assignment\\seleniumwithjavacoverpage.jpg");
        addCourseWithoutCert.setUploadCourseCoverPage();
        addCourseWithoutCert.setBenefit1("Free laptops and reading materials");
        addLessonsPage=addCourseWithoutCert.saveAndContinue();
        assertTrue(addLessonsPage.isAddLessonsPageDisplay(),"add lessons page not display");

    }

}
