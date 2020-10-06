package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_22_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class US_22_Test extends TestBase {


    US_22_Page us22Page=new US_22_Page();
    SoftAssert soft=new SoftAssert();

    @BeforeMethod
    public void setUs22Page(){

        wait.until(ExpectedConditions.elementToBeClickable(us22Page.widgetcard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).pause(Duration.ofSeconds(2)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us22Page.menuLinki)).click();

    }

    @Test
    public void TC_119(){
        //- Sayfanın başlığı "Menu" oldugunu verify edin
        soft.assertTrue(us22Page.menuLinki.isDisplayed());
        soft.assertTrue(us22Page.menuHeadText.isDisplayed());
        soft.assertAll();
    }
    @Test
    public void TC_120(){
        ////a[@href='#']
        //@FindBy(xpath = "//ul[@id='nav']/li")
        //public List<WebElement> mainHeadList;
        //-Text boxlarin yesil renk dolgu ve beyaz yazi tipinde oldugunu assert edin
        System.out.println(us22Page.mainItem123.getText());
        for(WebElement main:us22Page.menuItems){

            String backgroundColor= ReusableMethods.getHexColor(main,"background-color");
            System.out.println(backgroundColor);
            soft.assertTrue(backgroundColor.contains("#24af15"));
            soft.assertAll();
        }

        for (WebElement yazi:us22Page.beyazYaziTips){

            String color= ReusableMethods.getHexColor(yazi,"color");
            System.out.println(color);
            soft.assertTrue(color.contains("#ffffff"));
            soft.assertAll();
        }

    }
    @Test
    public void TC_121(){

        //-Text boxların başlıklarinin "Main Item 1" , "Main Item 2" , "Main Item 3" oldugunu assert edin.

        String main[]={"Main Item 1","Main Item 2","Main Item 3"};
        int count=0;

        for (WebElement yazi:us22Page.beyazYaziTips){
            System.out.println(yazi.getText());
            soft.assertEquals(yazi.getText(),main[count]);
            count++;
            soft.assertAll();
        }


    }

    @Test
    public void TC_122(){
//-Üst Text box hover yapilinca box ici koyu yesil renk oldugunu verify edin.

        ReusableMethods.waitFor(2);
        for (WebElement w:us22Page.menuItems){
            actions.moveToElement(w).perform();
            ReusableMethods.waitFor(2);
            String groundColor=ReusableMethods.getHexColor(w,"background");
            ReusableMethods.waitFor(2);
            System.out.println(groundColor);
            soft.assertEquals(groundColor,"#03f20");
        }

        soft.assertAll();

    }

}
