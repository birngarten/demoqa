package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US029Page;
import utilities.Driver;

public class US029Test {
    US029Page us029Page = new US029Page();
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://demoqa.com/");
    }
    @Test
    public void tc169(){
        //"Book Store Application" linkinin gorunurlugunu ve  islevsel olup olmadigini  test ediniz.
        // Ve Sirasiyle "Login, Bookstore,Profile ve Book Store API" linkleri  alt alta olmali ve
        // seklinde yazilmis olmali bu durumlari test ediniz

    }
    @Test
    public void tc170(){
        //"Welcome,Login in Book Store" yazisinin  baslik seklinde  oldugunu assert ediniz.

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
