package testsDemoqa;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US017Page;
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
    public void tc085(){
        //açılan bir pencereden bir tarih seçilebildiğini assert edin
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.clear();
        Select dropdown = new Select(us017Page.dropdownMonthSelection);
        dropdown.selectByIndex(5);
        ReusableMethods.waitFor(1);
        Select dropdown2 = new Select(us017Page.dropdownYearSelection);
        dropdown2.selectByIndex(10);
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"06/12/1910");
    }
    @Test
    public void tc086(){
        //açılan pencereden bir ay geriye gidip bir tarih seçilebildiğini assert edin
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.click();
        us017Page.previousMontSelectionArrow.click();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"10/12/2020");
        }
    @Test
    public void tc088(){
        //açılan pencereden bir ay ileriye bir tarih seçilebildiğini assert edin.
        us017Page.widgetsCard.click();
        us017Page.datePickerLink.click();
        us017Page.dateSelectionBox.click();
        us017Page.nextMontSelectionArrow.click();
        us017Page.dayOfMonthSelection.click();
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"12/12/2020");
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
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"09/12/2020");
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
        Assert.assertEquals(us017Page.dateSelectionBox.getAttribute("value"),"01/12/2021");
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
        System.out.println(us017Page.dateAndTimeBox.getAttribute("value"));
        Assert.assertTrue(us017Page.dateAndTimeBox.getAttribute("value").contains("May"));
    }
}
