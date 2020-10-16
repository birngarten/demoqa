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



    }

    @Test
    public void TC_149() {
        //-Birinci kutunun(üstteki büyük kutunun),
        // en fazla icinde bulundugu kutu kadar buyutulebildigni dogrula.

    }

    @Test
    public void TC_150(){
        // (Boyutlarinin; baslangicta 200x200 oldugu, min boyutunun 150x150 oldugu, max boyutunun ise 500x300
        // oldugu dogrulanmali)
        //-Alttaki diger kücük kutunun ise istenildigi kadar buyutulup ve kucultulebildigini dogrula.


    }
}
