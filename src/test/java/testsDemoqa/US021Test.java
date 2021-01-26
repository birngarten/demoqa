package testsDemoqa;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US021Page;
import utilities.Driver;

public class US021Test {
    US021Page us021Page = new US021Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://demoqa.com/tool-tips");
    }
    @Test
    public void tc112(){
        //Sayfanin basliginin "Tool Tips "oldugunu assert edin.
        Assert.assertEquals(us021Page.pageHeader.getText(),"Tool Tips");
    }
    @Test
    public void tc113(){
        //Ust textte "Practice Tool Tips" yazdigini assert edin
        Assert.assertEquals(us021Page.buttonHeader.getText(),"Practice Tool Tips");
    }
    @Test
    public void tc114(){
        //Button yesil renk dolgulu ve beyaz yazi tipinde oldugunu assert edin
        Assert.assertEquals(Color.fromString(us021Page.hoverMeToSeeButton.getCssValue("color")).asHex(),"#ffffff");
        Assert.assertEquals(Color.fromString(us021Page.hoverMeToSeeButton.getCssValue("background-color")).asHex(),"#28a745");
    }
    @Test
    public void tc115(){
        //Text box basligi " Hover me to see" olmali assert edin
        Assert.assertEquals(us021Page.hoverMeToSeeButton.getText(),"Hover me to see");
    }
    @Test
    public void tc116(){
        //Mouse Text box basligi üzerine geldiginde "You hovered over the Button"
        // yazisi siyah renk dolgulu box icinde ve beyaz yazi tipinde oldugunu assert edin.
        actions.moveToElement(us021Page.hoverMeToSeeButton).perform();
        Assert.assertEquals(us021Page.afterHoverText.getText(),"You hovered over the Button");
        Assert.assertEquals(Color.fromString(us021Page.afterHoverText.getCssValue("color")).asHex(),"#ffffff");
        Assert.assertEquals(Color.fromString(us021Page.afterHoverText.getCssValue("background-color")).asHex(),"#000000");
    }
    @Test
    public void tc117(){
        //Hover me to see basligi altinda "bos text kutusu " ve altinda bir metin oldugunu assert edin
    }
    @Test
    public void tc118(){
        //Metnin icinde "Contrary ve 1.10.32  bilgilerini icerdigini assert edin
        Assert.assertTrue(us021Page.fullTextBox.getText().contains("Contrary"));
        Assert.assertTrue(us021Page.fullTextBox.getText().contains("1.10.32"));
    }
}
