package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_27_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_27_Test extends TestBase {

    US_27_Page us27=new US_27_Page();
    SoftAssert soft=new SoftAssert();


    @BeforeMethod
    public void setUs27(){

        wait.until(ExpectedConditions.elementToBeClickable(us27.interactionsCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us27.droppableLink)).click();
        ReusableMethods.waitFor(1);



    }

    @Test
    public void TC_151(){

        //Droppable menu linkinin tiklanabilir oldugunu dogrulayiniz

        soft.assertTrue(us27.droppableLink.isEnabled());

        soft.assertAll();

    }

    @Test
    public void TC_152(){
        //Droppable sayfasinda "Simple", "Accept" ,"Prevent Propogation","Revert Draggable" bulundugunu dogrulayiniz

        String   droppedTitle[]={"Simple", "Accept" ,"Prevent Propogation","Revert Draggable"};

        int count=0;

        for (WebElement w: us27.droppedAllSubLinks){

            System.out.println(w.getText());
            soft.assertEquals(w.getText(),droppedTitle[count]);

            count++;

        }


        soft.assertAll();

    }

    @Test
    public void TC_153(){
        //Simple tab i altinda "Drag me" kutusu "Drop here" kutusu uzerine
        // suruklenip birakildiginda "Dropped!" yazisinin goruntulendigini dogrulayiniz

        actions.clickAndHold(us27.dragMeBox).moveToElement(us27.droppedBigBox).release().build().perform();
        soft.assertTrue(us27.droppedBigBox.getText().contains("Dropped!"));
        soft.assertAll();

    }
    @Test
    public void TC_154(){
        //Accept Tab'inin altinda "Acceptable"
        // kutusu suruklendiginde "Drop here" kutusunun yesil renk aldigini dogrulayiniz

        us27.droppedAllSubLinks.get(1).click();

        ReusableMethods.waitFor(2);

        actions.clickAndHold(us27.acceptableBox).moveByOffset(30,10).perform();

        String backgroundColor=ReusableMethods.getHexColor(us27.droppedBoxColors.get(0),"background-color");

        System.out.println(backgroundColor);

        soft.assertEquals(backgroundColor,"#3cb371");

        soft.assertAll();


    }

    @Test
    public void TC_155(){
        //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde "Drop here"
        // kutusunun mavi renk aldigini ve "Dropped!" yazininin gozuktugunu dogrulayiniz

        us27.droppedAllSubLinks.get(1).click();
        ReusableMethods.waitFor(2);
        actions.clickAndHold(us27.acceptableBox).moveToElement(us27.acceptDroppedBoxBlue).release().perform();

        soft.assertEquals(us27.acceptDroppedBoxBlue.getText(),"Dropped!");

        String backgroundColor=ReusableMethods.getHexColor(us27.acceptDroppedBoxBlue,"background-color");

        System.out.println(backgroundColor);

        soft.assertEquals(backgroundColor,"#4682b4");

        soft.assertAll();


    }
    @Test
    public void TC_156(){
        //Accept Tab'inin altinda "Not Acceptable" kutucugunun
        // suruklendiginde "Drop Here" kutusunun renk degistirmedigini dogrulayiniz

        us27.droppedAllSubLinks.get(1).click();
        ReusableMethods.waitFor(2);
        actions.clickAndHold(us27.notAcceptable).moveToElement(us27.acceptDroppedBoxBlue).release().perform();

        String backgroundColor=ReusableMethods.getHexColor(us27.acceptDroppedBoxBlue,"background-color");

        System.out.println(backgroundColor);

        soft.assertFalse(backgroundColor.contains("#4682b4"));

        soft.assertAll();

    }
    @Test
    public void TC_157(){
        //Prevent Propogation Tab'inin altinda "Drag me" kutucugunu ustteki  "Outer droppable"
        // kutucuguna getirdiginizde  kutunun acik yesil oldugunu ve
        // " Inner droppable(not greedy)" kutucugunun koyu yesil oldugunu dogrulayinuz

        us27.droppedAllSubLinks.get(2).click();
        ReusableMethods.waitFor(2);

        actions.clickAndHold(us27.preventDragMeBox).moveToElement(us27.outerDroppableTextBigBox).perform();

        String outDroppeBackgroundColor=ReusableMethods.getHexColor(us27.outDroppeleBixBox,"background-color");
        System.out.println(outDroppeBackgroundColor);

        soft.assertEquals(outDroppeBackgroundColor,"#8fbc8f");

        ReusableMethods.waitFor(2);

        String innerDroppelBackgroundColor=ReusableMethods.getHexColor(us27.innerNotGreedySmallBox,"background-color");

        System.out.println(innerDroppelBackgroundColor);
        soft.assertEquals(innerDroppelBackgroundColor,"#3cb371");
        soft.assertAll();

    }

    @Test
    public void TC_158(){

        //Prevent Propogation Tab'i altindaki "Drag me"
        // kutucugunu ustteki "Inner droppable (not greedy)" kutucuguna getirdiginizde
        // ic kutu olan "inner droppable(not greedy)"
        // kutucugunun ve onun dis cevresindeki outer droppable kutucugunun da ayni renkte oldugunu dogrulayiniz

        us27.droppedAllSubLinks.get(2).click();
        ReusableMethods.waitFor(2);

        actions.clickAndHold(us27.preventDragMeBox).moveToElement(us27.innnerNotGreedyText).perform();

        String outDroppeBackgroundColor=ReusableMethods.getHexColor(us27.outDroppeleBixBox,"background-color");
        System.out.println(outDroppeBackgroundColor);

        soft.assertEquals(outDroppeBackgroundColor,"#8fbc8f");

        ReusableMethods.waitFor(2);

        String innerDroppelBackgroundColor=ReusableMethods.getHexColor(us27.innerNotGreedySmallBox,"background-color");

        System.out.println(innerDroppelBackgroundColor);
        soft.assertEquals(innerDroppelBackgroundColor,"#8fbc8f");

        ReusableMethods.waitFor(2);
        actions.release().perform();
        String blueBackgroundColor=ReusableMethods.getHexColor(us27.outDroppeleBixBox,"background-color");
        System.out.println(blueBackgroundColor);

        soft.assertEquals(outDroppeBackgroundColor,"#4682b4");


        soft.assertAll();

    }

    @Test
    public void TC_159(){
      //  Revert Draggable Tab'i altinda "Will Revert" kutucugunun "Drop here" kutusuna birakildiginda
        //  tekrar eski yerine geldigini dogrulayiniz

//          us27.droppableItems.get(3).click();
//
//        ReusableMethods.waitFor(2);
//        Point a = us27Page.revertableBox.getLocation();
//        System.out.println(a);
//
//        actions.dragAndDrop(us27Page.revertableBox,us27Page.revertDdroppableBox).perform();
//        ReusableMethods.waitFor(5);
//
//        Point b = us27Page.revertableBox.getLocation();
//        System.out.println(b);
//
//        Assert.assertEquals(a,b);

    }
    @Test
    public void TC_160(){

        //Revert Draggable Tab'i altinda "Not Revert"
        // kutucugunun "Drop here" kutusuna birakildiginda tekrar eski yerine gelmedigini  dogrulayiniz


        us27.droppedAllSubLinks.get(3).click();
        ReusableMethods.waitFor(2);

        actions.clickAndHold(us27.notRevertableBox).moveToElement(us27.droppedBigBox).release().perform();

        ReusableMethods.waitFor(1);

        soft.assertFalse(us27.notRevertableBox.getLocation().equals(0));

        soft.assertAll();



    }


}
