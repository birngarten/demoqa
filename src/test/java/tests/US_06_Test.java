package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_06_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US_06_Test extends TestBase {
    List<String> allWindowHandels;
    US_06_Page us_06_page=new US_06_Page();
    
    @Test
    public void TC025() {
        us01Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us_06_page.linksMenuLink.click();
        ReusableMethods.waitFor(2);
        String colorRGB=us_06_page.linksHeaderText.getCssValue("color");
        String colorHex= Color.fromString(colorRGB).asHex();
        System.out.println(colorHex);
        Assert.assertEquals(colorHex,"#aaaaaa");
    }

    @Test
    public void TC026() {
        us01Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us_06_page.linksMenuLink.click();
     //   String ilkSayfa= Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(2);
        us_06_page.ikinciHomeLink.click();

        /////1. yontem list ile
        ReusableMethods.waitFor(2);
         allWindowHandels=new ArrayList<>(Driver.getDriver().getWindowHandles());
        System.out.println(allWindowHandels.size());
        System.out.println(allWindowHandels);
        Driver.getDriver().switchTo().window(allWindowHandels.get(1));
        System.out.println(Driver.getDriver().getCurrentUrl());
        String listYeniCurrentUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(listYeniCurrentUrl,"https://demoqa.com/");


//          2. yontem Set ile
//        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
//        for (String w:windowHandles  ) {
//            if (!w.equals(ilkSayfa)){
//                Driver.getDriver().switchTo().window(w);
//            }
//        }
//        String ikinciSayfaLinki=Driver.getDriver().getCurrentUrl();
//        System.out.println(ikinciSayfaLinki);
//        Assert.assertEquals(ikinciSayfaLinki,"https://demoqa.com/");
    }

    @Test
    public void TC027() {
        us01Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us_06_page.linksMenuLink.click();
        us_06_page.movedLink.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_06_page.movedResponseText.getText().contains("301"));

    }
}
