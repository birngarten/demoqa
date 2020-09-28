package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_16_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_16_Test extends TestBase {

    US_16_Page us16Page = new US_16_Page();

    @BeforeMethod
    public void start(){

        us16Page.wigdedsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us16Page.autoCompleteMenuLink));
        us16Page.autoCompleteMenuLink.click();
    }

    @Test
    public void TC_074(){
//        sayfanın başlığının "Auto Complete" olduğunu assert edin
        Assert.assertTrue(us16Page.AutoCompleteHeaderText.isDisplayed());

    }
    @Test
    public void TC_075(){
//        üst text başlığının "Type multiple color names" olduğunu assert edin



    }

}
