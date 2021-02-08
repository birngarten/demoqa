package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import static io.restassured.RestAssured.*;

public class US_11_Put {


    @Test
    public void TC1101() {
        /*"1.  Kullanici adi  ""ozkan1"" ve sifresi ""JQ3iPpTEKTLjSQJ!"" olan
         * kullanicinin kitaplarindan ""9781449325862"" isbn li kitabi ""9781593277574"" isbnli kitap ile degistiriniz.
         * response un ""application/json"" tipinde oldugunu
         * Status kodunun un 200 oldugunu dogrulayiniz.         */



    }

    @Test
    public void TC1102(){
        /*2. Kullanici adi  ""ozkan1"" ve sifresi ""JQ3iPpTEKTLjSQJ!"" olan
         * kullanicinin ""9781593277574"" isbn li kitabin kullanicinin listesinde oldugunu dogrulayiniz.
         * kullanicinin kitaplarindan ""9781593277574""  isbn li kitabi ""9781491950296"" isbnli kitap ile degistiriniz.
         * Status kodunun un 200 oldugunu dogrulayiniz.
         * ""9781593277574"" isbn li kitabin kullanicin listesinde artik  olmadigini dogrulayiniz.
         * Bug bulduysaniz sebebini aciklayiniz. (1. Test caseden farkini aciklayiniz)         */



    }

    @Test
    public void TC1103(){
        /*3. Kullanici adi  ""ozkan1"" ve sifresi ""JQ3iPpTEKTLjSQJ!"" olan
         * kullanicinin kitaplarindan ""9781449331818"" isbn li kitabi 9781449337711 (integer olarak giriniz) isbnli
         * kitap ile guncelleyiniz.
         * response un ""application/json"" tipinde oldugunu
         * Status kodunun un 400 oldugunu dogrulayiniz."        */



    }

    @Test
    public void TC1104(){
        /*4. Kullanici adi  ""ozkan1"" ve sifresi ""WrNg!Def123KZW"" olan
         * kullanicinin kitaplarindan ""9781449331818"" isbn li kitabi 9781449337711 (integer) isbnli kitap ile guncelleyiniz
         * Status kodunun un 401  oldugunu
         * Responstaki hata mesajinin   ""User not authorized!"" ve hata kodunun ""1200"" oldugunu dogrulayiniz."   */



    }


}

