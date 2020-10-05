package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_21_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class US_21_Test extends TestBase {

    US_21_Page us_21_page=new US_21_Page();

    @BeforeMethod
    public void Setup21(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us_21_page.widgetsCard));
        us_21_page.widgetsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_21_page.linkToolTips.click();
    }

    @Test
    public void TC_112(){
       // Sayfanin basliginin "Tool Tips "oldugunu assert edin.
       Assert.assertEquals(us_21_page.mainHeader.getText(),"Tool Tips");
    }

    @Test
    public void TC_113() {
        //Ust textte "Practice Tool Tips" yazdigini assert edin
        Assert.assertEquals(us_21_page.subHeader.getText(),"Practice Tool Tips");
    }

    @Test
    public void TC_114() {
        //Button yesil renk dolgulu ve beyaz yazi tipinde oldugunu assert edin
        String boxColor = ReusableMethods.getHexColor(us_21_page.buttonHover,"background-color");
        System.out.println(boxColor);//#28a745
        Assert.assertEquals(boxColor,"#28a745");

        String textColor = ReusableMethods.getHexColor(us_21_page.buttonHover,"color");
        System.out.println(textColor);
        Assert.assertEquals(textColor,"#ffffff");
       // #fff

    }

    @Test
    public void TC_115() {
        //Text box basligi "Hover me to see" olmali assert edin
        Assert.assertEquals(us_21_page.buttonHover.getText(),"Hover me to see");
    }

    @Test
    public void TC_116() {
        //Mouse Text box basligi üzerine geldiginde "You hovered over the Button" yazisi siyah renk dolgulu
        // box icinde ve beyaz yazi tipinde oldugunu assert edin.
        actions.moveToElement(us_21_page.buttonHover).build().perform();
        wait.until(ExpectedConditions.visibilityOf(us_21_page.hoverGizliText));

        Assert.assertTrue(us_21_page.hoverGizliText.isDisplayed());
        String toolTipText = us_21_page.hoverGizliText.getText();
        System.out.println(toolTipText);//You hovered over the Button  (Source-Event Listener-Mouse/ F8 ile dondurabiliyoruz)
        Assert.assertEquals(toolTipText,"You hovered over the Button");

        String gizliTextBackgroundColor = ReusableMethods.getHexColor(us_21_page.hoverGizliText,"background-color");
        System.out.println(gizliTextBackgroundColor);//#000
        Assert.assertEquals(gizliTextBackgroundColor,"#000");

        String gizliTextColor = ReusableMethods.getHexColor(us_21_page.hoverGizliText,"color");
        System.out.println(gizliTextColor);//#ffffff
        Assert.assertTrue(gizliTextColor.equals("#fff") || (gizliTextColor.equals("#ffffff")));

    }

    @Test
    public void TC_117() {
        //Hover me to see basligi altinda "bos text kutusu " ve altinda bir metin oldugunu assert edin
        int hoverHeight = us_21_page.buttonHover.getLocation().y;
        int bosTextHeight = us_21_page.bosTextBox.getLocation().y;
        int doluTextHeight = us_21_page.doluText.getLocation().y;
        System.out.println(hoverHeight);//276
        System.out.println(bosTextHeight);//338
        System.out.println(doluTextHeight);//400

        boolean durum = false;
        if(hoverHeight<bosTextHeight && bosTextHeight<doluTextHeight){
            System.out.println("PASS");
            durum =true;
        }
        Assert.assertTrue(durum);

    }

    @Test
    public void TC_118() {
        //Metnin icinde "Contrary ve 1.10.32  bilgilerini icerdigini assert edin
        Assert.assertTrue(us_21_page.doluText.getText().contains("Contrary"));
        Assert.assertTrue(us_21_page.doluText.getText().contains("1.10.32"));
    }

}
