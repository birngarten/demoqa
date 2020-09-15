package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US010Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US011 {
    US010Page us010 = new US010Page();

    @BeforeTest
    public void stars() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc049(){
        us010.alersFrameAndWindows.click();
        Assert.assertTrue(us010.alerts.isDisplayed());
    }
    @Test
    public void tc050(){
        us010.alersFrameAndWindows.click();
        us010.alerts.click();
        List<WebElement> buttons = new ArrayList<>();
        buttons.add(us010.firstButton);
        buttons.add(us010.secondButton);
        buttons.add(us010.thirdButton);
        buttons.add(us010.forthButton);
        for(WebElement w :buttons){
            Assert.assertTrue(w.isEnabled());
        }
        Assert.assertEquals(buttons.size(),4);
    }
    @Test
    public void tc051(){
//        us010.alersFrameAndWindows.click();
//        us010.alerts.click();
//        us010.firstButton.click();
//        // yapamadik
    }
    @Test
    public void tc052(){
//        us010.alersFrameAndWindows.click();
//        us010.alerts.click();
//        us010.secondButton.click();
//        ReusableMethods.waitFor(5);
//        Driver.getDriver().switchTo().alert().accept();
    }
    @Test
    public void tc053(){
    }
    @Test
    public void tc054(){
    }
}
