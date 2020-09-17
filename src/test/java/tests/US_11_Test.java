package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_10_Page;
import pages.US_11_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class US_11_Test extends TestBase {
    US_11_Page us11Page = new US_11_Page();
    US_10_Page us10Page = new US_10_Page();

    @BeforeMethod
    public void AlertsFrameWindowsCard() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us10Page.alertsFrameWindowsCard.click();

    }

    @Test
    public void TC_49() {
        //Alerts, Frame & Windows menusune tiklandiginda Alerts menu linki goruntulendigini dogrulayiniz
        Assert.assertTrue(us11Page.alert.isDisplayed());

    }

    @Test
    public void TC_50() {
        //Alerts menu linkine tiklandiginda 4 tane Click me butonu oldugunu dogrulayiniz
        us11Page.alert.click();
        Assert.assertEquals(us11Page.clickMe.size(),4);//List olarak locate ettik

    }


}
