package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US012Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US012Test {
        US012Page us012Page = new US012Page();
    @BeforeMethod
    public void stars() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc056(){
        //Alerts, Frame & Windows menusune tiklandiginda Frames menu linkinin goruntulenebilir oldugunu assert ediniz
        us012Page.alertsFrameWinwowsCard.click();
        Assert.assertTrue(us012Page.framesPageLink.isEnabled());
    }
    @Test
    public void tc057(){
        //Frames'e tiklandiginda sayfanin altinda bulunan kucuk kutucukta "This is a sample page" texti oldugunu assert ediniz.
        us012Page.alertsFrameWinwowsCard.click();
        us012Page.framesPageLink.click();
        Driver.driver.switchTo().frame("frame2");
        String elementText = Driver.getDriver().findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        Assert.assertEquals(elementText,"This is a sample page");
    }

}
