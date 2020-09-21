package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US015Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US015Test {

    US015Page us015Page = new US015Page();


    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc069(){
        //Widgets menusune tiklandiginda Accordian menu linki goruldugunu assert ediniz.
        us015Page.widgetsCard.click();
        Assert.assertTrue(us015Page.accordianLink.isDisplayed());
    }
    @Test
    public void tc070(){
        //Accordian menu linki calisir oldugunu assert ediniz.
        us015Page.widgetsCard.click();
        us015Page.accordianLink.click();
        Assert.assertEquals(us015Page.pageHeader.getText(),"Accordian");
    }
    @Test
    public void tc071(){
        //Accordian menu linkine tiklanabildigini ve tiklandiginda uc adet accordion menu oldugunu
        // bunlardan ikincisi "Where does it come from?" oldugunu verify ediniz
        us015Page.widgetsCard.click();
        us015Page.accordianLink.click();
        List<WebElement> accordian = Driver.getDriver().findElements(By.xpath("//div[@class='card-header']"));
        //System.out.println(accordian.size());
        Assert.assertEquals(accordian.size(),3);
        Assert.assertEquals(accordian.get(1).getText(),"Where does it come from?");
    }
    @Test
    public void tc072(){
        //Accordion menu linkine tiklanabildigini ve tiklandiginda ilk cikan "What is Lorem Ipsum?" accordion
        // menu linkindeki textin "Lorem Ipsum is simply" ifadesini icerdigini verify ediniz
        us015Page.widgetsCard.click();
        us015Page.accordianLink.click();
        Assert.assertTrue(us015Page.textsOfOpenAccordion.getText().contains("Lorem Ipsum is simply"));
    }
    @Test
    public void tc073(){
        //ikinci accordion menu linkine tiklanabildigini ve  tiklandiginda birinci acordion menu linkinin kapandigini
        // ve ikinci acordion menu linkinin basliginin "Where does it come from?" oldugunu verify ediniz
        us015Page.widgetsCard.click();
        us015Page.accordianLink.click();
        List<WebElement> accordian = Driver.getDriver().findElements(By.xpath("//div[@class='card-header']"));
        Assert.assertTrue(us015Page.accordion1Text.isDisplayed());
        Assert.assertFalse(us015Page.accordion2Text.isDisplayed());
        accordian.get(1).click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse(us015Page.accordion1Text.isDisplayed());
        Assert.assertTrue(us015Page.accordion2Text.isDisplayed());
    }
    @Test
    public void tc074(){
        //Ucuncu accordion menu linkine tiklandigini, tiklandiginda ikinci akordion menu linkinin kapandigini ve
        // ucuncu acordion menu linkindeki Text'in Font-weight' inin 400 oldugunu verify ediniz
        us015Page.widgetsCard.click();
        us015Page.accordianLink.click();
        List<WebElement> accordian = Driver.getDriver().findElements(By.xpath("//div[@class='card-header']"));
        accordian.get(1).click();
        ReusableMethods.waitFor(1);
        accordian.get(2).click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse(us015Page.accordion2Text.isDisplayed());
        Assert.assertTrue(us015Page.accordion3Text.isDisplayed());
    }
}
