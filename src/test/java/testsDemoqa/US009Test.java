package testsDemoqa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.FormsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US009Test {
    FormsPage formsPage = new FormsPage();
    @BeforeMethod
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
    @Test
    public void tc038(){
        formsPage.FormsCard.click();
        formsPage.practiceForm.click();
        formsPage.firstName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.lastName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.userTelefonNUmber.sendKeys("1234567890");
        formsPage.maleButton.click();
        formsPage.userEmailBox.sendKeys(ConfigReader.getProperty("demoqa_email_false1"));
        formsPage.submitButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(formsPage.errorElement.isDisplayed());
        formsPage.userEmailBox.clear();
        formsPage.userEmailBox.sendKeys(ConfigReader.getProperty("demoqa_email_false2"));
        formsPage.submitButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(formsPage.errorElement.isDisplayed());
        formsPage.userEmailBox.clear();
        formsPage.userEmailBox.sendKeys(ConfigReader.getProperty("demoqa_email_false3"));
        formsPage.submitButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(formsPage.errorElement.isDisplayed());
        formsPage.userEmailBox.clear();
        formsPage.userEmailBox.sendKeys(ConfigReader.getProperty("demoqa_email_false4"));
        formsPage.submitButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(formsPage.errorElement.isDisplayed());
        formsPage.userEmailBox.clear();
        formsPage.userEmailBox.sendKeys(ConfigReader.getProperty("demoqa_email_false5"));
        formsPage.submitButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(formsPage.errorElement.isDisplayed());
    }
    @Test
    public void tc039(){
        formsPage.FormsCard.click();
        formsPage.practiceForm.click();
        formsPage.firstName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.lastName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.maleButton.click();
        formsPage.submitButton.click();
        formsPage.userTelefonNUmber.sendKeys("123456789");
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.errorElement.isDisplayed());
        formsPage.userTelefonNUmber.sendKeys("1234567891");
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.succesTitle.isDisplayed());
    }
    @Test
    public void tc040(){
        formsPage.FormsCard.click();
        formsPage.practiceForm.click();
        //Assert.assertTrue(formsPage.sportsCheckBox.isEnabled());
        for(int i=4;i<7;i++){
            String element = "(//label[@class='custom-control-label'])["+i+"]";
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath(element)).isDisplayed());
        }
        formsPage.sportsCheckBox.click();
    }
    @Test
    public void tc41(){
        formsPage.FormsCard.click();
        formsPage.practiceForm.click();
        formsPage.firstName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.lastName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.userEmailBox.sendKeys(ConfigReader.getProperty("demoqa_email_true"));
        formsPage.maleButton.click();
        formsPage.userTelefonNUmber.sendKeys("1234567890");
        formsPage.sportsCheckBox.click();
        ReusableMethods.waitFor(1);
        formsPage.uploadFile.sendKeys("C:\\Users\\samet\\Desktop\\New Text Document.txt");
        formsPage.currentAdressTextBox.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.stateDropbox.click();
        ReusableMethods.waitFor(1);
        formsPage.stateInformationPlace.sendKeys("Haryana");
        formsPage.stateDropbox.submit();
//        ReusableMethods.waitFor(1);
//        formsPage.cityDropbox.click();
//        ReusableMethods.waitFor(1);
//        formsPage.stateInformationPlace.sendKeys("Karnal");
//        formsPage.cityDropbox.submit();
        //sehir seçicimde hata var
        Assert.assertTrue(formsPage.succesText.isDisplayed());
    }
    @Test
    public void tc042(){
        formsPage.FormsCard.click();
        formsPage.practiceForm.click();
        formsPage.firstName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.lastName.sendKeys(ConfigReader.getProperty("demoqa_test_data"));
        formsPage.maleButton.click();
        formsPage.userTelefonNUmber.sendKeys("1234567890");
        formsPage.submitButton.click();
        Assert.assertTrue(formsPage.succesTitle.isDisplayed());
    }
   }
