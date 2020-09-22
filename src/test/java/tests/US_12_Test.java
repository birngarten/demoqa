package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_10_Page;
import pages.US_12_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_12_Test extends TestBase {
    US_12_Page us12Page = new US_12_Page();
    US_10_Page us10Page = new US_10_Page();
    @BeforeMethod
    public void AlertsFrameWindowsCard() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us10Page.alertsFrameWindowsCard.click();
    }

    //Alerts, Frame & Windows menusune tiklandiginda Frames menu linkinin goruntulenebilir oldugunu assert ediniz


    @Test
    public void TC_55() {
        //Alerts, Frame & Windows menusune tiklandiginda Frames menu linkinin goruntulenebilir oldugunu assert ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us12Page.frames.isDisplayed());

    }

    @Test
    public void TC_56() {
      //  Frames'e tiklandiginda sayfanin altinda bulunan kucuk kutucukta "This is a sample page" texti oldugunu assert ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us12Page.frames.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().switchTo().frame(us12Page.frame2);
        System.out.println(us12Page.frame2Text.getText());
        Assert.assertTrue(us12Page.frame2Text.isDisplayed());
    }
}
