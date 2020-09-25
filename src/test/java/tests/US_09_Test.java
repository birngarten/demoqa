package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        us09Page.userEmail.sendKeys(ConfigReader.getProperty("valid_email"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us09Page.submitButton.click();
        ReusableMethods.waitFor(1);

        String hataColor = us09Page.userEmail.getCssValue("border-color");
        System.out.println(hataColor);
        ReusableMethods.waitFor(2);
        String hexColor = Color.fromString(hataColor).asHex();
        System.out.println(hexColor);
        Assert.assertEquals(hexColor,"#28a745");
    }

    @Test
    public void TC_039() {
        //Mobile TextBox kisminda sadece 10 haneli mobile number girisi yapilabildigini dogrulayin
        us09Page.practiceFormMenuLink.click();
        String minNumber=us09Page.mobileNumber.getAttribute("minlength");
        System.out.println("min mobile number " +minNumber);
        Assert.assertEquals(minNumber,"10");

        String maxNumber=us09Page.mobileNumber.getAttribute("maxlength");
        System.out.println("max mobile number" + maxNumber);
        Assert.assertEquals(maxNumber,"10");
    }

    @Test
    public void TC_040() {
        //Hobbies checkBoxlari secilebilir oldugunu dogrulayin
        us09Page.practiceFormMenuLink.click();
        //us09Page.hobiSpor.click();  //tiklamiyor
        actions.click(us09Page.hobiSpor).perform();
        Assert.assertTrue(us09Page.hobiSpor.isSelected());

        actions.click(us09Page.hobiReading).perform();
        Assert.assertTrue(us09Page.hobiReading.isSelected());

        actions.click(us09Page.hobiMusic).perform();
        Assert.assertTrue(us09Page.hobiMusic.isSelected());
    }

    @Test
    public void TC_041() {
        //Formdaki istenen tum kisimlara veri girisi yapilabildini ve basarili sekilde kayit olusturulabildigini dogrulayin
        us09Page.practiceFormMenuLink.click();
        us09Page.firstname.sendKeys("Ali");
        us09Page.lastName.sendKeys("CAN");
        us09Page.userEmail.sendKeys("can@gmail.com");
        //us09Page.gender.click();
        actions.click(us09Page.gender).perform();
        us09Page.mobileNumber.sendKeys("0123456789");

        us09Page.dateOfBirth.click();
        Select optionsAy = new Select(us09Page.dropDownAy);
        optionsAy.selectByIndex(3);

        Select optionsYil = new Select(us09Page.dropDownYil);
        optionsYil.selectByVisibleText("2020");
        us09Page.gun.click();

        ReusableMethods.waitFor(2);
        us09Page.subject.sendKeys("kayit deneme");
        ReusableMethods.waitFor(2);

        actions.click(us09Page.hobiMusic).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String dosyaYukle="C:\\Users\\pinar\\Downloads\\sampleFile.jpeg";
        us09Page.chooseFile.sendKeys(dosyaYukle);
        ReusableMethods.waitFor(1);
        us09Page.adress.sendKeys("demoqa mahallesi");
        us09Page.state.sendKeys("NCR" +Keys.ENTER);
        us09Page.city.sendKeys("Delhi" +Keys.ENTER);
        us09Page.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us09Page.basariTexti));
        Assert.assertTrue(us09Page.basariTexti.isDisplayed());
        System.out.println("kayit texti :" + us09Page.basariTexti.getText());

    }

    @Test
    public void TC_042() {
        //Sadece zorunlu kisimlar dolduruldugunda basarili bir sekilde kayit olusturuldugunu dogrulayin
        us09Page.practiceFormMenuLink.click();
        us09Page.firstname.sendKeys("Ali");
        us09Page.lastName.sendKeys("CAN");
        actions.click(us09Page.gender).perform();
        us09Page.mobileNumber.sendKeys("0123456789");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us09Page.submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(us09Page.basariTexti));
        Assert.assertTrue(us09Page.basariTexti.isDisplayed());
        System.out.println("kayit texti :" + us09Page.basariTexti.getText());
    }
}