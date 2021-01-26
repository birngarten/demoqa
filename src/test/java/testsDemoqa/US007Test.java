package testsDemoqa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.DemoqaPage;
import pagesDemoqa.UploadDynamicPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;

public class US007Test {
    UploadDynamicPage uploadDynamicPage = new UploadDynamicPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc028(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        Assert.assertTrue(uploadDynamicPage.uploadAndDownload.isEnabled());
    }
    @Test
    public void tc029(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        uploadDynamicPage.uploadAndDownload.click();
        uploadDynamicPage.downloadButton.click();
        ReusableMethods.waitFor(2);
        String filePath = "C:/Users/samet/Downloads/sampleFile.jpeg";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
    @Test
    public void tc030(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(1);
        uploadDynamicPage.uploadAndDownload.click();
        Assert.assertTrue(uploadDynamicPage.uploadFile.isEnabled());
        String filePath = "C:\\Users\\samet\\Downloads\\sampleFile.jpeg";
        //dosya yukleme yapamadik
        uploadDynamicPage.uploadFile.sendKeys(filePath);
        Assert.assertTrue(uploadDynamicPage.uploadedFilePath.isDisplayed());
    }
    @Test
    public void tc031(){
//        DemoqaPage demoqaPage = new DemoqaPage();
//        demoqaPage.elementsCard.click();
//        uploadDynamicPage.uploadAndDownload.click();
//        //Assert.assertTrue(uploadDynamicPage.uploadAndDownload.isEnabled());
//        ReusableMethods.waitFor(2);
//        //uploadDynamicPage.uploadFile.click();
//        ReusableMethods.waitFor(1);
//        String filePath2 = "C:\\Users\\sam\\Downloads\\sampleFile.jpeg";
//        uploadDynamicPage.uploadAndDownload.sendKeys(filePath2);
    }


}