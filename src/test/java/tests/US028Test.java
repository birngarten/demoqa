package tests;

import com.mongodb.DBRef;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US028Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class US028Test extends TestBase{

    US028Page us028Page = new US028Page();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://demoqa.com/interaction");
    }
    @Test
    public void tc161(){
        //Dragable  linkine tiklayiniz ve  fonktionel olup olmadigini  test ediniz
        Assert.assertTrue(us028Page.draggbleLink.isEnabled());
    }
    @Test
    public void tc162(){
        //Sayfanin  ana basligi  Dragabble  ifadesi oldugnu test ediniz ve arka planin da olup olmadigini test ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us028Page.draggbleLink.click();
        Assert.assertEquals("Dragabble",us028Page.pageHeader.getText());
    }
    @Test
    public void tc163(){
        //Sayanin Title nin  Qa olmadgini test ediniz .
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us028Page.draggbleLink.click();
        Assert.assertFalse(Driver.getDriver().getTitle().contains("Qa"));
    }
    @Test
    public void tc164(){
        //Sayfada ki " Simpe, Axis Restricted,Container Restricted ,Cursor Style" linklerinin gorunumu ve  islevsel olup olmadigini test ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us028Page.draggbleLink.click();
        for (WebElement w :us028Page.mainTabs) {
            Assert.assertTrue(w.isEnabled());
            System.out.println(w.getText());
        }
    }
    @Test
    public void tc165(){
        // Drag me elementinin  sayfada  maus ile birlikte  haret ettirebilmesini test ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us028Page.draggbleLink));
        us028Page.draggbleLink.click();
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us028Page.dragBox).perform();
        for(int i=0;i<10;i+=2){
            for (int j=0;j<10;j+=2){
                actions.moveByOffset(i,j).perform();
            }
        }
        Assert.assertTrue(Integer.parseInt(us028Page.dragBox.getCssValue("left").
                substring(0,us028Page.dragBox.getCssValue("left").length()-2))!=0);
        Assert.assertTrue(Integer.parseInt(us028Page.dragBox.getCssValue("top").
                substring(0,us028Page.dragBox.getCssValue("top").length()-2))!=0);
    }
    @Test
    public void tc166(){
        //" Only X" yata sekilde  hareketini ve "Only Y"ninde  dikey sekilde hareket ettigini test ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us028Page.draggbleLink));
        us028Page.draggbleLink.click();
        ReusableMethods.waitFor(1);
        us028Page.mainTabs.get(1).click();
        //for X only
        actions.clickAndHold(us028Page.restrictedX).perform();
        for(int i=0;i<10;i+=2){
            for (int j=0;j<10;j+=2){
                actions.moveByOffset(i,j).perform();
            }
        }
        Assert.assertTrue(Integer.parseInt(us028Page.restrictedX.getCssValue("left").
                substring(0,us028Page.restrictedX.getCssValue("left").length()-2))!=0);
        //System.out.println(us028Page.restrictedX.getCssValue("top"));
        Assert.assertTrue(us028Page.restrictedX.getCssValue("top").equals("0px"));
        actions.release().perform();
        //for Y only
        actions.clickAndHold(us028Page.restrictedY).perform();
        for(int i=0;i<10;i+=2){
            for (int j=0;j<10;j+=2){
                actions.moveByOffset(i,j).perform();
            }
        }
        Assert.assertTrue(Integer.parseInt(us028Page.restrictedY.getCssValue("top").
                substring(0,us028Page.restrictedY.getCssValue("top").length()-2))!=0);
        //System.out.println(us028Page.restrictedX.getCssValue("top"));
        Assert.assertTrue(us028Page.restrictedY.getCssValue("left").equals("0px"));
        actions.release().perform();
    }
    @Test
    public void tc167(){
        // iki farkli  hareket alaninin olup olmadigini assert ediniz ve "I`m contained within the box" ve
        // "I`m contained within my parent " ifadelerinin gorunur olup olamdigni test ediniz ve
        // harekeli ifadelerinin maus ile birlikte hareket edip etmediniz test ediniz.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us028Page.draggbleLink));
        us028Page.draggbleLink.click();
        ReusableMethods.waitFor(1);
        us028Page.mainTabs.get(2).click();
        Assert.assertTrue(us028Page.upperBox.isDisplayed());
        Assert.assertTrue(us028Page.downerBox.isDisplayed());
        //for upperBox
        actions.clickAndHold(us028Page.upperBox).perform();
        actions.moveByOffset(673,106).perform();
        actions.release().perform();
        Assert.assertEquals(us028Page.upperBox.getCssValue("left"),"673px");
        Assert.assertEquals(us028Page.upperBox.getCssValue("top"),"106px");
        //for downerBox
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us028Page.downerBox).perform();
        actions.moveByOffset(13,86).perform();
        actions.release().perform();
        Assert.assertEquals(us028Page.downerBox.getCssValue("left"),"13px");
        Assert.assertEquals(us028Page.downerBox.getCssValue("top"),"86px");
    }
    @Test
    public void tc168(){
        //"I will always stick to the center" ,"My cursor is at top left" ve "My cursor is at bottom"
        // ifadeli hareketli butonlari  mausla  tiklaninca  hareket edip etmedinig  test ediniz ve
        // gorunurlugunun ayni olmadigin da assert ediniz
        Set<String> myResults = new HashSet<>();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us028Page.draggbleLink));
        us028Page.draggbleLink.click();
        ReusableMethods.waitFor(1);
        us028Page.mainTabs.get(3).click();
        List<WebElement> myList = new ArrayList<>();
        myList.add(us028Page.box1);
        myList.add(us028Page.box2);
        myList.add(us028Page.box3);
        ReusableMethods.waitFor(1);
        for (WebElement w: myList) {
            actions.clickAndHold(w).perform();
            actions.moveByOffset(50,50).perform();
            actions.release().perform();
            myResults.add(w.getCssValue("left"));
            myResults.add(w.getCssValue("top"));
        }
        Assert.assertEquals(myResults.size(),6);
    }
}
