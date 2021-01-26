package testsDemoqa;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesDemoqa.US029Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US029Test extends TestBase {
    US029Page us029Page = new US029Page();
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://demoqa.com/");
    }
    @Test
    public void tc169() {
        //"Book Store Application" linkinin gorunurlugunu ve  islevsel olup olmadigini  test ediniz.
        // Ve Sirasiyle "Login, Bookstore,Profile ve Book Store API" linkleri  alt alta olmali ve
        // seklinde yazilmis olmali bu durumlari test ediniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us029Page.bookStoreApplicationLink.isDisplayed());
        Assert.assertTrue(us029Page.bookStoreApplicationLink.isEnabled());
        us029Page.bookStoreApplicationLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        String [] myArray = {"Login", "Book Store","Profile", "Book Store API"};
            Assert.assertEquals(myArray[0],us029Page.login.getText());
            Assert.assertEquals(myArray[1],us029Page.bookStore.getText());
            Assert.assertEquals(myArray[2],us029Page.profile.getText());
            Assert.assertEquals(myArray[3],us029Page.bookStoreApi.getText());
    }

    @Test
    public void tc170(){
        //"Welcome,Login in Book Store" yazisinin  baslik seklinde  oldugunu assert ediniz.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us029Page.bookStoreApplicationLink.isDisplayed());
        Assert.assertTrue(us029Page.bookStoreApplicationLink.isEnabled());
        us029Page.bookStoreApplicationLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us029Page.login.click();
        Assert.assertEquals(us029Page.welcomeText.getText(),"Welcome,");
        Assert.assertEquals(us029Page.loginBookStoreText.getText(),"Login in Book Store");
    }
    @Test
    public void tc171(){
        //"First Name :First Name
        //Last Name :Last Name
        //UserName :UserNamePassword :Password"  dogru kullanici adi ve password  ile  kayit yapilabilirlig
        // test ediniz ve  kayit olursa sayfaya geri donuz Back to login butonu ile.
    }
    @Test
    public void tc172(){

    }
    @Test
    public void tc173(){

    }
    @Test
    public void tc174(){
        //Dogu veriler girildikten sonra  Register Buttonu tikalanir olmali ve Basariyla Yeni Kullanici
        // olusturuldu ifadesi gorulmeli ve Basariyla yeni Kullanici olusturuldu Mesaj Kutusu goruluyor olmali

    }
    @Test
    public void tc175(){
        //"Back to Login" butuno gorunur ve aktif olsun.
    }
}
