package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import pages.UploadDynamicPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;

public class US007 {
    UploadDynamicPage uploadDynamicPage = new UploadDynamicPage();

    @BeforeTest
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
        String filePath = "C:\\Users\\sam\\Downloads\\sampleFile.jpeg";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
    @Test
    public void tc030(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        uploadDynamicPage.uploadAndDownload.click();
        //dosya yukleme yapamadik
    }
    @Test
    public void tc031(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        Assert.assertTrue(uploadDynamicPage.uploadAndDownload.isEnabled());
    }


}