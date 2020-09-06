package tests;

import org.openqa.selenium.By;
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
import java.util.ArrayList;
import java.util.List;

public class US007 {
    UploadDynamicPage demoqaDynamicPage = new UploadDynamicPage();

    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc028(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        Assert.assertTrue(demoqaDynamicPage.uploadAndDownload.isEnabled());
    }
    @Test
    public void tc029(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        demoqaDynamicPage.uploadAndDownload.click();
        demoqaDynamicPage.downloadButton.click();
        ReusableMethods.waitFor(2);
        String filePath = "C:\\Users\\sam\\Downloads\\sampleFile.jpeg";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
    @Test
    public void tc030(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        demoqaDynamicPage.uploadAndDownload.click();
        //dosya yukleme yapamadik
    }
    @Test
    public void tc031(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        Assert.assertTrue(demoqaDynamicPage.uploadAndDownload.isEnabled());
    }
    @Test
    public void tc032(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        demoqaDynamicPage.dynamicProperties.click();
        String idValue = demoqaDynamicPage.dynamicText.getAttribute("id");
        List<String> idValues = new ArrayList<>();
        for(int i=1;i<11;i++){
            Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
            demoqaPage.elementsCard.click();
            demoqaDynamicPage.dynamicProperties.click();
            String idValue2 = demoqaDynamicPage.dynamicText.getAttribute("id");
            if(!idValue.equals(idValue2)) {
                idValues.add(idValue2);
            }
            ReusableMethods.waitFor(2);
        }
        System.out.println(idValues);
        Assert.assertEquals(10,idValues.size());
    }
    @Test
    public void tc033(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        demoqaDynamicPage.dynamicProperties.click();
        Assert.assertTrue();
    }

}