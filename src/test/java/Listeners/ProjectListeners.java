package Listeners;

import Utilities.ProjectExtentReport;
import Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ProjectListeners implements ITestListener {
    ExtentReports extentReports;
    ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {
        extentReports = ProjectExtentReport.generateExtentReport();


    }
    @Override
    public void onTestStart(ITestResult result) {
        extentTest=extentReports.createTest(result.getName());
        extentTest.log(Status.INFO,result.getName()+" "+"started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,result.getName()+" "+"test successfully executed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver= null;
        extentTest.log(Status.FAIL,result.getName()+" "+"test failed");

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        String destinationScreenShortPath= ReadConfig.captureScreenShort(driver,result.getName());
        extentTest.addScreenCaptureFromPath(destinationScreenShortPath);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL,result.getName()+" "+"test got failed");
        System.out.println(result.getName()+" "+"has fail"+" "+"reason is: "+result.getThrowable());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP,result.getName()+" "+"got skipped");
       // System.out.println(result.getName()+" "+"has skipped"+" "+"reason is: "+result.getThrowable());

    }

    //C:\Users\alexa\IdeaProjects\HybridFrameWorkTestNG\TestReport\ExtentReports

    @Override
    public void onFinish(ITestContext context) {
        //this will write to  report file
        extentReports.flush();
        //automatically open the extent report
        File extentReport=new File(System.getProperty("user.dir")+"\\TestReport\\ExtentReports\\extentReport.html");
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println("project test has finish executing!");

    }
}
