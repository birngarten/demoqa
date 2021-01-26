package testsDemoqa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.DemoqaPage;
import pagesDemoqa.UploadDynamicPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US008Test {
    UploadDynamicPage uploadDynamicPage = new UploadDynamicPage();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }

    @Test
    public void tc032(){
        DemoqaPage demoqaPage = new DemoqaPage();
        uploadDynamicPage.element.click();
        ReusableMethods.waitFor(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        uploadDynamicPage.dynamicProperties.click();
        String idValue = uploadDynamicPage.dynamicText.getAttribute("id");
        List<String> idValues = new ArrayList<>();
        for(int i=1;i<11;i++){
//            Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
//            demoqaPage.elementsCard.click();
//            ReusableMethods.waitFor(1);
//            uploadDynamicPage.dynamicProperties.click();
                Driver.getDriver().navigate().refresh();
            String idValue2 = uploadDynamicPage.dynamicText.getAttribute("id");
            if(!idValue.equals(idValue2)) {
                idValues.add(idValue2);
            }
            ReusableMethods.waitFor(2);
        }
        System.out.println(idValues);
        Assert.assertEquals(10,idValues.size());
    }
    @Test
    public void tc033(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        uploadDynamicPage.dynamicProperties.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(!uploadDynamicPage.enableAfterButton.isEnabled());
        ReusableMethods.waitFor(5);
        Assert.assertTrue(uploadDynamicPage.enableAfterButton.isEnabled());
    }
    @Test
    public void tc034(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        uploadDynamicPage.dynamicProperties.click();
//        System.out.println(uploadDynamicPage.colorChangeButton.getCssValue("color"));
//        Assert.assertTrue(uploadDynamicPage.colorChangeButton.getCssValue("color").equals("#fff"));
//        ReusableMethods.waitFor(6);
//        Assert.assertTrue(uploadDynamicPage.colorChangeButton.getCssValue("color").equals("#dc3545"));
    }
    @Test
    public void tc035(){
        DemoqaPage demoqaPage = new DemoqaPage();
        demoqaPage.elementsCard.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(1);
        uploadDynamicPage.dynamicProperties.click();
        //Assert.assertFalse(uploadDynamicPage.visibleAfterButton.isDisplayed());
        ReusableMethods.waitFor(5);
        Assert.assertTrue(uploadDynamicPage.visibleAfterButton.isEnabled());
    }
}
