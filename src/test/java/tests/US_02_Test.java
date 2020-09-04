package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_02_Page;
import utilities.TestBase;

public class US_02_Test extends TestBase {

    US_02_Page us02Page = new US_02_Page();

    @Test
    public void TC_05() {
        us01Page.elementsCard.click();
        Assert.assertTrue(us02Page.checkboxMenuLink.isDisplayed());
    }

    @Test
    public void TC_06() {
        us01Page.elementsCard.click();
        us02Page.checkboxMenuLink.click();
        Assert.assertTrue(us02Page.checkBoxHeader.isDisplayed());
    }

    @Test
    public void TC_07() {


    }

    @Test
    public void TC_08() {
        // Samet beyden alinacak.
    }

    @Test
    public void TC_09() {
        //Samet Beyden alinacak
    }

    @Test
    public void TC_10() {
        //Samet Beyden alinacak
    }
}
