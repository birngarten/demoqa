package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FormsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US009 {
    FormsPage formsPage = new FormsPage();
    @BeforeTest
    public void start(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc036(){
        formsPage.FormsCard.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(formsPage.practiceForm.isEnabled());
    }
    @Test
    public void tc037(){
        formsPage.FormsCard.click();
        formsPage.practiceForm.click();
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.errorElement.isEnabled());
        Driver.getDriver().navigate().refresh();
        formsPage.firstName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.errorElement.isEnabled());
        formsPage.lastName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.errorElement.isEnabled());
        ReusableMethods.waitFor(2);
        formsPage.maleButton.click();
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.errorElement.isEnabled());
        formsPage.userTelefonNUmber.sendKeys("1234567890");
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.succesTitle.isDisplayed());
    }
}
