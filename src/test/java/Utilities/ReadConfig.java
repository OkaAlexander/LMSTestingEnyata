package Utilities;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    public ReadConfig(){
        File src=new File("./configuration/config.properties");
        try{
            FileInputStream _file=new FileInputStream(src);
            properties=new Properties();
            properties.load(_file);
        }catch(Exception e){System.out.println("sorry file not uploaded"+e.getMessage());}

    }
    public String getBaseUrl(){
        String baseUrl=properties.getProperty("baseUrl");
        return baseUrl;
    }
    public String lunchBrowser(){
        String browser=properties.getProperty("driver");
        return browser;
    }
    public String getValidEmail(){
       String email = properties.getProperty("validEmail");
       return email;
    }
    public String getInvalidEmail(){
        String invalidEmail=properties.getProperty("invalidEmail");
        return invalidEmail;
    }
    public String getValidPassword(){
        String password=properties.getProperty("validPassword");
        return password;
    }
    public String getInvalidPassword(){
        String invalidPassword=properties.getProperty("invalidPassword");
        return invalidPassword;
    }
    public static String captureScreenShort(WebDriver driver,String testName){
        File srcScreenShort=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenShortPath=System.getProperty("user.dir")+"\\TestReport\\ExtentReports\\images.png";
        try {
            FileHandler.copy(srcScreenShort,new File(destinationScreenShortPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationScreenShortPath;
    }

}
