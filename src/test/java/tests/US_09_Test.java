package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_09_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_09_Test extends TestBase {
    US_09_Page us09Page = new US_09_Page();

    @BeforeMethod
    public void setup1() {
        us09Page.formsMenuCard.click();
    }

    @Test
    public void TC_036() {
        //Forms altindaki Practice Form sayfasina ulasilabilirligi dogrulayin
        // ReusableMethods.waitFor(1);
        Assert.assertTrue(us09Page.practiceFormMenuLink.isEnabled());
    }

    @Test
    public void TC_037() {
        //Student Registration Formdaki  Name,  Gender, Date of Birth, Mobile bolumleri bos birakildiginda
        // Submit yapilamadigini dogrulayin

        us09Page.practiceFormMenuLink.click();
        //actions.click(us09Page.practiceFormMenuLink).perform();

        us09Page.userEmail.sendKeys("Can@gmail.com");
        us09Page.subject.sendKeys("deneme");
        // us09Page.hobiSpor.click();  //tiklamiyor
        actions.click(us09Page.hobiSpor).perform();
        String dosyaYukle = "C:\\Users\\pinar\\Downloads\\sampleFile.jpeg";
        us09Page.chooseFile.sendKeys(dosyaYukle);
        ReusableMethods.waitFor(2);
        us09Page.adress.sendKeys("deneme adresi");
        us09Page.state.sendKeys("NCR" + Keys.ENTER);
        us09Page.city.sendKeys("Delhi" + Keys.ENTER);
        us09Page.submitButton.click();

        actions.sendKeys(Keys.PAGE_UP).perform();
        String hataColor = us09Page.mobileNumber.getCssValue("border-color");
        ReusableMethods.waitFor(2);
        System.out.println(hataColor);
        String hexColor = Color.fromString(hataColor).asHex();
        System.out.println(hexColor);

        // Onemli not: Color islemleri yaparken chrome kullaniniz. Firefox Selenium Color classinda problem vermektedir.

    }
    @Test
    public void TC_038() {
        //Sadece gecerli bir mail ile submit yapilabilmelidirgini dogrulayin. Mailin gecerli olma sartlari TC003'te belirtildigi gibi olmalidir
        us09Page.practiceFormMenuLink.click();

        for (int i = 1; i < 5; i++) {
            us09Page.userEmail.sendKeys(ConfigReader.getProperty("invalid_email_" + i));
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(1);
            us09Page.submitButton.click();
            ReusableMethods.waitFor(1);
            String hataColor = us09Page.userEmail.getCssValue("border-color");
            System.out.println(hataColor);
            ReusableMethods.waitFor(2);
            String hexColor = Color.fromString(hataColor).asHex();
            System.out.println(hexColor);
            Assert.assertEquals(hexColor, "#dc3545");
            Driver.getDriver().navigate().refresh();
        }
        // Onemli not: Color islemleri yaparken chrome kullaniniz. Firefox Selenium Color classinda problem vermektedir.

    }
}