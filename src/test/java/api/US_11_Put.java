package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import static io.restassured.RestAssured.*;

public class US_11_Put {

    Response response;
    JsonPath json;
    String username = "ozkan1";
    String password = "JQ3iPpTEKTLjSQJ!";
    Map<String,Object> putBody = new LinkedHashMap<>();

    @Test
    public void postAllBooks(){
        String endpoint = "https://demoqa.com/BookStore/v1/Books";

        response = given().
                   when().
                        get(endpoint);
//        response.prettyPrint();
        json = response.jsonPath();
        List<String> allIsbn = json.getList("books.isbn");

        for (String isbn: allIsbn){
//      1.YOL String ile
//            String allBooksBody = "{\n" +
//                    "  \"userId\": \"0918fbb4-0298-4cbc-a462-ad5ffc823dc5\",\n" +
//                    "  \"collectionOfIsbns\": [\n" +
//                    "    {\n" +
//                    "      \"isbn\": "+isbn+"\n" +
//                    "    }\n" +
//                    "  ]\n" +
//                    "}";
//      2.YOL Map ile
            Map<String, String> oneBookIsbn = new LinkedHashMap<>();
           oneBookIsbn.put("isbn", isbn); // ==> I. BU MAP en icteki isbn'i aliyor.

           List<Map<String, String>> oneBook = new ArrayList<>();
           oneBook.add(oneBookIsbn); //==> II.Bununla bir kitabin tum bilgilerini aliyoruz.
                                    // 1'den cok kitap oldugundan ve postBody'nin ici Array oldugundan LIST'e attik
           Map<String, Object> allBooksBody = new LinkedHashMap<>();
           allBooksBody.put("userId", "0918fbb4-0298-4cbc-a462-ad5ffc823dc5");
           allBooksBody.put("collectionOfIsbns",oneBook); //==> III. Bununla butun datayi aliyoruz.
            response = given().
                            contentType(ContentType.JSON).
                            auth().preemptive().basic(username,password).
                            body(allBooksBody).
                      when().
                            post(endpoint);
//            response.prettyPrint();

        }
    }

    public Response putMethod(String username, String password, Object addIsbn, String isbnOfEndpoint){
        String basicEndpoint = "https://demoqa.com/BookStore/v1/Books/";
        putBody.put("userId","0918fbb4-0298-4cbc-a462-ad5ffc823dc5");
        putBody.put("isbn",addIsbn);

        response = given().
                        contentType(ContentType.JSON).
                        auth().preemptive().basic(username,password).
                        body(putBody).
                when().
                        put(basicEndpoint+isbnOfEndpoint);
        return response;
    }

    public Response getUserBooks(){
        String getEntpoint = "https://demoqa.com/Account/v1/User/0918fbb4-0298-4cbc-a462-ad5ffc823dc5";
        response = given().
                        contentType(ContentType.JSON).
                        auth().preemptive().basic(username,password).
                   when().
                        get(getEntpoint);
        return response;
    }

    @Test
    public void TC1101() {
        /*"1.  Kullanici adi  ""ozkan1"" ve sifresi ""JQ3iPpTEKTLjSQJ!"" olan
         * kullanicinin kitaplarindan ""9781449325862"" isbn li kitabi ""9781593277574"" isbnli kitap ile degistiriniz.
         * response un ""application/json"" tipinde oldugunu
         * Status kodunun un 200 oldugunu dogrulayiniz.         */
        getUserBooks();
        json = response.jsonPath();
        System.out.println("Once : "+ json.getList("books.isbn"));

        putMethod(username,password,"9781593277574","9781449325862");
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json");
        json = response.jsonPath();
        Assert.assertFalse(json.getList("books.isbn").contains("9781449325862"));

        System.out.println("sonra :" + json.getList("books.isbn"));

    }

    @Test
    public void TC1102(){
        /*2. Kullanici adi  ""ozkan1"" ve sifresi ""JQ3iPpTEKTLjSQJ!"" olan
         * kullanicinin ""9781593277574"" isbn li kitabin kullanicinin listesinde oldugunu dogrulayiniz.
         * kullanicinin kitaplarindan ""9781593277574""  isbn li kitabi ""9781491950296"" isbnli kitap ile degistiriniz.
         * Status kodunun un 200 oldugunu dogrulayiniz.
         * ""9781593277574"" isbn li kitabin kullanicin listesinde artik  olmadigini dogrulayiniz.
         * Bug bulduysaniz sebebini aciklayiniz. (1. Test caseden farkini aciklayiniz)         */
        getUserBooks();

        json = response.jsonPath();
        System.out.println("Once : "+ json.getList("books.isbn"));
        Assert.assertTrue(json.getList("books.isbn").contains("9781593277574"));

        putMethod(username,password,"9781491950296","9781593277574");
        json = response.jsonPath();
        System.out.println("Sonra : "+ json.getList("books.isbn"));

        response.
                then().
                assertThat().
                statusCode(200);
        Assert.assertFalse(json.getList("books.isbn").contains("9781593277574"));

    }

    @Test
    public void TC1103(){
        /*3. Kullanici adi  ""ozkan1"" ve sifresi ""JQ3iPpTEKTLjSQJ!"" olan
         * kullanicinin kitaplarindan ""9781449331818"" isbn li kitabi 9781449337711 (integer olarak giriniz) isbnli
         * kitap ile guncelleyiniz.
         * response un ""application/json"" tipinde oldugunu
         * Status kodunun un 400 oldugunu dogrulayiniz."        */
        getUserBooks();

        json = response.jsonPath();
        System.out.println("TC03 mevcut Liste :"+ json.getList("books.isbn"));

        putMethod(username,password,9781449337711.0,"9781449331818");

        response.
                then().
                assertThat().
                statusCode(400).
                contentType("application/json");
    }

    @Test
    public void TC1104(){
        /*4. Kullanici adi  ""ozkan1"" ve sifresi ""WrNg!Def123KZW"" olan
         * kullanicinin kitaplarindan ""9781449331818"" isbn li kitabi 9781449337711 (integer) isbnli kitap ile guncelleyiniz
         * Status kodunun un 401  oldugunu
         * Responstaki hata mesajinin   ""User not authorized!"" ve hata kodunun ""1200"" oldugunu dogrulayiniz."   */
        getUserBooks();

        json = response.jsonPath();

        String wrongPassword = "WrNg!Def123KZW";
        putMethod(username,wrongPassword,9781449337711l,"9781449331818");
        response.
                then().
                assertThat().
                statusCode(401);

        json = response.jsonPath();

        Assert.assertEquals(json.getString("code"),"1200");
        Assert.assertEquals(json.getString("message"),"User not authorized!");

    }
}

