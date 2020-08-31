package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ReusableMethods;
import utilities.TestBase;

public class ElementsTest01 extends TestBase {

    @Test
    public void textbox01() {
        demoqaPage.elementsCard.click();
        demoqaPage.elementsMenu.click();
        ReusableMethods.waitFor(2);
        Assert.assertFalse(demoqaPage.textBoxMenuLink.isDisplayed());
        demoqaPage.elementsMenu.click();

    }

}
