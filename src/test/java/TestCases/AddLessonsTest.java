package TestCases;

import PageObjects.AddCourseWithoutCertificatePage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import Listeners.ProjectListeners;

@Listeners(ProjectListeners.class)
public class AddLessonsTest extends AddCourWithOutCertificateTest {

    @Test(testName = "verify add lessons to a course")
    public void TC_010_verifyAddLessonToCourse() throws InterruptedException {
        TC_008_verifyCreateCourseWithoutCert();
        addLessonsPage.Test();
        addLessonsPage.clickAddTopics();
        addLessonsPage.setTopic("Introduction to datatype");
        addLessonsPage.setLesson1("Datatype in java");
        addLessonsPage.scrollDown();
        addLessonsPage.setUploadCourseCoverPage();
        addLessonsPage.clickSaveTopic().click();
        addLessonsPage.clickOkayOnPopUp();
        addLessonsPage.clickContinue();
        addLessonsPage.clickContinueFromCourseDisplay();
        addLessonsPage.selectBadge();
        addLessonsPage.clickSaveAndContinue();
        addLessonsPage.clickCLose();
        addLessonsPage.clickPublish();
        addLessonsPage.clickFinalPublish();
        assertTrue(addLessonsPage.isAllCourseDisplay(),"Course added are not display");


    }
}
