package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_19_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_19_Test extends TestBase {
    US_19_Page us_19_page=new US_19_Page();

    @BeforeMethod
    public void setup19(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
        us_19_page.widgetsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us_19_page.progressBarLink));
       // ReusableMethods.waitForClickablility(us_19_page.progressBarLink,2);
        us_19_page.progressBarLink.click();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC_097() {
        //sayfanin basliginin "Progress Bar "oldugunu assert edin.
        Assert.assertTrue(us_19_page.headerProgressBar.isDisplayed());
        Assert.assertEquals(us_19_page.headerProgressBar.getText(),"Progress Bar");
    }

    @Test
    public void TC_098() {
        //Start yazisinin beyaz renkte ve mavi renkli button oldugunu assert edin
        String startColor = us_19_page.startStopButton.getCssValue("background-color");
        wait.until(ExpectedConditions.visibilityOf(us_19_page.startStopButton));
        System.out.println(startColor);//rgb(0, 123, 255)  ----  rgba(0, 123, 255, 1)
        String hexColor = Color.fromString(startColor).asHex();
        System.out.println(hexColor);//#007bff    -----  #007bff
        Assert.assertEquals(hexColor,"#007bff");

        String startTextColor = us_19_page.startStopButton.getCssValue("color");
        wait.until(ExpectedConditions.visibilityOf(us_19_page.startStopButton));
        System.out.println(startTextColor);//rgb(255, 255, 255)  ---   rgb(255, 255, 255)
        String hexTextColor = Color.fromString(startTextColor).asHex();
        System.out.println(hexTextColor);//#ffffff  ---  #fff
        Assert.assertEquals(hexTextColor,"#ffffff");
    }

    @Test
    public void TC_099() {
        //Start ikonuna basildiginda veri islendigini assert edin
        us_19_page.startStopButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(us_19_page.fiftyPercentProgress.isDisplayed());
    }

    @Test
    public void TC_100() {
        //veri islemeye basladiginda "Stop" yazdigini assert edin.
        us_19_page.startStopButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assert.assertTrue(us_19_page.stopButton.isDisplayed());
    }

    @Test
    public void TC_101() {
        //Veri islemesinin mavi renkte oldugunu assert edin.
        //#17a2b8
        String barColorBefore = ReusableMethods.getHexColor(us_19_page.infoProgressBar,"background-color");
        System.out.println(barColorBefore);//#17a2b8
        Assert.assertEquals(barColorBefore,"#17a2b8");
    }

    @Test
    public void TC_102() {
        //veri islemesi bittiginde rengin yesile dönmesini assert edin.
        us_19_page.startStopButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        wait.until(ExpectedConditions.visibilityOf(us_19_page.resetButton));
        String barColorAfter = ReusableMethods.getHexColor(us_19_page.successProgressBar,"background-color");
        System.out.println(barColorAfter);
        Assert.assertEquals(barColorAfter,"#28a745");
    }

    @Test
    public void TC_103() {
        //veri isleme %100 oldugunda "Restart" ikonu olustugunu assert edin
        us_19_page.startStopButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        wait.until(ExpectedConditions.visibilityOf(us_19_page.resetButton));
        System.out.println(us_19_page.resetButton.getText());
        Assert.assertFalse(us_19_page.resetButton.getText().equals("Restart"));
    }

    @Test
    public void TC_104() {
        //"Restart" tekrar click yapildiginda veri islenmesini assert edin.
        us_19_page.startStopButton.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        wait.until(ExpectedConditions.visibilityOf(us_19_page.resetButton));
        us_19_page.resetButton.click();
        Assert.assertTrue(us_19_page.startStopButton.isDisplayed());
    }
}
