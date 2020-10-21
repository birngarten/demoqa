package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_22_Page;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class US_22_Test extends TestBase {


    US_22_Page us22Page = new US_22_Page();
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setUs22Page() {

        wait.until(ExpectedConditions.elementToBeClickable(us22Page.widgetcard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).pause(Duration.ofSeconds(2)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us22Page.menuLinki)).click();
        ReusableMethods.waitFor(2);

    }

    @Test
    public void TC_119() {
        //- Sayfanın başlığı "Menu" oldugunu verify edin
        soft.assertTrue(us22Page.menuLinki.isDisplayed());
        soft.assertTrue(us22Page.menuHeadText.isDisplayed());
        soft.assertAll();
    }

    @Test
    public void TC_120() {
        ////a[@href='#']
        //@FindBy(xpath = "//ul[@id='nav']/li")
        //public List<WebElement> mainHeadList;
        //-Text boxlarin yesil renk dolgu ve beyaz yazi tipinde oldugunu assert edin
        System.out.println(us22Page.mainItem123.getText());
        for (WebElement main : us22Page.menuItems) {

            String backgroundColor = ReusableMethods.getHexColor(main, "background-color");
            System.out.println(backgroundColor);
            soft.assertTrue(backgroundColor.contains("#24af15"));
            soft.assertAll();
        }

        for (WebElement yazi : us22Page.beyazYaziTips) {

            String color = ReusableMethods.getHexColor(yazi, "color");
            System.out.println(color);
            soft.assertTrue(color.contains("#ffffff"));
            soft.assertAll();
        }

    }

    @Test
    public void TC_121() {

        //-Text boxların başlıklarinin "Main Item 1" , "Main Item 2" , "Main Item 3" oldugunu assert edin.

        String main[] = {"Main Item 1", "Main Item 2", "Main Item 3"};
        int count = 0;

        for (WebElement yazi : us22Page.beyazYaziTips) {
            System.out.println(yazi.getText());
            soft.assertEquals(yazi.getText(), main[count]);
            count++;
            soft.assertAll();
        }


    }

    @Test
    public void TC_122() {
//-Üst Text box hover yapilinca box ici koyu yesil renk oldugunu verify edin.


        for (WebElement m : us22Page.menuItems) {

            actions.moveToElement(m).perform();
            String afterMoveColo = ReusableMethods.getHexColor(m, "background-color");
            ReusableMethods.waitFor(2);
            System.out.println(afterMoveColo);
            soft.assertEquals(afterMoveColo, "#03f20");// koyu yesil #003f20
        }
        soft.assertAll();

    }

    @Test
    public void TC_123() {
        //-Üst Text box 2 hover yapilinca 3 adet sub Text Box asagiya acildigini assert edin

        actions.moveToElement(us22Page.mainItems2).perform();
        ReusableMethods.waitFor(2);
        int artis = 0;
        for (WebElement w : us22Page.subText3) {
            actions.moveToElement(w).build().perform();
            System.out.println(w.getText());
            artis++;
        }

        soft.assertEquals(artis, 3);
        soft.assertAll();


    }

    @Test
    public void TC_124() {

        //(//ul[@id='nav']/li)[2]//a
        //-Sirasiyla isimleri "Sub Item", "Sub Item" ve "SUB SUB LIST »" seklinde goruldugunu assert edin
        actions.moveToElement(us22Page.mainItems2).perform();
        ReusableMethods.waitFor(2);
        String subItemsTex[] = {"Sub Item", "Sub Item", "SUB SUB LIST »"};
        int artis = 0;
        for (WebElement w : us22Page.subText3) {
            actions.moveToElement(w).build().perform();
            System.out.println(w.getText());
            soft.assertTrue(w.getText().contains(subItemsTex[artis]));
            artis++;
        }

        soft.assertAll();

    }

    @Test
    public void TC_125() {
        //-"SUB SUB LIST »" Sub Text Box hover yapildiginda koyu yesil renk oldugunu
        // ve sag tarafa 2 adet Sub Sub Text Box acildigini assert edin
        String subItemListTex[] = {"Sub Sub Item 1", "Sub Sub Item 2"};
        int num = 0;
        for (WebElement sub : us22Page.mainItem2SublINKS) {
            actions.moveToElement(sub).build().perform();
            System.out.println(sub.getText());

            if (sub.getText().equals("SUB SUB LIST »")) {

                for (WebElement w : us22Page.subILinks2) {
                    actions.moveToElement(w).perform();
                    String afterMoveColo = ReusableMethods.getHexColor(w, "background-color");
                    ReusableMethods.waitFor(2);
                    System.out.println(afterMoveColo);
                    soft.assertEquals(afterMoveColo, "#03f20");// koyu yesil #003f20
                    num++;
                    System.out.println(num);
                }

                break;
            }


        }
        soft.assertAll();


    }

    @Test
    public void TC_126() {
        //-Isimlerinin sirasiyla "Sub Sub Item 1" ve"Sub Sub Item 2" seklinde goruldugunu verify edin
        String subItem2[] = {"Sub Sub Item 1", "Sub Sub Item 2"};
        int num = 0;
        actions.moveToElement(us22Page.mainItems2).perform();
        actions.moveToElement(us22Page.mainItemsResitbey).perform();
        actions.moveToElement(us22Page.subSubList).perform();
        for (WebElement w : us22Page.subSubItems) {

            soft.assertEquals(w.getText(), subItem2[num]);
            num++;

        }

        soft.assertAll();
    }

    @Test
    public void TC_127() {
        //  -Sub Sub Text Box'larin hover edildiginde koyu yesil renk aldigini assert edin

        actions.moveToElement(us22Page.mainItems2).perform();
        actions.moveToElement(us22Page.subSubList).perform();
        for (WebElement w : us22Page.subSubtGreeColor) {
            actions.moveToElement(w).build().perform();
            ReusableMethods.waitFor(2);
            String rgb = w.getCssValue("background-color");
            ReusableMethods.waitFor(2);
            String hex = Color.fromString(rgb).asHex();
            ReusableMethods.waitFor(2);
            soft.assertEquals(hex, "#003f20");
        }

        soft.assertAll();

    }
}
