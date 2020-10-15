package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_25_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_25_Test extends TestBase {

    US_25_Page us25Page=new US_25_Page();
    SoftAssert sof=new SoftAssert();

    @BeforeMethod
    public void setUs25Page(){
        wait.until(ExpectedConditions.elementToBeClickable(us25Page.interactionsCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(us25Page.selectableLink)).click();


    }
    @Test
    public void TC_142(){
        //TC142	-Selectable textinin tiklanildigini ve
        // acildigini ve sayfada main-header oldugunu verify edin

        sof.assertTrue(us25Page.selectableLink.isEnabled());
        sof.assertTrue(us25Page.interactionHeadText.isDisplayed());



        sof.assertAll();

    }
    @Test
    public void TC_143(){
        //-Selectable texti tiklanildiginda;
        //a. Soldan saga "Elements" text'inin hizasinda olmak üzere,
        // sirasiyla "List" ve "Grid" boxlarinin göründügünü  ve
        //"Grid" yazisinin mavi oldugunu assert edin.

        String  listGrid[]={"List","Grid"};
        int count=0;
        us25Page.listAndGridButtons.get(0).click();
        String colorGrid=ReusableMethods.getHexColor(us25Page.listAndGridButtons.get(1),"color");
        System.out.println(colorGrid);
        sof.assertEquals(colorGrid,"#07bff");

        System.out.println(us25Page.listAndGridButtons.size()+" tane tab var");
        for (WebElement w: us25Page.listAndGridButtons){
            System.out.println(w.getText());
            sof.assertTrue(w.getText().equals(listGrid[count]));
            ReusableMethods.waitFor(3);
            count++;
        }



        sof.assertAll();



    }
    @Test
    public void TC_144(){
       //b. "List" ve "Grid" boxlarinin altinda,
        // ayni hizada, ayri kutucuklar halinde,
        // ayni buyuklukteki Box'lar icinde ve yukardan asagiya sirasiyla;
        // "Cras justo", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac" bulundugunu  verify edin
        us25Page.listAndGridButtons.get(0).click();
        for (WebElement kutu: us25Page.listTabOfTextes){
            kutu.click();
            System.out.println(kutu.getText());
        }



    }
    @Test
    public void TC_145(){
        //-"Cras justo"", "Dapibus ac facilisis in", "Morbi leo risus", "Porta ac consectetur ac"
        // boxlari tiklanildiginda arka fonun mavi,
        // yazilarin ise beyaz oldugunu dogrula.
        // Tekrar tiklandiginda Fon renginin gittigini dogrula.


    }
    @Test
    public void TC_146(){
        //-"Grid" box'i tiklanildiginda "Grid" yazisinin siyah oldugunu dogrula.
        // Alt kisimda soldan saga 3, yukardan asagiya 3 olmak üzere
        //toplam 9 kücük karecigin acildigini dogrula ve
        // soldan saga kutucuklarin icerisinde,
        // ortali olmak üzere "One", "Two", "Three", "Four", "Five", "Six", "Seven", Eight", "Nine" yazilarinin yer aldigini dogrula.


    }




}
