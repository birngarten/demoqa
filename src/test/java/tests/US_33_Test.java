package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_33_Page;
import utilities.TestBase;

public class US_33_Test extends TestBase {

    US_33_Page us33Page = new US_33_Page();

    @BeforeMethod
    public void brokenSetup(){
        us33Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();


    }

    @Test
    public void TC195(){
// Broken Links - Images linkinin tıklanabildigini assert ediniz


    }

    @Test
    public void TC196(){
// Sayfada sırasıyla Valid image, Broken image, Valid Link ve Broken Link elemanlarinin oldugunu assert ediniz



    }

    @Test
    public void TC197(){
// Valid image ın gorutulendigini assert ediniz


    }

    @Test
    public void TC198(){
// Broken image in goruntulenmedigini assert ediniz


    }

    @Test
    public void TC199(){
// Valid linke tıklandiginda demoqa anasayfaya ulasildini assert ediniz



    }

    @Test
    public void TC200() {
// Broken linke tiklandiginda Ip adresi bulunamadı hatasinin alindigini assert ediniz


    }
    }
