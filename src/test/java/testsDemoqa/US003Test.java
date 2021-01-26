package testsDemoqa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US003Test extends TestBase {
    DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeMethod
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
        Assert.assertTrue(demoqaPage.PageHeader.getText().equals("Radio Button"));
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
