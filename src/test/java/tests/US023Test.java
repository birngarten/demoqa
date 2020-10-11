package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US023Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class US023Test {
    US023Page us023Page = new US023Page();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
        us023Page.widgetsCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us023Page.selectMenuLink.click();
        ReusableMethods.waitFor(2);
    }
    @Test
    public void tc128(){
        //- Sayfanın başlığınin"Select Menu" oldugunu verify edin
        Assert.assertEquals(us023Page.pageHeader.getText(),"Select Menu");
    }
    @Test
    public void tc129(){
        //-Sayfada ilk olarak "Select Value" adi altinda "Select Option" adli box icinde Dropdown menu tiklandiginda acilmalidir
        // ve takibinde menudeki secenekler secilebilmelidir. (Assert)
        us023Page.firstDropbox.click();
        ReusableMethods.waitFor(1);
        String myArray [] = {"Group 1, option 1","Group 1, option 2","Group 2, option 1",
                "Group 2, option 2","A root option","Another root option" };
        for(int i=0; i<myArray.length;i++){
            us023Page.firstDropbox.click();
                ReusableMethods.waitFor(1);
                actions.sendKeys(Keys.ARROW_DOWN).perform();
                actions.sendKeys(Keys.ENTER).perform();
            System.out.println(us023Page.result.getText());
            System.out.println("array "+myArray[i]);
            Assert.assertEquals(us023Page.result.getText(),myArray[i]);
        }
    }
    @Test
    public void tc130(){
        //-Sayfada ikinci olarak "Select One" adi altinda "Select Title" adli box icinde Dropdown menu tiklandiginda acilmalidir
        // ve takibinde menudeki secenekler secilebilmelidir.(Assert)
        us023Page.secondDropbox.click();
        ReusableMethods.waitFor(1);
        String myArray [] = {"Dr.","Mr.","Mrs.",
                "Ms.","Prof.","Other" };
        for(int i=0; i<myArray.length;i++){
            us023Page.secondDropbox.click();
            ReusableMethods.waitFor(1);

            actions.sendKeys(Keys.ARROW_DOWN).perform();

            actions.sendKeys(Keys.ENTER).perform();
//            System.out.println(us023Page.result.getText());
//            System.out.println(myArray[i]);
            Assert.assertEquals(us023Page.result.getText(),myArray[i]);
        }
    }
    @Test
    public void tc131(){
        //-Sayfada ucuncu olarak "Old Style Select Menu" adi altinda "Red" adli box icinde Dropdown menu tiklandiginda acilmalidir
        //ve takibinde menudeki secenekler secilebilmelidir.(Assert)
        us023Page.colorDropbox.click();
        Select options = new Select(us023Page.colorDropbox);
        List<WebElement> listOfColors = options.getOptions();
        for (WebElement w : listOfColors) {
            Assert.assertTrue(w.isEnabled());
            //System.out.println(w.getText());
        }
    }
    @Test
    public void tc132(){
        //-Sayfada dorduncu olarak "Multiselect drop down" adi altinda "Select..." adli box icinde Dropdown menu tiklandiginda
        // acilmalidir ve takibinde menudeki secenekler secilebilmelidir.(Assert)
        us023Page.multiSelectBox.click();
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        String myArray [] = {"Green","blue","black","red"};
        List<String>result = new ArrayList<>();
        for(int i=0;i<5;i++){
            ReusableMethods.waitFor(1);
            actions.sendKeys(Keys.ENTER).perform();
//            result.add(us023Page.multiSelectResult.getText());
        }
        System.out.println(result);
    }
    @Test
    public void tc133(){
        //-Sayfada son olarak "Standard multi select" adi altinda alt alta "Volvo", "Saab","Opel" ve "Audi" secenekleri bulunmali
        //ve secenekler secilebilmelidir. (Assert)
        List<WebElement> options = new ArrayList<>();
        for(int i=12;i<16;i++){
            ReusableMethods.waitFor(1);
            options.add((Driver.getDriver().findElement(By.xpath("(//option)["+i+"]"))));
        }
        for (WebElement w :options) {
            actions.clickAndHold(w).perform();
            Assert.assertTrue(w.isEnabled());
        }
    }
    @Test
    public void tc134(){
        //-"Multiselect drop down" ve "Standard multi select" basliklarinin bold oldugunu verify edin.
        for (WebElement w:us023Page.multiAndStandartTitles ) {
            Assert.assertEquals(w.getCssValue("font-weight"),"700");
        }
//        /* Keyword values */
//        font-weight: normal;
//        font-weight: bold;
//
//        /* Keyword values relative to the parent */
//        font-weight: lighter;
//        font-weight: bolder;
//
//        /* Numeric keyword values */
//        font-weight: 100;
//        font-weight: 200;
//        font-weight: 300;
//        font-weight: 400;// normal
//        font-weight: 500;
//        font-weight: 600;
//        font-weight: 700;// bold
//        font-weight: 800;
//        font-weight: 900;
//
//        /* Global values */
//        font-weight: inherit;
//        font-weight: initial;
//        font-weight: unset;
    }

}
