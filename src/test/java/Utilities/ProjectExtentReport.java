package Utilities;

import BaseClas.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ProjectExtentReport extends BaseClass {
    public static ExtentReports generateExtentReport(){
        ExtentReports extentReport=new ExtentReports();
        File extentReportFile=new File(System.getProperty("user.dir")+"\\TestReport\\ExtentReports\\extentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("LMS test Automation");
        sparkReporter.config().setDocumentTitle("LMS Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
        extentReport.attachReporter(sparkReporter);
        extentReport.setSystemInfo("Application URL", readConfig.getBaseUrl());
        extentReport.setSystemInfo("Browser", readConfig.lunchBrowser());
        extentReport.setSystemInfo("Windows",System.getProperty("user.name"));
        extentReport.setSystemInfo("Tester",System.getProperty("os.name"));
        extentReport.setSystemInfo("Java version",System.getProperty("java.version"));

        return extentReport;

    }
}
