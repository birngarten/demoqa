package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_31_Page;
import utilities.TestBase;

public class US_31_Test extends TestBase {

    US_31_Page us31Page = new US_31_Page();

    @BeforeMethod
    public void bookStoreAppSetup() {


    }

    @Test
    public void TC_183() {
//        Sayfanın basliginin "Profile" oldugunu assert ediniz



    }

    @Test
    public void TC_184() {
//        Login linknin gorunur ve islevsel oldugunu test ediniz


    }

    @Test
    public void TC_185() {
//        Register linkinin gorunur ve islevsel oldugunu test ediniz



    }

    @Test
    public void TC_186() {
//        Resgister linkine tiklandıktan sonra acilan sayfanin basliginin Register oldugunu assert ediniz



    }

    @Test
    public void TC_187() {
//        Register sayfasında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin
//        görüntülendigini assert ediniz


    }

    @Test
    public void TC_188() {
//        Register sayfasında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin
//        islevsel oldugunu assert ediniz



    }

    @Test
    public void TC_189() {
//        Register buttonun görüntülendigini ve islevsel oldugunu assert ediniz


    }

    @Test
    public void TC_190() {
//        Zorunlu alanlara veri istenilen veriler girildiginde yeni kullanıcı kaydinin
//        yapildigini assert ediniz



    }

    @Test
    public void TC_191() {
//        Zorunlu alanlardan herhangi biri bos birakildiginda kayit isleminin yapilmadigini assert ediniz


    }

    @Test
    public void TC_192() {
//        Verilen kriterlere uygun password girilmediginde kayit islemi gerçceklesmedigini assert ediniz


    }

    @Test
    public void TC_193() {
//        Verilen kriterlere uygun password girildiginde kayit islemi basarili bir sekilde
//        gerceklestigini assert ediniz



    }

    @Test
    public void TC_194() {
//        Back to Login" buton gorunebilir ve foksiyonel oldugunu assert ediniz


    }
}
