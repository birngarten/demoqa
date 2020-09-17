package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_09_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_09_Test extends TestBase {
    US_09_Page us09Page=new US_09_Page();

    @BeforeMethod
    public  void setup1(){
        us09Page.formsMenuCard.click();
    }

    @Test
    public void TC_036() {
        //Forms altindaki Practice Form sayfasina ulasilabilirligi dogrulayin
       // ReusableMethods.waitFor(1);
        Assert.assertTrue(us09Page.practiceFormMenuLink.isEnabled());
    }

    @Test
    public void TC_037() {
        //Student Registration Formdaki  Name,  Gender, Date of Birth, Mobile bolumleri bos birakildiginda
        // Submit yapilamadigini dogrulayin

        us09Page.practiceFormMenuLink.click();
        //actions.click(us09Page.practiceFormMenuLink).perform();

        us09Page.userEmail.sendKeys("Can@gmail.com");
        us09Page.subject.sendKeys("deneme");
       // us09Page.hobiSpor.click();  //tiklamiyor
        actions.click(us09Page.hobiSpor).perform();
    }
}
