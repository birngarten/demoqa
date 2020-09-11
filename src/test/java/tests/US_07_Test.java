package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_07_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class US_07_Test extends TestBase {

    US_07_Page us07Page=new US_07_Page();

    @BeforeMethod
    public void setup2() { //testbase de setup isimli method var
        us01Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    @Test
    public void TC_028() {
        //Elements altindaki Upload and Download sayfasinin erisilebilir oldugunu dogrulayin
        Assert.assertTrue(us07Page.uploadDownloadLink.isEnabled());
    }

    @Test
    public void TC_029() {
    //Sayfadaki Download butonuna tiklanabilir oldugunu ve tiklandiginda ornek bir dosyanin indirildigini dogrulayin
//        us01Page.elementsCard.click();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us07Page.uploadDownloadLink.click();

        Assert.assertTrue(us07Page.downloadButton.isEnabled());

        us07Page.downloadButton.click();
        String filePath="C:\\Users\\pinar\\Downloads\\sampleFile.jpeg";
        ReusableMethods.waitFor(1);
        boolean isDownload= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownload);
    }

    @Test
    public void TC_30() {
        //Sayfadaki Dosya Sec Butonu tiklanabilir oldugunu ve dosya hatasiz bir sekilde ornek bir dosyanin yuklenebildini dogrulayin
//        us01Page.elementsCard.click();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us07Page.uploadDownloadLink.click();

        String dosyaYukle="C:\\Users\\pinar\\Downloads\\sampleFile.jpeg";
        us07Page.chooseFileButton.sendKeys(dosyaYukle);
        Assert.assertTrue(us07Page.dosyaYukleTexti.isDisplayed());
    }
}
