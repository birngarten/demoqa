package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US010Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US010 {

    US010Page us010 = new US010Page();
    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc043(){
        us010.alersFrameAndWindows.click();
        ReusableMethods.waitFor(1);
        //us010.browserWindows.click();
        Assert.assertTrue(us010.browserWindows.isDisplayed());
    }
    @Test
    public void tc(){
        us010.alersFrameAndWindows.click();
        System.out.println(Driver.getDriver().findElement(By.id("item-0")).getText());
        //olmadi
    }
}
