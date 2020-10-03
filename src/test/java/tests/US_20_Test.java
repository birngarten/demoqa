package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_20_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_20_Test extends TestBase {
    US_20_Page us_20_page = new US_20_Page();

    @BeforeMethod
    public void setup20() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us_20_page.widgetsCard));
        us_20_page.widgetsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_20_page.linkTabs.click();
    }

    @Test
    public void TC_105(){
        //Sayfa basliginin "Tabs" oldugunu assert edin.
        Assert.assertEquals(us_20_page.mainHeader.getText(),"Tabs");
    }

    @Test
    public void TC_106() {
        // Ust Text te "Details about Lorem Ipsum" yazdigini assert edin.
        System.out.println(us_20_page.subHeader.getText());
        Assert.assertEquals(us_20_page.subHeader.getText(),"Details about Lorem Ipsum");
    }

    @Test
    public void TC_107() {
        //"What - Origin - Use - More" ikonlarini ust textte saga dogru
        // yanyana oldugunu assert edin.
        System.out.println(us_20_page.whatElement.getLocation());//(500, 276)
        System.out.println(us_20_page.originElement.getLocation());//(571, 276)
        System.out.println(us_20_page.useElement.getLocation());//(649, 276)
        System.out.println(us_20_page.moreElement.getLocation());//(709, 276)

        int whatWidth = us_20_page.whatElement.getLocation().getX();
        int originWidth = us_20_page.originElement.getLocation().getX();
        int useWidth = us_20_page.useElement.getLocation().x;
        int moreWidth = us_20_page.moreElement.getLocation().x;

        boolean durum = false;
        if(whatWidth<originWidth && originWidth<useWidth && useWidth<moreWidth){
            System.out.println("Result : True");
            durum = true;
        }
        Assert.assertTrue(durum);

    }

    @Test
    public void TC_108() {
        // "What" Textbox in mavi renkte oldugunu ve click yapildiginda gri renk
        // oldugunu ve  Text bilgisini assert edin
        us_20_page.originElement.click();
        wait.until(ExpectedConditions.visibilityOf(us_20_page.whatElement));
        String whatColorBefore = ReusableMethods.getHexColor(us_20_page.whatElement,"color");
        System.out.println(whatColorBefore);//#07bff
        Assert.assertEquals(whatColorBefore,"#07bff");

        ReusableMethods.waitFor(2);

        us_20_page.whatElement.click();
        wait.until(ExpectedConditions.visibilityOf(us_20_page.whatElement));
        String whatColorAfter = ReusableMethods.getHexColor(us_20_page.whatElement,"color");
        System.out.println(whatColorAfter);
        Assert.assertEquals(whatColorAfter,"#495057");

//        us_20_page.tabLinkleriListesi.remove(3);
//        int i = 0;
//        for (WebElement w: us_20_page.tabLinkleriListesi) {
//            wait.until(ExpectedConditions.elementToBeClickable(w));
//            w.click();
//            Assert.assertFalse(us_20_page.metinlerListesi.get(i).getText().isEmpty());
//            i++;
//        }

        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_20_page.metinlerListesi.get(0).getText().contains("It was popularised in the 1960s"));
    }

    @Test
    public void TC_109() {
        // "Origin" Box'da textin mavi renkte oldugunu ve click yapildiginda gri renk
        // oldugunu ve Metin bilgisini assert edin
        String originColorBefore = ReusableMethods.getHexColor(us_20_page.originElement,"color");
        System.out.println(originColorBefore);//#07bff
        Assert.assertEquals(originColorBefore,"#07bff");

        ReusableMethods.waitFor(2);

        us_20_page.originElement.click();
        wait.until(ExpectedConditions.visibilityOf(us_20_page.originElement));
        String originColorAfter = ReusableMethods.getHexColor(us_20_page.originElement,"color");
        System.out.println(originColorAfter);
        Assert.assertEquals(originColorAfter,"#495057");

        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_20_page.metinlerListesi.get(1).getText().contains("Lorem Ipsum comes from sections 1.10.32 and 1.10.33"));

    }

    @Test
    public void TC_110() {
        // "Use" Box'da textin mavi renkte oldugunu ve click yapildiginda gri renk
        // oldugunu ve Metin bilgisini assert edin
        String useColorBefore = ReusableMethods.getHexColor(us_20_page.useElement,"color");
        System.out.println(useColorBefore);//#07bff
        Assert.assertEquals(useColorBefore,"#07bff");

        ReusableMethods.waitFor(2);

        us_20_page.useElement.click();
        wait.until(ExpectedConditions.visibilityOf(us_20_page.useElement));
        String useColorAfter = ReusableMethods.getHexColor(us_20_page.useElement,"color");
        System.out.println(useColorAfter);
        Assert.assertEquals(useColorAfter,"#495057");

        ReusableMethods.waitFor(1);
        Assert.assertTrue(us_20_page.metinlerListesi.get(2).getText().contains("Many desktop publishing packages and web page editors"));

    }

    @Test
    public void TC_111() {
        // "More" Box'in textinin gri renk oldugunu assert ediniz

        String moreColor = ReusableMethods.getHexColor(us_20_page.moreElement,"color");
        System.out.println(moreColor);//#6c757d
        Assert.assertEquals(moreColor,"#6c757d");
    }
}

