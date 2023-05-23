package BaseClas;

import PageObjects.AddCourseWithoutCertificatePage;
import PageObjects.LoginPage;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseClass {

    public static WebDriver driver;
   public static SoftAssert softAssert=new SoftAssert();
    public static ReadConfig readConfig=new ReadConfig();
    public static AddCourseWithoutCertificatePage addCourseWithoutCert;
    public static LoginPage loginPage;
    @BeforeTest
    public static void setUp(){
        String browser = readConfig.lunchBrowser();

        switch(browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("disable-popup-blocking");
                driver=new ChromeDriver(options);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                //firefoxOptions.addArguments("--remote-allow-origins=*");
                //firefoxOptions.addArguments("disable-popup-blocking");
                driver=new FirefoxDriver(firefoxOptions);
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions internetExplorerOptions=new InternetExplorerOptions();
                internetExplorerOptions.addCommandSwitches("--remote-allow-origins=*");
                driver=new InternetExplorerDriver(internetExplorerOptions);
                break;

            default:
                System.out.println("Invalid browser specified");
                break;
        }
        driver.get(readConfig.getBaseUrl());
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
       addCourseWithoutCert=new AddCourseWithoutCertificatePage(driver);

    }
    @AfterClass
    public static void tearDown(){
//        driver.quit();
//        softAssert.assertAll();

    }
}
