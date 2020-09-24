package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US013Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;

public class US013Test {

    US013Page us013Page = new US013Page();
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc058(){
        //Alerts, Frame & Windows menusune tiklandiginda Nested Frames menu linki calistigini verify ediniz.
        us013Page.alertsFrameWinwowsCard.click();
        Assert.assertTrue(us013Page.nestedFrameLink.isEnabled());
    }
    @Test
    public void tc059(){
        //Nested Frames menu linkine tiklandiginda acilan sayfada 2 adet Iframe oldugunu assert ediniz.
        us013Page.alertsFrameWinwowsCard.click();
        us013Page.nestedFrameLink.click();
        List<WebElement> iframes = Driver.driver.findElements(By.xpath("//iframe"));
        Driver.getDriver().switchTo().frame(iframes.get(0));
        for(int i=0;i<10;i++){
            iframes.add(Driver.getDriver().findElement(By.xpath("//iframe")));
            if(iframes.size()!=i+1){
                break;
            }
        }

//        for (WebElement w:iframes) {
//            Driver.getDriver().switchTo().frame(w);
//            iframes.add(Driver.getDriver().findElement(By.xpath("//iframe")));
//        }

        Assert.assertEquals(iframes.size(),2);
    }
    @Test
    public void tc060() {
        //Parent Frame den Child Frame gecis yapmadan "Child Iframe" text i assert edilemez
        String text="";
        us013Page.alertsFrameWinwowsCard.click();
        us013Page.nestedFrameLink.click();
        try {
            text = us013Page.chilFrameText.getText();
        } catch (org.openqa.selenium.NoSuchElementException e){
            Assert.assertEquals(text,"");
        }
    }
    @Test
    public void tc061(){
        //Nested Frames menu linkine tiklandiginda "Parent frame" Text ini assert ediniz.
        us013Page.alertsFrameWinwowsCard.click();
        us013Page.nestedFrameLink.click();
        Driver.driver.switchTo().frame("frame1");
        String frameText = us013Page.parentFrameText.getText();
        Assert.assertEquals(frameText,"Parent frame");
    }
    @Test
    public void tc062(){
        //Nested Frames menu linkine tiklandiginda "Child Iframe"  ifadesini assert ediniz.
        us013Page.alertsFrameWinwowsCard.click();
        us013Page.nestedFrameLink.click();
        Driver.driver.switchTo().frame("frame1");
        ReusableMethods.waitFor(1);
        Driver.driver.switchTo().frame(us013Page.childFrame);
        String frameText = Driver.getDriver().findElement(By.xpath("//p")).getText();
        Assert.assertEquals(frameText,"Child Iframe");
    }
    @Test
    public void tc063(){
        //Nested Frames menu linkine tiklandiginda Default Iframe deki "Sample Nested" ile baslayan Text in yazi rengi #212529 oldugunu assert ediniz.
        us013Page.alertsFrameWinwowsCard.click();
        us013Page.nestedFrameLink.click();
        String textColorCode = Color.fromString(us013Page.mainPageText.getCssValue("color")).asHex();
        Assert.assertEquals(textColorCode,"#212529");
    }
}
