package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US022Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US022Test {
        US022Page us022Page = new US022Page();
    @BeforeMethod
    public void startUp(){
        Driver.getDriver().get("https://demoqa.com/");
    }
    @Test
    public void tc001(){
        //- Sayfanın başlığı "Menu" oldugunu verify edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        Assert.assertEquals(us022Page.pageHeader.getText(),"Menu");
    }
    @Test
    public void tc002(){
        //-Text boxlarin yesil renk dolgu ve beyaz yazi tipinde oldugunu assert edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        for (WebElement w: us022Page.mainBoxesLinks) {
            String textColor = Color.fromString(w.getCssValue("color")).asHex();
            Assert.assertEquals(textColor,"#ffffff");
        }
        String backGroungColor = Color.fromString(us022Page.greenBackGround.getCssValue("background-color")).asHex();
        System.out.println(backGroungColor);
        Assert.assertEquals(backGroungColor,"#24af15");
    }
    @Test
    public void tc003(){
        //-Text boxların başlıklarinin "Main Item 1" , "Main Item 2" , "Main Item 3" oldugunu assert edin.
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        Assert.assertEquals(us022Page.mainBoxesLinks.get(0).getText(),"Main Item 1");
        Assert.assertEquals(us022Page.mainBoxesLinks.get(1).getText(),"Main Item 2");
        Assert.assertEquals(us022Page.mainBoxesLinks.get(2).getText(),"Main Item 3");
    }
    @Test
    public void tc004(){
        //-Üst Text box hover yapilinca box ici k  oyu yesil renk oldugunu verify edin.
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        //eksik kaldi
    }
}
