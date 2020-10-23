package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_28_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class US_28_Test extends TestBase {

    US_28_Page us28Page = new US_28_Page();

    @BeforeMethod
    public void setUs28Page() {

        wait.until(ExpectedConditions.elementToBeClickable(us28Page.interactionsCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();


    }

    @Test
    public void TC_161() {
        //Dragable  linkine tiklayiniz ve  fonktionel olup olmadigini  test ediniz
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink));
        Assert.assertTrue(us28Page.dragabbleMenuLink.isEnabled());
    }

    @Test
    public void TC_162() {
        //Sayfanin  ana basligi  Dragabble  ifadesi oldugnu test ediniz ve
        // arka planin da olup olmadigini test ediniz
        wait.until(ExpectedConditions.visibilityOf(us28Page.dragabbleMenuLink)).click();
        Assert.assertEquals(us28Page.dragabbleHeaderText.getText(), "Dragabble");

        String backgroundImageUrl = us28Page.dragabbleHeaderTextBg.getCssValue("background-image");
        System.out.println(backgroundImageUrl);

        Assert.assertTrue(backgroundImageUrl.contains("gplaypattern"));


    }

    @Test
    public void TC_163() {
        // Sayfanin Title nin  Qa olmadgini test ediniz .
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink)).click();
        String actualPageTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(actualPageTitle.equals("Qa"));
    }

    @Test
    public void TC_164() {
        // Sayfada ki " Simpe, Axis Restricted,Container Restricted ,Cursor Style"
        // linklerinin gorunumu ve  islevsel olup olmadigini test ediniz
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink)).click();
        System.out.println(us28Page.dragabbleTabList.size());

        for (WebElement w : us28Page.dragabbleTabList) {
            Assert.assertTrue(w.isDisplayed() & w.isEnabled());
        }


    }

    @Test
    public void TC_165() {
        //  Drag me elementinin  sayfada  maus ile birlikte  haret ettirebilmesini test ediniz

        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink)).click();
        wait.until(ExpectedConditions.visibilityOf(us28Page.dragBox));

        Point dragBoxFirstLocation = us28Page.dragBox.getLocation();
        System.out.println(dragBoxFirstLocation);

        actions.clickAndHold(us28Page.dragBox).moveByOffset(50, 50).build().perform();
//        actions.moveToElement(us28Page.dragBox,50,50).build().perform();
        ReusableMethods.waitFor(2);

        Point dragBoxSecondLocation = us28Page.dragBox.getLocation();
        System.out.println(dragBoxSecondLocation);

        Assert.assertNotEquals(dragBoxFirstLocation, dragBoxSecondLocation);

    }

    @Test
    public void TC_166() {
        // " Only X" yatay sekilde  hareketini ve "Only Y"ninde  dikey sekilde hareket ettigini test ediniz

        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink)).click();
        us28Page.dragabbleTabList.get(1).click();

        boolean xMove = US_28_Page.isMoveAndCheckLocation(us28Page.dragBoxX, "x", 200, 100);
        Assert.assertTrue(xMove);

        boolean yMove = US_28_Page.isMoveAndCheckLocation(us28Page.dragBoxY, "y", 200, 100);
        Assert.assertTrue(yMove);

//        int xDragBoxFirstLocationX = us28Page.dragBoxX.getLocation().x;
//        int xDragBoxFirstLocationY = us28Page.dragBoxX.getLocation().y;
//        System.out.println(xDragBoxFirstLocationY);
//
//        actions.clickAndHold(us28Page.dragBoxX).moveByOffset(200,100).build().perform();
//        wait.until(ExpectedConditions.attributeContains(us28Page.dragBoxX,"style","left"));
//
//        int xDragBoxLastLocationX = us28Page.dragBoxX.getLocation().x;
//        int xDragBoxLastLocationY = us28Page.dragBoxX.getLocation().y;
//
//        Assert.assertNotEquals(xDragBoxFirstLocationX,xDragBoxLastLocationX);
//        Assert.assertTrue(xDragBoxLastLocationY==xDragBoxFirstLocationY);

//        int yDragBoxFirstLocationX = us28Page.dragBoxY.getLocation().x;
//        int yDragBoxFirstLocationY = us28Page.dragBoxY.getLocation().y;
//
//        actions.clickAndHold(us28Page.dragBoxY).moveByOffset(100,200).build().perform();
//        wait.until(ExpectedConditions.attributeContains(us28Page.dragBoxY,"style","left"));
//
//        int yDragBoxLastLocationX = us28Page.dragBoxY.getLocation().x;
//        int yDragBoxLastLocationY = us28Page.dragBoxY.getLocation().y;
//
//        Assert.assertNotEquals(yDragBoxFirstLocationY,yDragBoxLastLocationY);
//        Assert.assertTrue(yDragBoxLastLocationX==yDragBoxFirstLocationX);

    }


    @Test
    public void TC_167() {
        //  iki farkli  hareket alaninin olup olmadigini assert ediniz ve
        //  "I`m contained within the box" ve "I`m contained within my parent " ifadelerinin
        //  gorunur olup olamdigni test ediniz ve
        //  harekeli ifadelerinin maus ile birlikte hareket edip etmediniz test ediniz.
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleTabList.get(2))).click();

        Assert.assertTrue(us28Page.firstMoveArea.isEnabled() & us28Page.secondMoveArea.isEnabled());
        String actualFirstText = us28Page.firstMoveArea.getText();
        String actualSecondText = us28Page.secondMoveArea.getText();

        System.out.println(actualFirstText);
        System.out.println(actualSecondText);

        Assert.assertFalse(actualFirstText.isEmpty() & actualSecondText.isEmpty());

        boolean isMoveFirstElement = US_28_Page.isMoveAndCheckLocation(us28Page.firstMoveAreaElement, "xy", 200, 200);
        Assert.assertTrue(isMoveFirstElement);

        boolean isMoveSecondElement = US_28_Page.isMoveAndCheckLocation(us28Page.secondMoveAreaElement, "xy", 5, 50);
        Assert.assertTrue(isMoveSecondElement);

    }

    @Test
    public void TC_168() {
        // "I will always stick to the center" , "My cursor is at top left" ve "My cursor is at bottom"
        // ifadeli hareketli butonlari  mausla  tiklaninca  hareket edip etmedinigini
        // test ediniz ve gorunurlugunun ayni olmadigin da assert ediniz

        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleMenuLink)).click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        wait.until(ExpectedConditions.elementToBeClickable(us28Page.dragabbleTabList.get(3)));
        js.executeScript("arguments[0].click()",us28Page.dragabbleTabList.get(3));

        for (WebElement w : us28Page.cursorTypeBoxList) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            String cursorType = w.getCssValue("cursor");
            System.out.println("Hareket etmeden once: " + cursorType);

            wait.until(ExpectedConditions.visibilityOfAllElements(us28Page.cursorTypeBoxList));
            actions.clickAndHold(w).moveByOffset(50, 50).build().perform();

            cursorType = us28Page.pageBody.getCssValue("cursor");
            System.out.println("Hareket ettikten sonra: " + cursorType);
            System.out.println("====================");

            boolean isMove = US_28_Page.isMoveAndCheckLocation(w, "xy", -50, -50);
            Assert.assertTrue(isMove);
        }


    }


}
