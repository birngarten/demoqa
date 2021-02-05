package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateUtil;
import static io.restassured.RestAssured.given;

public class US_09_Get_Book {

    Response response;
    String endPoint ="https://demoqa.com/BookStore/v1/Book";
    String isbnNumber = "9781593277574";
    JsonPath jsonPath;

    Response getResponse(String endPoint, String isnbNumber){
        response = given().queryParam("ISBN",isnbNumber).when().get(endPoint);
        return response;
    }


    @Test
    public void TC0901(){
        //Kullanici BookStore-Get'i acabilmeli ve ISBN Kutucuguna "9781593277574" ISBN kodunu girip execute edebilmelidir. (Assert)
        //autorizasyon.a gerek yok. api public olarak yazılmıs.
        //response = given().queryParam("ISBN",isbnNumber).when().get(endPoint);
        //bu responsu dinamik olarak yukarıya tanımlıyoruz.
        Assert.assertNotEquals(getResponse(endPoint, isbnNumber), null);
    }


    @Test
    void TC0902(){
        //    Kullanici "9781593277574" ISBN kodunu girdiginde ve execute ettiginde sirasiyla asagidakilerini Verify edebilmelidir:
        //            1. Status codun==> 200 oldugunu,
        //            2. "subTitle" in ==> "The Definitive Guide for JavaScript Developers" oldugunu,
        //            3. "publish_date" in ==> "2016-09-03T00:00:00.000Z" oldugunu
        //            4.  "pages" in==> 352 oldugunu,
        //            5. "description" inin ==> "ECMAScript 6 represents the biggest update" ile baslayip,
        //              "that E" ile bittigini ve icinde "expert developer Nicholas C. Zakas" isminin gectigini,
        //            6. Söz konusu Kitabin Download edilip edilmedigini.(???)
            Response response1 = getResponse(endPoint,isbnNumber);
            response1.then().assertThat().statusCode(HttpStatus.SC_OK).
                            body("subTitle", Matchers.equalTo("The Definitive Guide for JavaScript Developers"),
                             "publish_date", Matchers.equalTo("2016-09-03T00:00:00.000Z"),
                              "pages", Matchers.equalTo(352));
            jsonPath = response.jsonPath();
            String description = jsonPath.getString("description");
            Assert.assertTrue(description.startsWith("ECMAScript 6 represents the biggest update")&&
                                    description.endsWith("that E")&&
                                    description.contains("expert developer Nicholas C. Zakas"));
    }
//      bu method dateutil içinde yer almaktadir.
//    String returnTime(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd MMM yyy");
//        LocalDateTime now = LocalDateTime.now();
//                yyyy-MM-dd	"1988-09-29"
//        dd/MM/yyyy	"29/09/1988"
//        dd-MMM-yyyy	"29-Sep-1988"
//        E, MMM dd yyyy	"Thu, Sep 29 1988"
//         E, dd MMM yyy HH:mm:ss 'GMT'
//        return dtf.format(now);
//    }

    @Test
    void TC0903(){
        //    Kullanici "9781593277574" ISBN kodunu girdiginde cikan Response Headers' ta sirasiyla asagidakilerini dogrulayabilmelidir:
        //            1. "content-length" in ==>560  oldugunu,
        //            2. "content-type" in ==> "application/json; charset=utf-8" oldugunu,
        //            3. "date" in test yapilan gündeki, güncel tarih zaman dilimi oldugunu,
        //        4.  "server" ==> in  "nginx/1.17.10 (Ubuntu)" oldugunu
        Response response1 = getResponse(endPoint,isbnNumber);
        //headers ile bütün headerlerı aynı assertion ile assert etmek mümkün.
        response1.then().assertThat().headers("content-length",Matchers.equalTo("560")
                                             ,"content-type",Matchers.equalTo("application/json; charset=utf-8"),
                                                            "server",Matchers.equalTo("nginx/1.17.10 (Ubuntu)"));
        Assert.assertEquals(response1.getHeader("date").substring(0,16), DateUtil.returnTime());
    }



}
