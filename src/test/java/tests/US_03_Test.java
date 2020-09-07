package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_Page;
import utilities.Driver;
import utilities.TestBase;

public class US_03_Test extends TestBase {

    US_03_Page us03Page = new US_03_Page();

    @Test
    public void TC_11() {
        us01Page.elementsCard.click();
        Assert.assertTrue(us03Page.radioButtonMenuLink.isDisplayed());
    }

    @Test
    public void TC_12() {
        us01Page.elementsCard.click();
        us03Page.radioButtonMenuLink.click();
        Assert.assertTrue(us03Page.radioButtonHeader.isDisplayed());
    }

    @Test
    public void TC_13() {
        us01Page.elementsCard.click();
        us03Page.radioButtonMenuLink.click();
//        Assert.assertTrue(us03Page.yesRadioButton.isEnabled());
//        Assert.assertTrue(us03Page.impressiveRadioButton.isEnabled());
        for (WebElement w : us03Page.allRadioButton()) {
            Assert.assertTrue(w.isEnabled());
        }

        Assert.assertFalse(us03Page.noRadioButton.isEnabled());
    }

    @Test
    public void TC_14() {
        us01Page.elementsCard.click();
        us03Page.radioButtonMenuLink.click();

        for (WebElement w : us03Page.allRadioButton()) {
//            actions.click(w).perform();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();",w);
        }

    }

    @Test
    public void TC_15() {
        us01Page.elementsCard.click();
        us03Page.radioButtonMenuLink.click();

        for (WebElement w : us03Page.allRadioButton()) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();",w);
            Assert.assertTrue(us03Page.succesText.isDisplayed());
            System.out.println("Secilidigi zaman cikan yazi: " + us03Page.succesText.getText());
        }

    }
}
