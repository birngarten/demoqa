package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pojos.DemoqaDers1PostPojo;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class US_04_UserID_Delete {
    Response response;
    JsonPath json;
    DemoqaDers1PostPojo bodyPojo = new DemoqaDers1PostPojo();


    public static String random(int q,int x,int y){
        String randomString="";
        for(int i=0;i<q;i++) {
            char randomChar = (char) ThreadLocalRandom.current().nextInt(x, y);
            randomString += randomChar;
        }
        return randomString;
    }

    public String  name(){
        String upperString= random(3,65,90);
        String lowerString = random(4,97,122);
        String name= upperString+lowerString;
        System.out.println(name);
        bodyPojo.setUserName(name);
        return name;
    }

    public String  password(){
        String upperString= random(2,65,90);
        String lowerString = random(2,97,122);
        String digits = random(2,48,57);
        String specialchar = random(2,33,38);
        String password= upperString+lowerString+digits+specialchar;
        System.out.println(password);
        bodyPojo.setPassword(password);
        return password;
    }

    //UserID üretelim:
    public String UserID(){
        response= given().
                contentType(ContentType.JSON).
                auth().basic(name(),password()).
                body(bodyPojo).
                when().
                post("https://demoqa.com/Account/v1/User");
        response.prettyPrint();
        json= response.jsonPath();
        System.out.println(json.getString("userID"));
        String userID = json.getString("userID");
        return userID;
    }

    //token üretelim:
    public String token(){
        response = given().
                   contentType(ContentType.JSON).
                   auth().basic("samet1","ABCabc987+%&").
                   body(bodyPojo).
                   when().
                   post("https://demoqa.com/Account/v1/GenerateToken");
        response.prettyPrint();
        json = response.jsonPath();
        System.out.println(json.getString("token"));
        String token =json.getString("token");
        return token;
    }


    //dogru token ve dogru id ile user siline bilmektedir. gelen status kodun 204 oldugunu ve response nin
    // {
    //    "code": "1200",
    //    "message": "User not authorized!"
    //}
    //oldugunu verify ediniz
    @Test
    public void deleteWithCorrectToken(){
        String endpoint ="https://demoqa.com/Account/v1/User/"+UserID();

        //kontrol amacli user bilgilerini tekrar yazdiralim:
        System.out.println("UserBilgileri Kontrol:");
        response.prettyPrint();
        System.out.println(response.statusCode());
        response.then().assertThat().body("books", Matchers.hasSize(0));

        //Delete islemine gecelim:
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token())
                .when()
                .delete(endpoint);


        System.out.println(response.statusCode());
        response.prettyPrint();
        response.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);

        //sildigimiz user i tekrar cagirmaya calisalim:
        response = given()
                .contentType(ContentType.JSON)
                .auth().basic(bodyPojo.getUserName().toString(),bodyPojo.getPassword().toString())
                .when()
                .get(endpoint);
        System.out.println("silinen user icin get islemi");
        String mesaj = "{\n" +
                "    \"code\": \"1200\",\n" +
                "    \"message\": \"User not authorized!\"\n" +
                "}";


        assertEquals(response.prettyPrint(),mesaj);
        response.prettyPrint();
    }


    //yanlis token girerek status codun 401 gelen message'in User not authorized! oldugunu kontrol edelim
    @Test
    public void deleteWithWrongToken(){
        String endpoint ="https://demoqa.com/Account/v1/User/"+UserID();

        //kontrol amacli user bilgilerini tekrar yazdiralim:
        System.out.println("UserBilgileri Kontrol:");
        response.prettyPrint();

        //Delete islemine gecelim:
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2("sadsfdsdsafv2342acdavarvasdv.234543432ar2e342343geqrgr541reg6eqr5q1g6eav")
                .when()
                .delete(endpoint);
        System.out.println(response.statusCode());
        System.out.println(response.jsonPath().getString("message"));

        response.then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);

        assertEquals("mesaj istenilen gibi degil","User not authorized!",response.jsonPath().getString("message"));

    }

    //bos token girerek status codun 401 gelen message'in User is unauthorized! oldugunu kontrol edelim
    @Test
    public void deleteWithEmptyToken(){
        String endpoint ="https://demoqa.com/Account/v1/User/"+UserID();

        //kontrol amacli user bilgilerini tekrar yazdiralim:
        System.out.println("UserBilgileri Kontrol:");
        response.prettyPrint();

        //Delete islemine gecelim:
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2("")
                .when()
                .delete(endpoint);
        System.out.println(response.statusCode());
        System.out.println(response.jsonPath().getString("messaage"));
        response.then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);


    }
    //basic authorization ile delete mümkün degildir.
    //status codun 401 gelen message'in User not authorized! oldugunu kontrol edelim
    @Test
    public void deleteWithCorrectIDAndBasicAuthorization(){
        String endpoint ="https://demoqa.com/Account/v1/User/"+UserID();

        //kontrol amacli user bilgilerini tekrar yazdiralim:
        String name= bodyPojo.getUserName().toString();
        String pas = bodyPojo.getPassword().toString();

        System.out.println("UserBilgileri Kontrol:");
        response.prettyPrint();
        System.out.println("name= "+name+"  "+"Pass= "+pas);
        System.out.println("---------------------------Delete islemi-------------------------");

        //Delete islemine gecelim:
        response = given()
                .accept(ContentType.JSON)
                .auth().basic(name,pas)
                .when()
                .delete(endpoint);

        response.prettyPrint();
        System.out.println(response.statusCode());
        response.
                then().
                assertThat().
                statusCode(HttpStatus.SC_UNAUTHORIZED).
                body("message", equalTo("User not authorized!"));

    }

    //yanlis userID girildiginde "User Id not correct!" mesajini vedigini ve status kodun 200 oldugunu dogrulayalim
    @Test
    public void deleteWithWrongUserIDAndCorrectToken(){

        String endpoint ="https://demoqa.com/Account/v1/User/"+UserID();


        System.out.println("--------Delete islemi------");
        //Delete islemine gecelim:
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token())
                .when()
                .delete(endpoint+"2");



        System.out.println(response.statusCode());
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        System.out.println(response.jsonPath().getString("message"));
        assertEquals(response.jsonPath().getString("message"),"User Id not correct!");
    }
}
