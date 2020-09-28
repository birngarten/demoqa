package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_16_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

    public class US_16_Test extends TestBase {
    US_16_Page us16Page = new US_16_Page();
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setUs16Page() {

        wait.until(ExpectedConditions.visibilityOf(us16Page.wigdedsCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us16Page.autoCompleteLink)).click();

    }

    @Test
    public void TC_076() {
        soft.assertTrue(us16Page.pageTitle.isDisplayed());

        String color[] = {"Red", "Blue", "Yellow"};
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].click();",us16Page.renkler);
//        js.executeScript("document.getElementById('autoCompleteMultipleContainer').value='red';");
        for (int i = 0; i < color.length; i++) {
            actions.click(us16Page.renklermulti).sendKeys(color[i] ).build().perform();
            ReusableMethods.waitFor(1);
            actions.click(us16Page.renklermulti).sendKeys(Keys.ENTER ).build().perform();


        }
        for(int i=0;i<color.length;i++){
            Assert.assertTrue(Driver.getDriver().findElement(By.id("autoCompleteMultipleContainer")).getText()
                    .contains(color[i]));
        }

        for (int i = 0; i < color.length; i++) {
            actions.click(us16Page.singleBoxColor).sendKeys(color[i] ).build().perform();
            ReusableMethods.waitFor(1);
            actions.click(us16Page.singleBoxColor).sendKeys(Keys.ENTER).build().perform();
        }
//        #### Ozkan Bey in Yorumu ###
//        String colors[] = {"Green","Yellow","Blue","Black","Indigo"};
//        List<String> colorList= Arrays.asList(colors);
//        System.out.println(colorList.size());
//
//        for(String w : colorList) {
//            us16Page.autoCompletedTextBox.sendKeys(w);
//            us16Page.autoCompletedTextBox.sendKeys(Keys.ENTER)
//            }

//        List<String> allStringColorList = ReusableMethods.getElementsText(us16Page.cokluRenkListesi);
//        Assert.assertTrue(allStringColorList.equals(colorList));
//        System.out.println(allStringColorList);

//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(us16Page.autoCompletedMenuLink));
//        us16Page.autoCompletedMenuLink.click();



        soft.assertAll();
    }


}