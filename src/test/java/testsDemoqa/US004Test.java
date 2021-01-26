package testsDemoqa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesDemoqa.DemogaWebTablesButtonsLinksPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004Test {
    DemogaWebTablesButtonsLinksPage demogaWebTablesButtonsLinksPage = new DemogaWebTablesButtonsLinksPage();

    @BeforeMethod
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc016(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.webTables.click();
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.addButton.isEnabled());
    }
    @Test
    public void tc017(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.webTables.click();
        demogaWebTablesButtonsLinksPage.addButton.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(demogaWebTablesButtonsLinksPage.firstNameTextbox.isDisplayed());
        softAssert.assertTrue(demogaWebTablesButtonsLinksPage.lastNameTextbox.isDisplayed());
        softAssert.assertTrue(demogaWebTablesButtonsLinksPage.emailTextbox.isDisplayed());
        softAssert.assertTrue(demogaWebTablesButtonsLinksPage.ageTextbox.isDisplayed());
        softAssert.assertTrue(demogaWebTablesButtonsLinksPage.salaryTextbox.isDisplayed());
        softAssert.assertTrue(demogaWebTablesButtonsLinksPage.departmentTextbox.isDisplayed());
        softAssert.assertAll();
    }
    @Test
    public void tc018(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.webTables.click();
        demogaWebTablesButtonsLinksPage.addButton.click();
        demogaWebTablesButtonsLinksPage.firstNameTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.lastNameTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.emailTextbox.sendKeys(ConfigReader.getProperty("demoqa_email_true"));
        demogaWebTablesButtonsLinksPage.ageTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_age"));
        demogaWebTablesButtonsLinksPage.salaryTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_salary"));
        demogaWebTablesButtonsLinksPage.departmentTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.submitButton.submit();
        ReusableMethods.waitFor(2);
        demogaWebTablesButtonsLinksPage.searchBox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        System.out.println(demogaWebTablesButtonsLinksPage.resultText.getText());
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.resultText.getText().contains(ConfigReader.getProperty("demoqa_test_data")));
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.resultText.getText().contains(ConfigReader.getProperty("demoqa_email_true")));
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.resultText.getText().contains(ConfigReader.getProperty("demoqa_test_age")));
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.resultText.getText().contains(ConfigReader.getProperty("demoqa_test_salary")));
    }
    @Test
    public void tc019(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.webTables.click();
        demogaWebTablesButtonsLinksPage.addButton.click();
        demogaWebTablesButtonsLinksPage.lastNameTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.emailTextbox.sendKeys(ConfigReader.getProperty("demoqa_email_true"));
        demogaWebTablesButtonsLinksPage.ageTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_age"));
        demogaWebTablesButtonsLinksPage.salaryTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_salary"));
        demogaWebTablesButtonsLinksPage.departmentTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.submitButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.firstNameTextbox.getAttribute("value").equals(""));
        demogaWebTablesButtonsLinksPage.firstNameTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.lastNameTextbox.clear();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.lastNameTextbox.getAttribute("value").equals(""));
        demogaWebTablesButtonsLinksPage.lastNameTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.emailTextbox.clear();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.emailTextbox.getAttribute("value").equals(""));
        demogaWebTablesButtonsLinksPage.emailTextbox.sendKeys(ConfigReader.getProperty("demoqa_email_true"));
        demogaWebTablesButtonsLinksPage.ageTextbox.clear();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.ageTextbox.getAttribute("value").equals(""));
        demogaWebTablesButtonsLinksPage.ageTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_age"));
        demogaWebTablesButtonsLinksPage.salaryTextbox.clear();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.salaryTextbox.getAttribute("value").equals(""));
        demogaWebTablesButtonsLinksPage.salaryTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_salary"));
        demogaWebTablesButtonsLinksPage.departmentTextbox.clear();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.departmentTextbox.getAttribute("value").equals(""));
    }
    @Test
    public void tc020(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.webTables.click();
        demogaWebTablesButtonsLinksPage.searchBox.sendKeys("Cierra");
        demogaWebTablesButtonsLinksPage.editButtonPencil.click();
        demogaWebTablesButtonsLinksPage.firstNameTextbox.clear();
        demogaWebTablesButtonsLinksPage.firstNameTextbox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        demogaWebTablesButtonsLinksPage.submitButton.click();
        Assert.assertTrue(demogaWebTablesButtonsLinksPage.resultText.getText().contains(ConfigReader.getProperty("demoqa_test_data")));
    }
    @Test
    public void tc021(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.webTables.click();
        demogaWebTablesButtonsLinksPage.deleteSecondData.click();
        Assert.assertFalse(demogaWebTablesButtonsLinksPage.searchBox.getText().contains("Alden"));

    }



}
