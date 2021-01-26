package testsDemoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US022Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US022Test {
        US022Page us022Page = new US022Page();
    @BeforeMethod
    public void startUp(){
        Driver.getDriver().get("https://demoqa.com/");
    }
    @Test
    public void tc119(){
        //- Sayfanın başlığı "Menu" oldugunu verify edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        Assert.assertEquals(us022Page.pageHeader.getText(),"Menu");
    }
    @Test
    public void tc120(){
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
    public void tc121(){
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
    public void tc122(){
        //-Üst Text box hover yapilinca box ici koyu yesil renk oldugunu verify edin.
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        actions.moveToElement(us022Page.mainBoxesLinks.get(0)).perform();
        String backGroungColor = Color.fromString(us022Page.greenBackGround.getCssValue("background-color")).asHex();
        Assert.assertEquals(backGroungColor,"#003f20");

    }
    @Test
    public void tc123(){
        //-Üst Text box 2 hover yapilinca 3 adet sub Text Box asagiya acildigini assert edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        actions.moveToElement(us022Page.mainBoxesLinks.get(1)).perform();
        List<WebElement> subLİnks = Driver.getDriver().findElements(By.xpath("//a[.='Sub Item']"));
        subLİnks.add(Driver.getDriver().findElement(By.xpath("//a[.='SUB SUB LIST »']")));
        Assert.assertTrue(subLİnks.size()==3);
        for (WebElement w:subLİnks
             ) {
            Assert.assertTrue(w.isEnabled());
        }
    }
    @Test
    public void tc124(){
        //-Sirasiyla isimleri "Sub Item", "Sub Item" ve "SUB SUB LIST »" seklinde goruldugunu assert edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        actions.moveToElement(us022Page.mainBoxesLinks.get(1)).perform();
        List<WebElement> subLİnks = Driver.getDriver().findElements(By.xpath("//a[.='Sub Item']"));
        subLİnks.add(Driver.getDriver().findElement(By.xpath("//a[.='SUB SUB LIST »']")));
        Assert.assertEquals(subLİnks.get(0).getText(),"Sub Item");
        Assert.assertEquals(subLİnks.get(1).getText(),"Sub Item");
        Assert.assertEquals(subLİnks.get(2).getText(),"SUB SUB LIST »");
    }
    @Test
    public void tc125(){
        //-"SUB SUB LIST »" Sub Text Box hover yapildiginda koyu yesil renk oldugunu
        // ve sag tarafa 2 adet Sub Sub Text Box acildigini assert edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        actions.moveToElement(us022Page.mainBoxesLinks.get(1)).perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='SUB SUB LIST »']"))).perform();
        List<WebElement>subSubİtems = Driver.getDriver().findElements(By.xpath("//a[.='Sub Sub Item 1']"));
        subSubİtems.add(Driver.getDriver().findElement(By.xpath("//a[.='Sub Sub Item 2']")));
        Assert.assertEquals(subSubİtems.size(),2);
    }
    @Test
    public void tc126(){
        //-Isimlerinin sirasiyla "Sub Sub Item 1" ve"Sub Sub Item 2" seklinde goruldugunu verify edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        actions.moveToElement(us022Page.mainBoxesLinks.get(1)).perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='SUB SUB LIST »']"))).perform();
        List<WebElement>subSubİtems = Driver.getDriver().findElements(By.xpath("//a[.='Sub Sub Item 1']"));
        subSubİtems.add(Driver.getDriver().findElement(By.xpath("//a[.='Sub Sub Item 2']")));
        Assert.assertEquals(subSubİtems.get(0).getText(),"Sub Sub Item 1");
        Assert.assertEquals(subSubİtems.get(1).getText(),"Sub Sub Item 2");
    }
    @Test
    public void tc127(){
        //-Sub Sub Text Box'larin hover edildiginde koyu yesil renk aldigini assert edin
        us022Page.widgetsCard.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us022Page.MenuLink.click();
        actions.moveToElement(us022Page.mainBoxesLinks.get(1)).perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='SUB SUB LIST »']"))).perform();

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='Sub Sub Item 1']"))).perform();
        String backGroungColor = Color.fromString(us022Page.dunkelGrun2.getCssValue("background-color")).asHex();
        Assert.assertEquals(backGroungColor,"#003f20");
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='Sub Sub Item 2']"))).perform();
        String backGroungColor2 = Color.fromString(us022Page.dunkelGrun3.getCssValue("background-color")).asHex();
        Assert.assertEquals(backGroungColor2,"#003f20");
    }
}
