package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US010Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US010 {

    US010Page us010 = new US010Page();

    @BeforeTest
    public void stars() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }

    @Test
    public void tc043() {
        us010.alersFrameAndWindows.click();
        ReusableMethods.waitFor(1);
        //us010.browserWindows.click();
        Assert.assertTrue(us010.browserWindows.isDisplayed());
    }

    @Test
    public void tc044() {
        //eksik kaldı
        us010.alersFrameAndWindows.click();
        //  us010.browsersWindow.click();
//        List<String> text = new ArrayList<>();
//        for (int i=11; i<16;i++){
//            String element = "(//span[@class='text'])["+i+"]";
//            text.add(Driver.getDriver().findElement(By.id(element)).getText());
//        }
//        System.out.println(text);
    }
    @Test
    public void tc045(){
        us010.alersFrameAndWindows.click();
        us010.browsersWindow.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(us010.newTabButton.isDisplayed());
        softAssert.assertTrue(us010.newWindowButton.isDisplayed());
        softAssert.assertTrue(us010.newWindowMessageButton.isDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void tc046(){
        us010.alersFrameAndWindows.click();
        us010.browsersWindow.click();

//        //   String ilkSayfa= Driver.getDriver().getWindowHandle();
//        ReusableMethods.waitFor(2);
//        us_06_page.ikinciHomeLink.click();
//
//        /////1. yontem list ile
//        ReusableMethods.waitFor(2);
//        allWindowHandels=new ArrayList<>(Driver.getDriver().getWindowHandles());
//        System.out.println(allWindowHandels.size());
//        System.out.println(allWindowHandels);
//        Driver.getDriver().switchTo().window(allWindowHandels.get(1));
//        System.out.println(Driver.getDriver().getCurrentUrl());
//        String listYeniCurrentUrl=Driver.getDriver().getCurrentUrl();
//        Assert.assertEquals(listYeniCurrentUrl,"https://demoqa.com/");
        List<String>allWindowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());

        us010.newTabButton.click();
        allWindowHandles.add(Driver.getDriver().getWindowHandle());
        if(allWindowHandles.equals())
    }
}
