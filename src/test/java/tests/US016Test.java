package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US016Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US016Test {
    US016Page us016Page = new US016Page();
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc075(){
        //sayfanın başlığının "Auto Complete" olduğunu assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        Assert.assertEquals(us016Page.PageHeader.getText(),"Auto Complete");
    }
    @Test
    public void tc076(){
        //üst text başlığının "Type multiple color names" olduğunu assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        Assert.assertEquals(us016Page.upperPartText.getText(),"Type multiple color names");
    }
    @Test
    public void tc077(){
        //-Alt Text boxların başlığının "Type single color name" olduğunu assert edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        Assert.assertEquals(us016Page.downerPartText.getText(),"Type single color name");
    }
    @Test
    public void tc078(){
        //Üst Text box.a bir kaç harf yazın, bu harfleri içeren renklerin aşağıda listelendiğini asset edin
        us016Page.widgetsCard.click();
        us016Page.AutoCompleteLink.click();
        us016Page.upperPartTextBox.click();
        ReusableMethods.waitFor(1);
        us016Page.upperPartTextBox.sendKeys("red");

    }
    @Test
    public void tc079(){

    }
    @Test
    public void tc080(){

    }
    @Test
    public void tc081(){

    }
    @Test
    public void tc082(){

    }
    @Test
    public void tc083(){

    }
    @Test
    public void tc084(){

    }
    @Test
    public void tc085(){

    }
}
