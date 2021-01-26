package testsDemoqa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US014Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US014Test {
    US014Page us014Page = new US014Page();
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc064(){
        //Modal Dialogs menu linkine tiklandiginda sayfada gorulen iki button calisir olmali
        us014Page.alertsFrameWinwowsCard.click();
        us014Page.modalDialogsLink.click();
        Assert.assertTrue(us014Page.smallModalButton.isEnabled());
        Assert.assertTrue(us014Page.largeModalButton.isEnabled());
    }
    @Test
    public void tc065(){
        //Modal dialogs menusunde sayfada gorulen Small Modal buttonuna tiklandiginda
        // acilan penceredeki text 47 charakter e sahip olmalidir.
        us014Page.alertsFrameWinwowsCard.click();
        us014Page.modalDialogsLink.click();
        us014Page.smallModalButton.click();
        String text = us014Page.smallModalText.getText();
        Assert.assertEquals(text.length(),47);
    }
    @Test
    public void tc066(){
        //Small buttonunna tiklandiginda acilan penceredeki Close button unun pencereyi kapattigini dogrulayiniz
        us014Page.alertsFrameWinwowsCard.click();
        us014Page.modalDialogsLink.click();
        us014Page.smallModalButton.click();
        ReusableMethods.waitFor(1);
        us014Page.smallModalWindowCloseButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us014Page.textAssertionTag.getCssValue("class").equals(""));
    }
    @Test
    public void tc067(){
        //Modal dialogs menusunde sayfada gorulen Large Modal buttonuna tiklandiginda
        // acilan penceredeki text in font-familie ailesinde "Roboto" olmalidir.
        us014Page.alertsFrameWinwowsCard.click();
        us014Page.modalDialogsLink.click();
        us014Page.largeModalButton.click();
        String cssValue = us014Page.largeModalText.getCssValue("font-family");
        System.out.println(cssValue);
        Assert.assertTrue(cssValue.contains("Roboto"));
    }
    @Test
    public void tc068(){
        //Large Modal buttonuna tiklandiginda acilan pencerede Close button ' u pencereyi kapattigini assert ediniz.
        us014Page.alertsFrameWinwowsCard.click();
        us014Page.modalDialogsLink.click();
        us014Page.largeModalButton.click();
        ReusableMethods.waitFor(1);
        us014Page.largeModalWindowCloseButton.click();
        Assert.assertTrue(us014Page.textAssertionTag.getCssValue("class").equals(""));
    }
}
