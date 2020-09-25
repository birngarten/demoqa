package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_14_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_14_Test extends TestBase {

    US_14_Page us_14_page = new US_14_Page();
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
    }
    @Test
    public void TC_063(){
        //Her iki buttonun çalışabilirliğini assert ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us_14_page.alertsCard.click();
        us_14_page.modalDialogsLink.click();
        Assert.assertTrue(us_14_page.smalButton.isEnabled());
        Assert.assertTrue(us_14_page.largeButton.isEnabled());
    }
    @Test
    public void TC_064(){
        //Modal dialogs menusunde sayfada gorulen Small Modal buttonuna tiklandiginda
        // acilan penceredeki text 47 charakter e sahip olmalidir.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us_14_page.alertsCard.click();
        us_14_page.modalDialogsLink.click();
        us_14_page.smalButton.click();
        Assert.assertEquals(us_14_page.smallModalBox.getText().length(),47);
    }
    @Test
    public void TC_065(){
        //Small buttonunna tiklandiginda acilan penceredeki
        // Close button unun pencereyi kapattigini dogrulayiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us_14_page.alertsCard.click();
        us_14_page.modalDialogsLink.click();
        us_14_page.smalButton.click();
        us_14_page.smallBoxCloseButton.click();
        //Assert.assertEquals(us_14_page.boxStatusCheck.getAttribute("class"),"");
        Assert.assertTrue(us_14_page.boxStatusCheck.getAttribute("class").isEmpty());
    }
    @Test
    public void TC_066(){
        //Modal dialogs menusunde sayfada gorulen Large Modal buttonuna tiklandiginda
        // acilan penceredeki text in font-familie ailesinde "Roboto" olmalidir.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us_14_page.alertsCard.click();
        us_14_page.modalDialogsLink.click();
        us_14_page.largeButton.click();
        Assert.assertTrue(us_14_page.largeText.getCssValue("font-family").contains("Roboto"));
    }
    @Test
    public void TC_067(){
        //Large Modal buttonuna tiklandiginda acilan pencerede
        // Close button ' u pencereyi kapattigini assert ediniz.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us_14_page.alertsCard.click();
        us_14_page.modalDialogsLink.click();
        us_14_page.largeButton.click();
        us_14_page.closeLargeTextButton.click();
        Assert.assertTrue(us_14_page.boxStatusCheck.getAttribute("class").isEmpty());
//        Actions actions = new Actions(Driver.getDriver());
//        actions.clickAndHold();
//        actions.moveByOffset(300,500).perform();
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
//        javascriptExecutor.executeScript("document.querySelector('#resizableBoxWithRestriction')");
    }

}