package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_15_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_15_Test extends TestBase {
    US_15_Page us_15_page = new US_15_Page();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
    }
    @Test
    public void TC_068(){
        //Widgets menusune tiklandiginda Accordian menu linki goruldugunu assert ediniz.
        us_15_page.wigdedsCard.click();
        Assert.assertTrue(us_15_page.accordianLink.isDisplayed());
    }
    @Test
    public void TC_069(){
        //Accordian menu linki calisir oldugunu assert ediniz.
        us_15_page.wigdedsCard.click();
        Assert.assertTrue(us_15_page.accordianLink.isEnabled());
    }
    @Test
    public void TC_070(){
        //Accordian menu linkine tiklanabildigini ve tiklandiginda uc adet
        // accordion menu oldugunu bunlardan ikincisi "Where does it come from?" oldugunu verify ediniz
        us_15_page.wigdedsCard.click();
        us_15_page.accordianLink.click();
        softAssert.assertEquals(us_15_page.accordionHeader.size(),3);
        softAssert.assertEquals(us_15_page.accordionHeader.get(1).getText(),"Where does it come from?");
        softAssert.assertAll();
//        us_15_page.accordionHeader.get(0).click();
//        ReusableMethods.waitFor(2);
//        System.out.println(us_15_page.test.getText());
    }
    @Test
    public void TC_071(){
        //Accordion menu linkine tiklanabildigini ve tiklandiginda ilk cikan "What is Lorem Ipsum?"
        // accordion menu linkindeki textin "Lorem Ipsum is simply" ifadesini icerdigini verify ediniz
        us_15_page.wigdedsCard.click();
        us_15_page.accordianLink.click();
        softAssert.assertEquals(us_15_page.accordionHeader.get(0).getText(),"What is Lorem Ipsum?");
        softAssert.assertTrue(us_15_page.firstText.getText().contains("Lorem Ipsum is simply"));
        softAssert.assertAll();
    }
    @Test
    public void TC_072(){
        //ikinci accordion menu linkine tiklanabildigini ve  tiklandiginda birinci acordion menu linkinin kapandigini
        // ve ikinci acordion menu linkinin basliginin "Where does it come from?" oldugunu verify ediniz
        us_15_page.wigdedsCard.click();
        us_15_page.accordianLink.click();
        softAssert.assertTrue(us_15_page.accordionHeader.get(1).isEnabled());
        us_15_page.accordionHeader.get(1).click();
        ReusableMethods.waitFor(2);
        softAssert.assertFalse(us_15_page.firstText.isDisplayed());
        softAssert.assertEquals(us_15_page.accordionHeader.get(1).getText(),"Where does it come from?");
        softAssert.assertAll();
    }
    @Test
    public void TC_073(){
        //Ucuncu accordion menu linkine tiklandigini, tiklandiginda ikinci akordion menu linkinin kapandigini
        // ve ucuncu acordion menu linkindeki Text'in Font-weight' inin 400 oldugunu verify ediniz
        us_15_page.wigdedsCard.click();
        us_15_page.accordianLink.click();
        softAssert.assertTrue(us_15_page.accordionHeader.get(2).isEnabled());
        us_15_page.accordionHeader.get(2).click();
        ReusableMethods.waitFor(2);
        softAssert.assertFalse(us_15_page.secondText.isDisplayed());
        softAssert.assertEquals(us_15_page.thirdText.getCssValue("font-weight"),"400");
        softAssert.assertAll();
    }
}