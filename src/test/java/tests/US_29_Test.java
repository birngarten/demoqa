package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_29_Page;
import utilities.ConfigReader;
import utilities.TestBase;

public class US_29_Test extends TestBase {

    US_29_Page us29Page = new US_29_Page();

    @BeforeMethod
    public void setUs29Page() {
        wait.until(ExpectedConditions.elementToBeClickable(us29Page.bookStoreApplicationCard)).click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    @Test
    public void TC_169() {
        // "Book Store Application" linkinin gorunurlugunu ve  islevsel olup olmadigini  test ediniz.
        // Ve Sirasiyle "Login, Bookstore,Profile ve Book Store API" linkleri  alt alta olmali ve
        // seklinde yazilmis olmali bu durumlari test ediniz

        Assert.assertTrue(us29Page.bookStoreApplicationMenuLink.isDisplayed() && us29Page.bookStoreApplicationMenuLink.isEnabled());
        String [] bookStoreAppElements = {"Login", "Book Store", "Profile" , "Book Store API"};

        int i = 0;
        for(WebElement w : us29Page.bookStoreApplicationMenuElements) {
            Assert.assertEquals(w.getText(),bookStoreAppElements[i++]);
        }

    }

    @Test
    public void TC_170() {
        // "Welcome,Login in Book Store" yazisinin  baslik seklinde  oldugunu assert ediniz.
        wait.until(ExpectedConditions.elementToBeClickable(us29Page.loginMenuLink)).click();
        String baslikTag = us29Page.welcomeText.getTagName();
        System.out.println(baslikTag);

        Assert.assertTrue(baslikTag.contains("h"));

    }

    @Test
    public void TC_171() {
        // anacan
        // JQ3iPpTEKTLjSQJ!

        // First Name :First Name   ====  Last Name :Last Name
        // UserName :UserName             Password :Password""  dogru kullanici adi ve password
        // ile  kayit yapilabilirlig test ediniz ve  kayit olursa sayfaya geri donuz Back to login butonu ile."
        wait.until(ExpectedConditions.elementToBeClickable(us29Page.loginMenuLink)).click();

        us29Page.userName.sendKeys(ConfigReader.getProperty("demoqa_username"));
        us29Page.password.sendKeys(ConfigReader.getProperty("demoqa_password"));
        us29Page.loginButton.click();

        Assert.assertTrue(us29Page.logoutButton.isDisplayed());
    }

    @Test
    public void TC_172() {
        // Password TextBox altinda  sorgulama Capthcha  alani oldugunu verify ediniz
    }

    @Test
    public void TC_173() {
        // Password icin "Parolalarda en az bir ozel karakter, bir rakam
        // ('0' - '9'), bir büyük harf ('A' - 'Z'), bir küçük harf ('a' - 'z'), bir özel karakter ve
        // Parola sekiz karakter veya daha uzun olmalıdır sartlarinin saglandigi positif test olarak  test ediniz.
    }

    @Test
    public void TC_174() {
        // Dogu veriler girildikten sonra  Register Buttonu tikalanir olmali ve Basariyla Yeni Kullanici olusturuldu
        // ifadesi gorulmeli ve Basariyla yeni Kullanici olusturuldu Mesaj Kutusu goruluyor olmali
    }

    @Test
    public void TC_175() {
        // "Back to Login" butuno gorunur ve aktif olsun.
    }


}
