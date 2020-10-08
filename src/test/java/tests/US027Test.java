package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US027Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US027Test {
        US027Page us027Page = new US027Page();
        Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://demoqa.com/interaction");
    }
    @Test
    public void tc151(){
        //Droppable menu linkinin tiklanabilir oldugunu dogrulayiniz
        Assert.assertTrue(us027Page.dropableLink.isEnabled());
    }
    @Test
    public void tc152(){
        //Droppable sayfasinda "Simple", "Accept" ,"Prevent Propogation","Revert Draggable" bulundugunu dogrulayiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(us027Page.dropableLink,10);
        us027Page.dropableLink.click();

        String [] myTestData ={"Simple", "Accept" ,"Prevent Propogation","Revert Draggable"};
        int i=0;
        for (WebElement w : us027Page.mainLİnks){
            Assert.assertEquals(w.getText(),myTestData[i]);
            i++;
        }
    }
    @Test
    public void tc153(){
        //Simple tab i altinda "Drag me" kutusu "Drop here" kutusu uzerine suruklenip birakildiginda "Dropped!" yazisinin goruntulendigini dogrulayiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(us027Page.dropableLink,10);
        us027Page.dropableLink.click();
        ReusableMethods.waitFor(1);
        us027Page.mainLİnks.get(0).click();
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us027Page.draggable).perform();
        actions.moveToElement(us027Page.droppable).perform();
        actions.release().perform();
        Assert.assertEquals(us027Page.droppable.getText(),"Dropped!");
    }
    @Test
    public void tc154(){
        //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde "Drop here" kutusunun yesil renk aldigini dogrulayiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(us027Page.dropableLink,10);
        us027Page.dropableLink.click();
        ReusableMethods.waitFor(1);
        us027Page.mainLİnks.get(1).click();
        us027Page.acceptableBox.click();
        actions.clickAndHold(us027Page.acceptableBox).perform();
        actions.moveToElement(us027Page.droppable).perform();
    }
    @Test
    public void tc155(){
        //Accept Tab'inin altinda "Acceptable" kutusu suruklendiginde
        // "Drop here" kutusunun mavi renk aldigini ve "Dropped!" yazininin gozuktugunu dogrulayiniz
    }
    @Test
    public void tc156(){
        //Accept Tab'inin altinda "Not Acceptable" kutucugunun suruklendiginde
        // "Drop Here" kutusunun renk degistirmedigini dogrulayiniz
    }
    @Test
    public void tc157(){
        //Prevent Propogation Tab'inin altinda "Drag me" kutucugunu ustteki
        // "Outer droppable" kutucuguna getirdiginizde  kutunun acik yesil oldugunu
        // ve " Inner droppable(not greedy)" kutucugunun koyu yesil oldugunu dogrulayinuz
    }
    @Test
    public void tc158(){
        //Prevent Propogation Tab'i altindaki "Drag me" kutucugunu ustteki
        // "Inner droppable (not greedy)" kutucuguna getirdiginizde ic kutu olan "inner droppable(not greedy)" kutucugunun
        // ve onun dis cevresindeki outer droppable kutucugunun da ayni renkte oldugunu dogrulayiniz
    }
    @Test
    public void tc159(){
        //Revert Draggable Tab'i altinda "Will Revert" kutucugunun
        // "Drop here" kutusuna birakildiginda tekrar eski yerine geldigini dogrulayiniz
    }
    @Test
    public void tc160(){
        //Revert Draggable Tab'i altinda "Not Revert" kutucugunun "Drop here"
        // kutusuna birakildiginda tekrar eski yerine gelmedigini  dogrulayiniz
    }

}
