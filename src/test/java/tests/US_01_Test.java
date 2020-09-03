package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_01_Test extends TestBase {

    @Test
    public void TC_01() {
        us01Page.elementsCard.click();
        us01Page.elementsMenu.click();
        ReusableMethods.waitFor(2);
        Assert.assertFalse(us01Page.textBoxMenuLink.isDisplayed());
    }

    @Test
    public void TC_02() {
        us01Page.elementsCard.click();
        us01Page.textBoxMenuLink.click();
        Assert.assertTrue(us01Page.textBoxHeader.isDisplayed());
    }

    @Test
    public void TC_03() {
        us01Page.elementsCard.click();
        us01Page.textBoxMenuLink.click();
        String actualUserForm = us01Page.userForm.getText();
        System.out.println(actualUserForm);

        String [] expectedUserForm = {"Full Name", "Email", "Current Address" ,
                "Permanent Address","Submit"};

        for(String w : expectedUserForm) {
            Assert.assertTrue(actualUserForm.contains(w));
        }

        Assert.assertTrue(us01Page.fullnameTextBox.isEnabled());
        Assert.assertTrue(us01Page.emailTextBox.isEnabled());
        Assert.assertTrue(us01Page.currentAdressTextBox.isEnabled());
        Assert.assertTrue(us01Page.permanentAddressTextBox.isEnabled());
        Assert.assertTrue(us01Page.submitButton.isEnabled());

        String attributeValue= us01Page.emailTextBox.getAttribute("class");
        System.out.println("Attribute Value: " + attributeValue);

        for(int i =1; i<5; i++) {
            us01Page.emailTextBox.sendKeys(ConfigReader.getProperty("invalid_email_" +i));
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            ReusableMethods.waitFor(1);
            us01Page.submitButton.click();

            ReusableMethods.waitFor(1);
            String errorValue = us01Page.emailTextBox.getAttribute("class");
            Assert.assertTrue(errorValue.contains("error"));
            System.out.println(errorValue);
            Driver.getDriver().navigate().refresh(); // Refresh yaparak sayfadaki kayitlari silmeyi ve formun basina donmeyi sagladik
        }

    }

    @Test
    public void  TC_04() {
        us01Page.elementsCard.click();
        us01Page.textBoxMenuLink.click();
        us01Page.emailTextBox.sendKeys(ConfigReader.getProperty("valid_email"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitFor(1);
        us01Page.submitButton.click();

        String formKayit = us01Page.formKayit.getText();
        Assert.assertTrue(formKayit.contains(ConfigReader.getProperty("valid_email")));
    }

}
