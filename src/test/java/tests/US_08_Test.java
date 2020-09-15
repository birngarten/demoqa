package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_08_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class US_08_Test extends TestBase {

    US_08_Page us08Page = new US_08_Page();

    @BeforeMethod
    public void setup2() {
        us01Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    @Test
    public void TC_31() {
        //Elements altindaki Dynamic Properties sayfasina ulasilir oldugunu dogrulayin
        us08Page.dynamicPropertiesMenuLink.isEnabled();

    }

    @Test
    public void TC_32() {
        //This text has random Id isimli Text Box sayfa her yenilendiginde farkli bir
        // ID value'sune sahip oldugunu dogrulayin
        us08Page.dynamicPropertiesMenuLink.click();

        List<String> randomList = new ArrayList<>();

        int j = 0;
        for (int i = 1; i < 4; i++) {
            String idValue = us08Page.randomText.getAttribute("id");
            System.out.println(idValue);
            if (!randomList.contains(idValue)) {
                randomList.add(idValue);
                j++;
            }
            Driver.getDriver().navigate().refresh();
        }
        Assert.assertEquals(randomList.size(), j);  //2.yol ile
        //Assert.assertEquals(randomList.size(),3);  //1.yol ile j olmadan
    }

    @Test
    public void TC_033() {
        //Wil enable 5 seconds isimli buton sayfa acildiginda Disabled oldugunu ve
        // 5 sn sonra Enabled oldugunu dogrulayin
        us08Page.dynamicPropertiesMenuLink.click();

        Assert.assertFalse(us08Page.enableButton.isEnabled());

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(us08Page.enableButton));
        Assert.assertTrue(us08Page.enableButton.isEnabled());
    }

    @Test
    public void TC_034() {
        //Color Change isimli butonun yazi renginin sayfa yuklendiginde "#fff" ve 5 sn sonra "#dc3545" oldugunu dogrulayin
        us01Page.elementsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us08Page.dynamicPropertiesMenuLink.click();
        String color1 = us08Page.colorChangeButton.getCssValue("color");
        System.out.println(color1);
        String colorHex = Color.fromString(color1).asHex();
        System.out.println(colorHex);
        Assert.assertEquals(colorHex, "#ffffff");
        ReusableMethods.waitFor(5);
        String color2 = us08Page.colorChangeButton.getCssValue("color");
        // ReusableMethods.waitFor(2);  //gerekirse wait ekelenebilir
        System.out.println(color2);
        String colorHex2 = Color.fromString(color2).asHex();
        System.out.println(colorHex2);
        Assert.assertEquals(colorHex2, "#dc3545");
    }

    @Test
    public void TC_035() {
        //Visible After 5 Seconds isimli butonun sayfa yuklendiginde goruntulenemez oldugunu ve
        // 5 sn sonra goruntulenebilir oldugunu dogrulayin
        us08Page.dynamicPropertiesMenuLink.click();
        boolean isNotDisplayed = false;
        try {
            us08Page.visibleButton.isDisplayed();
        } catch (NoSuchElementException e) {
            // System.out.println("Goruntulenemiyor. Boyle bir eleman yok");
            isNotDisplayed = true;
        }
        System.out.println(isNotDisplayed);
        Assert.assertTrue(isNotDisplayed);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(us08Page.visibleButton));
        Assert.assertTrue(us08Page.visibleButton.isDisplayed());
    }

}
