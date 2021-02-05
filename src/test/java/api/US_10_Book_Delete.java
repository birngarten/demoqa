package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class US_10_Book_Delete {


    Response response;
    JsonPath json;
    String validIsbn ="9781491904244";
    String validUserName = "ozkan1";
    String validPassword = "JQ3iPpTEKTLjSQJ!";

    public Response deleteUserBook(String userName, String password, String isbn ) {
        String endPoint = "https://demoqa.com/BookStore/v1/Book";

        Map<String,Object> deleteBody = new LinkedHashMap<>();
        deleteBody.put("isbn",isbn);
        deleteBody.put("userId","0918fbb4-0298-4cbc-a462-ad5ffc823dc5");

        Response responseDelete = given().
                contentType(ContentType.JSON).
                auth().preemptive().basic(userName,password).
                body(deleteBody).
                when().
                delete(endPoint);
        return responseDelete;
    }

// Response status code.un 204 olduğunu verify edin.
// Response headers.in ………olduğunu verify edin.
// Response body.in “1” olduğunu verify edin.

    @Test
    public void TC10_01() {

        response = deleteUserBook(validUserName,validPassword,validIsbn);
        response.then().
                assertThat().
                statusCode(204).
                headers("Connection", Matchers.equalTo("keep-alive"),
                        "X-Powered-By", Matchers.equalTo("Express")
                );
        Assert.assertEquals(response.getBody().asString(),"");

    }


// Kullanıcı yanlış şifre ile hesabındaki kitapları silememelidir.
// Response status code.un 401 olduğunu verify edin.
// Response body.nin "code": "1200",
// "message": "User not authorized!" şeklinde olduğunu verify edin.

    @Test
    public void TC10_02() {
        String invalidPassword = "InValidSifre123";
        validIsbn = "9781593275846";

        response = deleteUserBook(validUserName,invalidPassword,validIsbn);

        response.
                then().
                assertThat().
                statusCode(401);

        json = response.jsonPath();
        Map<String,String> allData = json.getMap("$");

        Assert.assertEquals(allData.get("code"),"1200");
        Assert.assertEquals(allData.get("message"),"User not authorized!");
    }


// Kullanıcı herhangi bir authorization verisi girmeden hesabındaki kitapları silememelidir.
// Response status code.un 401 olduğunu verify edin.
// Response body.nin "code": "1200",
// "message": "User not authorized!" şeklinde olduğunu verify edin.

    @Test
    public void TC10_03() {
        validIsbn = "9781593275846";
        response = deleteUserBook("","",validIsbn);
        response.then().
                assertThat().
                statusCode(401).
                body("code",Matchers.equalTo("1200"),
                        "message",Matchers.equalTo("User not authorized!"));
    }

// Kullanıcı hesabında bulunmayan herhangi bir kitabı sildiğinde, kitabın ilgili hesapta yer almadığını bildirmelidir.
// Response status code.un 400 olduğunu verify edin.
// Response body.nin "code": "1206",
// "message": "ISBN supplied is not available in User's Collection!" şeklinde olduğunu verify edin.

    @Test
    public void TC10_04() {
        String notExistIsbn = "9781491904244";
        response = deleteUserBook(validUserName,validPassword,notExistIsbn);
        response.then().
                assertThat().
                statusCode(400).
                body("code",Matchers.equalTo("1206"),
                        "message",Matchers.equalTo("ISBN supplied is not available in User's Collection!")
                );
    }


// Kullanıcı isnb numarası olarak "null" isbn kodu sildiğinde, kitabın ilgili hesapta yer almadığını bildirmelidir.
// Response status code.un 400 olduğunu verify edin.
// Response body.nin "code": "1206",
// "message": "ISBN supplied is not available in User's Collection!" şeklinde olduğunu verify edin.


    @Test
    public void TC10_05() {
        String nullIsbn = null;
        response = deleteUserBook(validUserName,validPassword,nullIsbn);

        response.then().
                assertThat().
                statusCode(400).
                body("code",Matchers.equalTo("1206"),
                        "message", Matchers.equalTo("ISBN supplied is not available in User's Collection!")
                );
    }
}

