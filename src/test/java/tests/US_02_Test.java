package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_02_Page;
import utilities.Driver;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

public class US_02_Test extends TestBase {

    US_02_Page us02Page = new US_02_Page();

    @Test
    public void TC_05() {
        us01Page.elementsCard.click();
        Assert.assertTrue(us02Page.checkboxMenuLink.isDisplayed());
    }

    @Test
    public void TC_06() {
        us01Page.elementsCard.click();
        us02Page.checkboxMenuLink.click();
        Assert.assertTrue(us02Page.checkBoxHeader.isDisplayed());
    }

    @Test
    public void TC_07() {
        us01Page.elementsCard.click();
        us02Page.checkboxMenuLink.click();
        us02Page.expandAllButton.click();

        for(int i =1; i<=17; i++ ) {
            String xpathInput= "(//input)[" + i + "]"; //  (//input)[17]
           // System.out.println( "Xpath Kontrol: " + xpathInput);
            WebElement checkbox = Driver.getDriver().findElement(By.xpath(xpathInput));
            Assert.assertTrue(checkbox.isEnabled());

        }

    }

    @Test
    public void TC_08() {
        us01Page.elementsCard.click();
        us02Page.checkboxMenuLink.click();
        us02Page.expandAllButton.click();

        Map<Integer,String> checkboxTexts = new HashMap<>();
        for(int i=1; i<=17; i++) {
            String xpathCheckboxText= "(//span[@class='rct-title'])["+ i + "]";
            String checkboxText = Driver.getDriver().findElement(By.xpath(xpathCheckboxText)).getText();
            checkboxTexts.put(i,checkboxText);
        }
       //  System.out.println(checkboxTexts);

        String [] expectedCheckboxTexts = {" ", "Home", "Desktop", "Notes", "Commands", "Documents", "WorkSpace", "React", "Angular",
                "Veu", "Office", "Public", "Private", "Classified", "General", "Downloads", "Word File.doc", "Excel File.doc"};

        int i = 0;
        for(String w :expectedCheckboxTexts) {
            if(i>=1) {
                Assert.assertEquals(w,checkboxTexts.get(i));
                System.out.println(w + " = " + checkboxTexts.get(i));
            }
            i++;
        }
    }

    @Test
    public void TC_09() {
        //Samet Beyden alinacak
    }

    @Test
    public void TC_10() {
        //Samet Beyden alinacak
    }
}
