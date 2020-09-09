package tests;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_05_Page;
import utilities.TestBase;

public class US_05_Test extends TestBase {
    US_05_Page us_05_page=new US_05_Page();

    @Test
    public void TC022() {
        us01Page.elementsCard.click();
        us_05_page.buttonsMenuLink.click();
        String fontHeader=us_05_page.buttonsHeaderText.getCssValue("font-weight");
        Assert.assertEquals(fontHeader,"300");
    }

    @Test
    public void TC023() {
        us01Page.elementsCard.click();
        us_05_page.buttonsMenuLink.click();
        Assert.assertTrue(us_05_page.doubleClickButton.isDisplayed());
        Assert.assertTrue(us_05_page.rightClickButton.isDisplayed());
        Assert.assertTrue(us_05_page.clickMeButton.isDisplayed());
    }

    @Test
    public void TC024() {
        us01Page.elementsCard.click();
        us_05_page.buttonsMenuLink.click();
        actions.doubleClick(us_05_page.doubleClickButton).perform();
        actions.contextClick(us_05_page.rightClickButton).perform();
        actions.click(us_05_page.clickMeButton).perform();
        Assert.assertEquals(us_05_page.doubleClickMessage.getText(),"You have done a double click");
        Assert.assertEquals(us_05_page.rightClickMessage.getText(),"You have done a right click");
        Assert.assertEquals(us_05_page.dynamicClickMessage.getText(),"You have done a dynamic click");
    }

    @Test
    public void TC025() {
    }
}
