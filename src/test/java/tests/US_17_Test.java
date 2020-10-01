package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_16_Page;
import pages.US_17_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

    public class US_17_Test extends TestBase {
        US_17_Page us_17_page = new US_17_Page();
        US_16_Page us_16_page = new US_16_Page();
        SoftAssert soft = new SoftAssert();

        @BeforeMethod
        public void setUs17Page() {

            wait.until(ExpectedConditions.visibilityOf(us_16_page.wigdedsCard)).click();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            wait.until(ExpectedConditions.visibilityOf(us_17_page.datePicker)).click();

        }

        @Test
        public void TC_00() {
            soft.assertTrue(us_17_page.datePicker.isEnabled());
            String dateList = us_17_page.dateZone.toString();
            System.out.println(dateList);
            WebElement tarihSelect = Driver.getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
            ReusableMethods.waitFor(2);
            tarihSelect.clear();

            tarihSelect.sendKeys("04/17/2013");


//        us17Page.selectDateBox.click();
//
//        Select optionsAy = new Select(us17Page.month);
//        optionsAy.selectByIndex(3);
//        ReusableMethods.waitFor(2);
//
//        us17Page.day.click();
//        ReusableMethods.waitFor(5);
//        Select optionsYil = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
//        optionsYil.selectByVisibleText("2021");


            soft.assertAll();

        }

        @Test
        public void TC_085() {
            //açılan pencereden bir ay geriye gidip bir tarih seçilebildiğini assert edin
            WebElement tarihSelect = Driver.getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
            ReusableMethods.waitFor(2);
            tarihSelect.clear();
            ReusableMethods.waitFor(3);

            tarihSelect.sendKeys("08/28/2020");
            ReusableMethods.waitFor(3);
            soft.assertEquals(us_17_page.selectDateBox.getAttribute("value"), "08/28/2020");
            soft.assertAll();
        }

        @Test
        public void TC_087() {
            //açılan pencereden bir ay ileriye bir tarih seçilebildiğini assert edin.
            WebElement tarihSelect = Driver.getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
            ReusableMethods.waitFor(2);
            tarihSelect.clear();
            ReusableMethods.waitFor(3);

            tarihSelect.sendKeys("10/28/2020");
            ReusableMethods.waitFor(3);
            soft.assertEquals(us_17_page.selectDateBox.getAttribute("value"), "10/28/2020");
            soft.assertAll();

        }

        @Test
        public void TC_088() {
            //açılan pencereden iki ay geriye gidip bir tarih seçilebildiğini assert edin
            WebElement tarihSelect = Driver.getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
            ReusableMethods.waitFor(2);
            tarihSelect.clear();
            ReusableMethods.waitFor(3);

            tarihSelect.sendKeys("07/28/2020");
            ReusableMethods.waitFor(3);
            soft.assertEquals(us_17_page.selectDateBox.getAttribute("value"), "07/28/2020");
            soft.assertAll();

        }

        @Test
        public void TC_089() {
            //açılan pencereden iki ay ileriye bir tarih seçilebildiğini assert edin.
            WebElement tarihSelect = Driver.getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"));
            ReusableMethods.waitFor(2);
            tarihSelect.clear();
            ReusableMethods.waitFor(3);

            tarihSelect.sendKeys("11/28/2020");
            ReusableMethods.waitFor(3);
            soft.assertEquals(us_17_page.selectDateBox.getAttribute("value"), "11/28/2020");
            soft.assertAll();

        }
    }
