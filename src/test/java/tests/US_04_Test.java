package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class US_04_Test extends TestBase {
    US_04_Page us_04_page=new US_04_Page();

    @Test
    public void TC016() {
        us01Page.elementsCard.click();
        us_04_page.webtableMenuLink.click();
        Assert.assertTrue(us_04_page.addButton.isDisplayed());
    }

    @Test
    public void TC017() {
        us01Page.elementsCard.click();
        us_04_page.webtableMenuLink.click();
        us_04_page.addButton.click();
        Assert.assertTrue(us_04_page.firstNameTextBox.isDisplayed());
        Assert.assertTrue(us_04_page.lastNameTextBox.isDisplayed());
        Assert.assertTrue(us_04_page.userEmailTextBox.isDisplayed());
        Assert.assertTrue(us_04_page.ageTextBox.isDisplayed());
        Assert.assertTrue(us_04_page.salaryTextBox.isDisplayed());
        Assert.assertTrue(us_04_page.departmentTextBox.isDisplayed());
    }

    @Test
    public void TC018() {
        us01Page.elementsCard.click();
        us_04_page.webtableMenuLink.click();
        us_04_page.addButton.click();
        us_04_page.firstNameTextBox.sendKeys(ConfigReader.getProperty("firstname"));
        us_04_page.lastNameTextBox.sendKeys(ConfigReader.getProperty("lastname"));
        us_04_page.userEmailTextBox.sendKeys(ConfigReader.getProperty("valid_email"));
        us_04_page.ageTextBox.sendKeys(ConfigReader.getProperty("age"));
        us_04_page.salaryTextBox.sendKeys(ConfigReader.getProperty("salary"));
        us_04_page.departmentTextBox.sendKeys(ConfigReader.getProperty("department"));
        us_04_page.submitButton.click();
        us_04_page.searchTextBox.sendKeys(ConfigReader.getProperty("firstname"));

        Assert.assertTrue(us_04_page.firstSatir.getText().contains(ConfigReader.getProperty("firstname")));

    }

    @Test
    public void TC019() {
        us01Page.elementsCard.click();
        us_04_page.webtableMenuLink.click();
        us_04_page.addButton.click();
        us_04_page.lastNameTextBox.sendKeys(ConfigReader.getProperty("lastname"));
        us_04_page.userEmailTextBox.sendKeys(ConfigReader.getProperty("valid_email"));
        us_04_page.ageTextBox.sendKeys(ConfigReader.getProperty("age"));
        us_04_page.salaryTextBox.sendKeys(ConfigReader.getProperty("salary"));
        us_04_page.departmentTextBox.sendKeys(ConfigReader.getProperty("department"));
        us_04_page.submitButton.click();
        ReusableMethods.waitFor(3);
        String hataRengiRCB=us_04_page.firstNameTextBox.getCssValue("border-color");
        String hataRengiHex= Color.fromString(hataRengiRCB).asHex();
        System.out.println(hataRengiHex);
        Assert.assertEquals(hataRengiHex,"#dc3545");

    }

    @Test
    public void TC020() {
        us01Page.elementsCard.click();
        us_04_page.webtableMenuLink.click();
        us_04_page.editButton.click();
        us_04_page.firstNameTextBox.clear();
        us_04_page.firstNameTextBox.sendKeys("Sureyya");
        us_04_page.submitButton.click();
        us_04_page.searchTextBox.sendKeys("Sureyya");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us_04_page.firstSatir.getText().contains("Sureyya"));
    }

    @Test
    public void TC021() {
        us01Page.elementsCard.click();
        us_04_page.webtableMenuLink.click();
        us_04_page.searchTextBox.sendKeys("Alden");
        us_04_page.deleteButton.click();
        Assert.assertTrue(us_04_page.noRowsText.isDisplayed());
    }



}
