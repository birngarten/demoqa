package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US017Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US017Test {

    US017Page us017Page = new US017Page();
    @BeforeMethod
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc086(){
        //açılan bir pencereden bir tarih seçilebildiğini assert edin
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.clear();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"09/22/2020");
    }
    @Test
    public void tc087(){
        //açılan pencereden bir ay geriye gidip bir tarih seçilebildiğini assert edin
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.click();
        us017Page.previousMontSelectionArrow.click();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"08/22/2020");
        }
    @Test
    public void tc088(){
        //açılan pencereden bir ay ileriye bir tarih seçilebildiğini assert edin.
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.click();
        us017Page.nextMontSelectionArrow.click();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"10/22/2020");
    }
    @Test
    public void tc089(){
        //açılan pencereden iki ay geriye gidip bir tarih seçilebildiğini assert edin
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.click();
        us017Page.previousMontSelectionArrow.click();
        us017Page.previousMontSelectionArrow.click();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"07/22/2020");
    }
    @Test
    public void tc090(){
        //açılan pencereden iki ay ileriye bir tarih seçilebildiğini assert edin.
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.click();
        us017Page.nextMontSelectionArrow.click();
        us017Page.nextMontSelectionArrow.click();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"11/22/2020");
    }
    @Test
    public void tc091(){
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateAndTimeBox.click();
        us017Page.monthDropboxMenu.click();
        us017Page.monthMay.click();
        ReusableMethods.waitFor(1);
        us017Page.yearDropboxMenu.click();
        us017Page.year2018.click();
        us017Page.dayOfMonthSelection.click();
        System.out.println(us017Page.dateAndTimeBox.getCssValue("value"));
        Assert.assertTrue(us017Page.dateAndTimeBox.getAttribute("value").contains("May 22, 2018"));
    }
}
