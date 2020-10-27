package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_31_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_31_Test extends TestBase {

    US_31_Page us31Page = new US_31_Page();

    @BeforeMethod
    public void bookStoreAppSetup() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us31Page.bookStoreAppMenuCard.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us31Page.profiloMenuLink)).click();

    }

    @Test
    public void TC_183() {
//        Sayfanın basliginin "Profile" oldugunu assert ediniz
        String profileHeaderText = us31Page.profileHeaderText.getText();
        Assert.assertEquals(profileHeaderText,"Profile");
    }

    @Test
    public void TC_184() {
//        Login linknin gorunur ve islevsel oldugunu test ediniz
        Assert.assertTrue(us31Page.loginLink.isDisplayed() && us31Page.loginLink.isEnabled());

    }

    @Test
    public void TC_185() {
//        Register linkinin gorunur ve islevsel oldugunu test ediniz
        Assert.assertTrue(us31Page.registerLink.isDisplayed() && us31Page.registerLink.isEnabled());

    }

    @Test
    public void TC_186() {
//        Resgister linkine tiklandıktan sonra acilan sayfanin basliginin Register oldugunu assert ediniz
        us31Page.registerLink.click();

        String registerHeaderText = us31Page.registerHeaderText.getText();
        Assert.assertEquals(registerHeaderText,"Register");

    }

    @Test
    public void TC_187() {
//        Register sayfasında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin
//        görüntülendigini assert ediniz
        wait.until(ExpectedConditions.elementToBeClickable(us31Page.registerLink)).click();
        String actualBoxText [] ={"First Name", "Last Name", "UserName", "Password"};

        int i =0;
        for (WebElement w: us31Page.registerBookStoreList){
            System.out.println(w.getText());
//            wait.until(ExpectedConditions.visibilityOfAllElements(us31Page.registerBookStoreList));
            ReusableMethods.waitFor(3);
            Assert.assertTrue(w.getText().contains(actualBoxText[i++]));

        }
    }

    @Test
    public void TC_188() {
//        Register sayfasında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin
//        islevsel oldugunu assert ediniz
        us31Page.registerLink.click();

        for (WebElement w: us31Page.registerBookStoreBoxes){
            w.sendKeys("Ismail");
            Assert.assertTrue(w.isEnabled());
        }
    }

    @Test
    public void TC_189() {
//        Register buttonun görüntülendigini ve islevsel oldugunu assert ediniz
        us31Page.registerLink.click();
        Assert.assertTrue(us31Page.registerButton.isDisplayed() && us31Page.registerButton.isEnabled());

    }

    @Test
    public void TC_190() {
//        Zorunlu alanlara  istenilen veriler girildiginde yeni kullanıcı kaydinin yapildigini assert ediniz
//        *** NOT*** captcha gecilemiyor

    }

    @Test
    public void TC_191() {
//        Zorunlu alanlardan herhangi biri bos birakildiginda kayit isleminin yapilmadigini assert ediniz
        us31Page.registerLink.click();
        for(int i=0; i<us31Page.registerBookStoreBoxes.size(); i++){
            us31Page.registerBookStoreBoxes.get(0).sendKeys("Saltuk");
            us31Page.registerBookStoreBoxes.get(1).sendKeys("Ismail");
            us31Page.registerBookStoreBoxes.get(2).sendKeys("Samet");

            break;
        }
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us31Page.registerButton.click();
        Assert.assertTrue(us31Page.kayitOlmadi.isDisplayed());

    }

    @Test
    public void TC_192() {
//        Verilen kriterlere uygun password girilmediginde kayit islemi gerçceklesmedigini assert ediniz
        //        *** NOT*** captcha gecilemiyor

    }

    @Test
    public void TC_193() {
//        Verilen kriterlere uygun password girildiginde kayit islemi basarili bir sekilde
//        gerceklestigini assert ediniz
        //        *** NOT*** captcha gecilemiyor

    }

    @Test
    public void TC_194() {
//        Back to Login" buton gorunebilir ve foksiyonel oldugunu assert ediniz
        us31Page.registerLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(us31Page.backLoginButon.isDisplayed() && us31Page.backLoginButon.isEnabled());


    }
}
