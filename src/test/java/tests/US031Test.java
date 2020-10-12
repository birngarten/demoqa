package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US031Page;

public class US031Test {
    US031Page us031Page = new US031Page();
    @BeforeMethod
    public void setUp(){

    }
    @Test
    public void tc183(){
        //Sayfanın basliginin "Profile" oldugunu assert ediniz
    }
    @Test
    public void tc184(){
        //Login linknin gorunur ve islevsel oldugunu test ediniz
    }
    @Test
    public void tc185(){
        //Register linkinin gorunur ve islevsel oldugunu test ediniz
    }
    @Test
    public void tc186(){
        //Resgister linkine tiklandıktan sonra acilan sayfanin basliginin Register oldugunu assert ediniz
    }
    @Test
    public void tc187(){
        //Register saysında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin görüntülendigini assert ediniz
    }
    @Test
    public void tc188(){
        //Register saysında sirayla "First Name", "Last Name", "UserName", "Password"  boxlari nin islevsel oldugunu assert ediniz
    }
    @Test
    public void tc189(){
        //Register buttonun görüntülendigini ve islevsel oldugunu assert ediniz
    }
    @Test
    public void tc190(){
        //Zorunlu alanlara veri istenilen veriler girildiginde yeni kullanıcı kaydinin yapidigini assert ediniz
    }
    @Test
    public void tc191(){
        //Zorunlu alanlardan herhangi biri bos birakildiginda kayit isleminin yapilmadigini assert ediniz
    }
    @Test
    public void tc192(){
        //Verilen kriterlere uygun password girilmediginde kayit islemi gerçceklesmedigini assert ediniz
    }
    @Test
    public void tc193(){
        //Verilen kriterlere uygun password girildiginde kayit islemi basarili bir sekilde gerceklestigini assert ediniz
    }
    @Test
    public void tc194(){
        //Back to Login" buton gorunebilir ve foksiyonel oldugunu assert ediniz
    }
}
