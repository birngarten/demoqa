package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_10_Page;
import pages.US_11_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;


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

    @Test
    public void TC_51() {
        //Birinci Click me butonuna tiklandiginda cikan alertte "You clicked a button" texti oldugunu verify ediniz
        us11Page.alert.click();
        us11Page.clickMe.get(0).click();
        ReusableMethods.waitFor(1);
        String alert01Text = Driver.getDriver().switchTo().alert().getText();
        //System.out.println(alert01Text);
        Assert.assertEquals(alert01Text,"You clicked a button");
    }

    @Test
    public void TC_52() {
        //Ikinci Click me butonuna tiklandiginda
        //5 saniye icinde cikan alertte OK butonuna tiklanabildigini dogrulayiniz
        us11Page.alert.click();
        us11Page.clickMe.get(1).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.alertIsPresent());

    //    alert un gorunurlugunu test icin:
    //    String alert02Text= Driver.getDriver().switchTo().alert().getText();
    //    System.out.println(alert02Text);


//Solve1//sayfada alert`e gecis yaptik.
        //alert in goruntulendigini dogrulamak icin textinin " oldugunu assert edelim
        //ok butonuna tiklayalim. bu butona tiklandiginda alert kapanmali
        // ve sayfada herhangi bir eleman isDisplayed olmalidir.
        //bu yüzden tikladigimiz click me butonunun görünür oldugunu test edelim.

        //    String text = Driver.getDriver().switchTo().alert().getText();
        //    Assert.assertEquals(text,"This alert appeared after 5 seconds");
        //    Driver.getDriver().switchTo().alert().accept();
        //    Assert.assertTrue(us11Page.clickMe.get(1).isDisplayed());


//Solve2
   //     try{
   //         Driver.getDriver().switchTo().alert().accept();
   //     }catch (Exception e){
   //         System.out.println(e);
   //     }
    }
}
