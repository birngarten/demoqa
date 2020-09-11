package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_08_Page;
import utilities.Driver;
import utilities.TestBase;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class US_08_Test extends TestBase {

    US_08_Page us08Page=new US_08_Page();

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

        List<String> randomList=new ArrayList<>();

        int j =0;
        for (int i=1; i<4; i++){
           String idValue=us08Page.randomText.getAttribute("id");
            System.out.println(idValue);
            if(!randomList.contains(idValue)){
                randomList.add(idValue);
                j++;
            }
            Driver.getDriver().navigate().refresh();
        }
        Assert.assertEquals(randomList.size(),j);  //2.yol ile
        //Assert.assertEquals(randomList.size(),3);  //1.yol ile j olmadan
    }

    @Test
    public void TC_033() {
        //Wil enable 5 seconds isimli buton sayfa acildiginda Disabled oldugunu ve
        // 5 sn sonra Enabled oldugunu dogrulayin
        us08Page.dynamicPropertiesMenuLink.click();

        Assert.assertFalse(us08Page.enableButton.isEnabled());

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(us08Page.enableButton));
        Assert.assertTrue(us08Page.enableButton.isEnabled());
    }

}
