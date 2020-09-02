package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class TC01_TC04 extends TestBase {

    @Test
    public void TC_01() {
        demoqaPage.elementsCard.click();
        demoqaPage.elementsMenu.click();
        ReusableMethods.waitFor(2);
        Assert.assertFalse(demoqaPage.textBoxMenuLink.isDisplayed());
    }

    @Test
    public void TC_02() {
        demoqaPage.elementsCard.click();
        demoqaPage.textBoxMenuLink.click();
        Assert.assertTrue(demoqaPage.textBoxHeader.isDisplayed());
    }

    @Test
    public void TC_03() {
        demoqaPage.elementsCard.click();
        demoqaPage.textBoxMenuLink.click();
        String actualUserForm = demoqaPage.userForm.getText();
        System.out.println(actualUserForm);

        String [] expectedUserForm = {"Full Name", "Email", "Current Address" ,
                "Permanent Address","Submit"};

        for(String w : expectedUserForm) {
            Assert.assertTrue(actualUserForm.contains(w));
        }

        Assert.assertTrue(demoqaPage.fullnameTextBox.isEnabled());
        Assert.assertTrue(demoqaPage.emailTextBox.isEnabled());
        Assert.assertTrue(demoqaPage.currentAdressTextBox.isEnabled());
        Assert.assertTrue(demoqaPage.permanentAddressTextBox.isEnabled());
        Assert.assertTrue(demoqaPage.submitButton.isEnabled());

        String attributeValue= demoqaPage.emailTextBox.getAttribute("class");
        System.out.println("Attribute Value: " + attributeValue);

        for(int i =1; i<5; i++) {
            demoqaPage.emailTextBox.sendKeys(ConfigReader.getProperty("invalid_email_" +i));
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            ReusableMethods.waitFor(1);
            demoqaPage.submitButton.click();

            ReusableMethods.waitFor(1);
            String errorValue =demoqaPage.emailTextBox.getAttribute("class");
            Assert.assertTrue(errorValue.contains("error"));
            System.out.println(errorValue);
            Driver.getDriver().navigate().refresh(); // Refresh yaparak sayfadaki kayitlari silmeyi ve formun basina donmeyi sagladik
        }

    }

    @Test
    public void  TC_04() {
        demoqaPage.elementsCard.click();
        demoqaPage.textBoxMenuLink.click();
        demoqaPage.emailTextBox.sendKeys(ConfigReader.getProperty("valid_email"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitFor(1);
        demoqaPage.submitButton.click();

        String formKayit = demoqaPage.formKayit.getText();
        Assert.assertTrue(formKayit.contains(ConfigReader.getProperty("valid_email")));
    }

}
