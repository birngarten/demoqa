package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_21_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_21_Test extends TestBase {

    US_21_Page us_21_page=new US_21_Page();

    @BeforeMethod
    public void Setup21(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us_21_page.widgetsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();


    }

    @Test
    public void TC_112(){
       // Sayfanin basliginin "Tool Tips "oldugunu assert edin.

    }

    @Test
    public void TC_113() {
        //Ust textte "Practice Tool Tips" yazdigini assert edin

    }

    @Test
    public void TC_114() {
        //Button yesil renk dolgulu ve beyaz yazi tipinde oldugunu assert edin


    }

    @Test
    public void TC_115() {
        //Text box basligi "Hover me to see" olmali assert edin

    }

    @Test
    public void TC_116() {
        //Mouse Text box basligi üzerine geldiginde "You hovered over the Button" yazisi siyah renk dolgulu
        // box icinde ve beyaz yazi tipinde oldugunu assert edin.


    }

    @Test
    public void TC_117() {
        //Hover me to see basligi altinda "bos text kutusu " ve altinda bir metin oldugunu assert edin



    }

    @Test
    public void TC_118() {
        //Metnin icinde "Contrary ve 1.10.32  bilgilerini icerdigini assert edin

    }

}
