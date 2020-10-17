package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_26_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_26_Test extends TestBase {

    US_26_Page us26Page=new US_26_Page();

    SoftAssert soft=new SoftAssert();

    @BeforeMethod
    public void setUs26Page(){

        wait.until(ExpectedConditions.elementToBeClickable(us26Page.interactionsCard)).click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        wait.until(ExpectedConditions.elementToBeClickable(us26Page.resizablePage)).click();


    }

    @Test
    public void TC_147(){

        //-Resizable textinin tiklanilir ve acilir oldugunu ve sayfada main-header oldugunu dogrula.

        soft.assertTrue(us26Page.resizablePage.isEnabled());

        if (us26Page.resizablePage.isEnabled()){
            ReusableMethods.waitFor(2);
            System.out.println(us26Page.resizableHeaderText.getText());
            soft.assertTrue(us26Page.resizableHeaderText.isDisplayed());
        }


        soft.assertAll();
    }

    @Test
    public void TC_148(){
    //-Resizable texti tiklanildiginda; üstte büyügü olmak üzere iki "Resizable" kutunun acildigini kontrol edin.


        System.out.println(us26Page.firstStabilBox.getText());
        soft.assertTrue(us26Page.firstStabilBox.getText().contains("max is 500x300."));

        System.out.println(us26Page.secondUnstabilBox.getText());
        soft.assertTrue(us26Page.secondUnstabilBox.getText().contains("Resizable"));

    }

    @Test
    public void TC_149() {
        //-Birinci kutunun(üstteki büyük kutunun),
        // en fazla icinde bulundugu kutu kadar buyutulebildigni dogrula.
        ReusableMethods.waitFor(2);

       // actions.clickAndHold(us26Page.catchPoint.get(0)).moveByOffset(400,200).build().perform();
        actions.clickAndHold(us26Page.catchPoint.get(0)).moveByOffset(300,100).build().perform();
        ReusableMethods.waitFor(1);

        soft.assertTrue(us26Page.ilkResizableKutu.getAttribute("style").contains("500px"));

        soft.assertAll();

    }

    @Test
    public void TC_150(){
        // (Boyutlarinin; baslangicta 200x200 oldugu, min boyutunun 150x150 oldugu, max boyutunun ise 500x300
        // oldugu dogrulanmali)
        //-Alttaki diger kücük kutunun ise istenildigi kadar buyutulup ve kucultulebildigini dogrula.


        ReusableMethods.waitFor(3);
        System.out.println(us26Page.resizeableBoxes.get(0).getAttribute("style"));
        soft.assertEquals(us26Page.resizeableBoxes.get(0).getAttribute("style"),"width: 200px; height: 200px;");

        wait.until(ExpectedConditions.elementToBeClickable(us26Page.catchPoint.get(0)));
        actions.clickAndHold(us26Page.ilkTutmaNoktasi).moveByOffset(-50,-50).build().perform();

        soft.assertEquals(us26Page.ilkResizableKutu.getAttribute("style"),"width: 150px; height: 150px;");

        ReusableMethods.waitFor(1);



        soft.assertAll();



    }
}
