package TestCases;

import PageObjects.AddCourseWithoutCertificatePage;
import PageObjects.LoginPage;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import Listeners.ProjectListeners;

@Listeners(ProjectListeners.class)
public class AdminTest extends LoginTest {

    @Test(testName = "Verify add a course",priority = 1)
    public void TC_007_verifyAddCourse() {
        TC_001_validLoginDetails();
        adminPage.clickCourseBtn();
        assertEquals(adminPage.getPageTitle(), "Courses");
        adminPage.clickAddCourse();
        assertTrue(adminPage.isGetStartedWithCreatingCourseDisplay(), "Get started with creating a course page not display");


    }
}
