package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
public class TestBase {
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public ExtentHtmlReporter extentHtmlReporter;
    @BeforeTest
    public void setUpTest(){
        extentReports = new ExtentReports();// ExtentReports objesi üretelim
        String filePath = System.getProperty("user.dir") + "/reports/myprojectreport.html";// rapor için adresi belirleyelim.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);//extenthtmlreporter objesi üretelim
        extentReports.attachReporter(extentHtmlReporter);//extentHtmlReporter objesini extentReports objesinin içine ekleyelim
        //Rapor ile ilgili bilgileri artık buraya ekleyebiliriz
        extentReports.setSystemInfo("Environment", "Environment İsim");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Engineer", "Kemal Ozden");
        extentHtmlReporter.config().setDocumentTitle("FHC Trip Reports");
        extentHtmlReporter.config().setReportName("FHC Trip Automation Reports");
    }
    @AfterTest
    public void tearDownTest(){
        extentReports.flush();
    }
    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {//When test case fails, then take the screenshot and attached the report
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());//getScreenshot is coming from ReusableMethods
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
    }
}