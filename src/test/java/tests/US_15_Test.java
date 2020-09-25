package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_15_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_15_Test extends TestBase {
    US_15_Page us15Page = new US_15_Page();


    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
        us15Page.widgedsCard.click();


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us15Page.accordianMenuLink.click();
    }

    @Test
    public void TC_068(){
//        Widgets menusune tiklandiginda Accordian menu linki goruldugunu assert ediniz.
        Assert.assertTrue(us15Page.accordianMenuLink.isDisplayed());

    }

    @Test
    public void TC_069(){
//        Accordian menu linki calisir oldugunu assert ediniz.
        Assert.assertTrue(us15Page.accordianMenuLink.isEnabled());

    }

    @Test
    public void TC_070(){
//        Accordian menu linkine tiklanabildigini ve tiklandiginda uc adet accordion menu oldugunu bunlardan ikincisi
//        "Where does it come from?" oldugunu verify ediniz
        Assert.assertEquals(us15Page.accordianHeader.size(),3);
        Assert.assertEquals(us15Page.accordianHeader.get(1).getText(),"Where does it come from?");

    }

    @Test
    public void TC_071(){
//        Accordion menu linkine tiklanabildigini ve tiklandiginda ilk cikan "What is Lorem Ipsum?"
//        accordion menu linkindeki textin "Lorem Ipsum is simply" ifadesini icerdigini verify ediniz
        ReusableMethods.waitFor(1);
        Assert.assertEquals(us15Page.accordianHeader.get(0).getText(),"What is Lorem Ipsum?");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us15Page.accordianHeader.get(0).getText().contains("Lorem Ipsum is simply"));

    }

    @Test
    public void TC_072(){
//        ikinci accordion menu linkine tiklanabildigini ve  tiklandiginda birinci acordion menu linkinin kapandigini
//        ve ikinci acordion menu linkinin basliginin "Where does it come from?" oldugunu verify ediniz


    }

    @Test
    public void TC_073(){
//        Ucuncu accordion menu linkine tiklandigini, tiklandiginda ikinci akordion menu linkinin kapandigini ve
//        ucuncu acordion menu linkindeki Text'in Font-weight' inin 400 oldugunu verify ediniz


    }

}
