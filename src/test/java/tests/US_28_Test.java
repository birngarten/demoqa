package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_28_Page;
import utilities.TestBase;

import java.time.Duration;

public class US_28_Test extends TestBase {

    US_28_Page us28Page = new US_28_Page();

    @BeforeMethod
    public void setUs28Page(){

        wait.until(ExpectedConditions.elementToBeClickable(us28Page.interactionsCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();


    }

    @Test
    public void TC_161() {
        //Dragable  linkine tiklayiniz ve  fonktionel olup olmadigini  test ediniz
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink));
        Assert.assertTrue(us28Page.dragabbleMenuLink.isEnabled());
        Point abc = us28Page.dragabbleMenuLink.getLocation();
        System.out.println(abc);
    }

    @Test
    public void TC_162() {
        //Sayfanin  ana basligi  Dragabble  ifadesi oldugnu test ediniz ve arka planin da olup olmadigini test ediniz

    }

    @Test
    public void TC_163() {
        // Sayfanin Title nin  Qa olmadgini test ediniz .
    }

    @Test
    public void TC_164() {
        // Sayfada ki " Simpe, Axis Restricted,Container Restricted ,Cursor Style"
        // linklerinin gorunumu ve  islevsel olup olmadigini test ediniz
    }

    @Test
    public void TC_165() {
        //  Drag me elementinin  sayfada  maus ile birlikte  haret ettirebilmesini test ediniz
    }

    @Test
    public void TC_166() {
        // " Only X" yata sekilde  hareketini ve "Only Y"ninde  dikey sekilde hareket ettigini test ediniz
    }

    @Test
    public void TC_167() {
        //  iki farkli  hareket alaninin olup olmadigini assert ediniz ve
        //  "I`m contained within the box" ve "I`m contained within my parent " ifadelerinin
        //  gorunur olup olamdigni test ediniz ve
        //  harekeli ifadelerinin maus ile birlikte hareket edip etmediniz test ediniz.


    }

    @Test
    public void TC_168() {
        // "I will always stick to the center" , "My cursor is at top left" ve "My cursor is at bottom"
        // fadeli hareketli butonlari  mausla  tiklaninca  hareket edip etmedinigini
        // test ediniz ve gorunurlugunun ayni olmadigin da assert ediniz
    }


}
