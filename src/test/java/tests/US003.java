package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US003 {
    DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc011(){
        demoqaPage.elementsCard.click();
        Assert.assertTrue(demoqaPage.radioButton.isDisplayed());
    }
    @Test
    public void tc012(){
        demoqaPage.elementsCard.click();
        demoqaPage.radioButton.click();
        Assert.assertTrue(demoqaPage.elementPageHeader.getText().equals("Radio Button"));
    }
    @Test
    public void tc013(){
        demoqaPage.elementsCard.click();
        demoqaPage.radioButton.click();
        Assert.assertTrue(demoqaPage.radioImpressive.isEnabled());
        Assert.assertTrue(demoqaPage.radioYes.isEnabled());
    }
    @Test
    public void tc014(){
        demoqaPage.elementsCard.click();
        demoqaPage.radioButton.click();
        demoqaPage.radioYes.click();
        ReusableMethods.waitFor(2);
        demoqaPage.radioImpressive.click();
    }
}
