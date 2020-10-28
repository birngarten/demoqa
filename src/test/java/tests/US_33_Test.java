package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_33_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_33_Test extends TestBase {

    US_33_Page us33Page = new US_33_Page();

    @BeforeMethod
    public void brokenSetup(){
        us33Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us33Page.brokenLinksMenu)).click();

    }

    @Test
    public void TC195(){
// Broken Links - Images linkinin tıklanabildigini assert ediniz
        Assert.assertTrue(us33Page.brokenLinksMenu.isEnabled());

    }

    @Test
    public void TC196(){
// Sayfada sırasıyla Valid image, Broken image, Valid Link ve Broken Link elemanlarinin oldugunu assert ediniz
        String brokenLinkElemanlari[]= {"Valid image", "Broken image", "Valid Link", "Broken Link"};

        int i =0;
        for (WebElement w: us33Page.brokenLinkWebElementList){
            System.out.println(w.getText());
            Assert.assertEquals(w.getText(),brokenLinkElemanlari[i++]);
        }
    }

    @Test
    public void TC197(){
// Valid image ın gorutulendigini assert ediniz
        Assert.assertTrue(us33Page.validImage.isDisplayed());

    }

    @Test
    public void TC198(){
// Broken image in goruntulenmedigini assert ediniz
        Assert.assertTrue(us33Page.brokenImage.getAttribute("naturalWidth").equals("0"));

    }

    @Test
    public void TC199(){
// Valid linke tıklandiginda demoqa anasayfaya ulasildini assert ediniz
        String validLinkUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(validLinkUrl);

        ReusableMethods.waitFor(2);
        actions.click(us33Page.validLink).build().perform();

        String demoqaUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(demoqaUrl);

        Assert.assertEquals(demoqaUrl,"https://demoqa.com/");

    }

    @Test
    public void TC200() {
// Broken linke tiklandiginda Ip adresi bulunamadı hatasinin alindigini assert ediniz


    }
    }
