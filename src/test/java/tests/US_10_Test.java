package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_10_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US_10_Test extends TestBase {

    US_10_Page us10Page = new US_10_Page();


    @BeforeMethod
    public void AlertsFrameWindowsCard() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us10Page.alertsFrameWindowsCard.click();

    }

    @Test
    public void TC_43() {
        // 43-   Alerts, Frame & Windows menusune tiklandiginda Browser Windows menu linki goruntulenebilir oldugunu dogrulayin
        Assert.assertTrue(us10Page.browserWindows.isDisplayed());
    }

    @Test
    public void TC_44() {
        //Alerts, Frame & Windows menusune tiklandiginda Browser Windows menu linki birinci sirada oldugunu dogrulayin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        List<String> menuIsimleriBox = new ArrayList<>();
        for (int i = 11; i < 16; i++) {
            String menuIsimleriXpath = "(//span[@class='text'])[" + i + "]";
            String menu = Driver.getDriver().findElement(By.xpath(menuIsimleriXpath)).getText();
            menuIsimleriBox.add(menu);
        }
        //System.out.println(menuIsimleriBox);
        Assert.assertEquals(menuIsimleriBox.get(0), "Browser Windows");
    }

    @Test
    public void TC_45() {
        //Browser Windows menu linkine tiklandiginda New Tab,New Window,NewWindow Message butonlarinin tiklanabilir  oldugunu assert ediniz
        us10Page.browserWindows.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us10Page.newTabButton.isEnabled());
        Assert.assertTrue(us10Page.newWindowButton.isEnabled());
        Assert.assertTrue(us10Page.newMsgButton.isEnabled());
    }

    @Test
    public void TC_46() {
        //New Tab butonuna tiklandiginda acilan yeni sekmede "This is a sample page" textinin goruntulendigini assert ediniz
        us10Page.browserWindows.click();
        String parentWindowHandle = Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(2);
        us10Page.newTabButton.click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String newTabHandle : windowHandles) {
            if (newTabHandle != parentWindowHandle) {
                Driver.getDriver().switchTo().window(newTabHandle);
            }
        }
        Assert.assertTrue(us10Page.thisISaSamplePage.isDisplayed());

    }

    @Test
    public void TC_47() {
    //New Window butonuna tiklandiginda acilan yeni pencerede "This is a sample page"
        //textinin bulundugunu verify ediniz

        us10Page.browserWindows.click();
        String parentWindowsHandel = Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(2);
        actions.click(us10Page.newTabButton).perform();

        Set<String> windowHandle = Driver.getDriver().getWindowHandles();
        for (String newWindowHandle: windowHandle) {
            if (newWindowHandle!=parentWindowsHandel){
                Driver.getDriver().switchTo().window(newWindowHandle);
            }
        }
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us10Page.thisISaSamplePage2.isDisplayed());
    }


}
