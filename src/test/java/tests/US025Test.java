package tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US025Page;
import utilities.Driver;

public class US025Test {
    US025Page us025Page = new US025Page();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://demoqa.com/interaction");
    }
    @Test
    public void tc142(){
        //-Selectable texti tiklanilir ve acildigini ve sayfada main-header oldugunu verify edin
        Assert.assertTrue(us025Page.selectableLink.isEnabled());
    }
    @Test
    public void tc143(){
        //-Selectable texti tiklanildiginda;
        //a. Soldan saga "Elements" text'inin hizasinda olmak üzere, sirasiyla "List" ve "Grid" boxlarinin göründügünü  ve
        //"Grid" yazisinin mavi oldugunu assert edin.
        us025Page.selectableLink.click();
        Assert.assertTrue(us025Page.listLink.isDisplayed());
        Assert.assertTrue(us025Page.gridLink.isDisplayed());
        String color = Color.fromString(us025Page.gridLink.getCssValue("color")).asHex();
        Assert.assertEquals(color,"#007bff");

    }
    @Test
    public void tc144(){
        //b. "List" ve "Grid" boxlarinin altinda, ayni hizada, ayri kutucuklar halinde, ayni buyuklukteki Box'lar icinde ve yukardan asagiya sirasiyla;
        // "Cras justo", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac" bulundugunu  verify edin

    }
    @Test
    public void tc145(){
        //-"Cras justo"", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac" boxlari tiklanildiginda arka fonun mavi, yazilarin
        // ise beyaz oldugunu dogrula.
        //Tekrar tiklandiginda Fon renginin gittigini dogrula.
    }
    @Test
    public void tc146(){
        //-"Grid" box'i tiklanildiginda "Grid" yazisinin siyah oldugunu dogrula. Alt kisimda soldan saga 3, yukardan asagiya 3 olmak üzere
        //toplam 9 kücük karecigin acildigini dogrula ve
        // soldan saga kutucuklarin icerisinde, ortali olmak üzere "One", "Two", "Three", "Four", "Five", "Six", "Seven", Eight", "Nine" yazilarinin
        //yer aldigini dogrula.
    }
}
