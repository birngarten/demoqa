package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class deneme {

    String username = "Maria";
    String password = "Maria123!";
    String endPoint = "https://demoqa.com/Account/v1/GenerateToken";

    Map<String, String> jsonBody = new HashMap<>();
    JsonPath json;
    Response response;

    //reusable method
    public Response getTokenResponse(String username, String password) {

        jsonBody.put("userName", username);
        jsonBody.put("password", password);

        response = given().
                contentType(ContentType.JSON).
                auth().basic(username, password).
                body(jsonBody).
                when().
                post(endPoint);

        return response;
    }

    @Test
    public void TC0201() {
        getTokenResponse(username, password);
        json = response.jsonPath();
        //status code validate
        response.then().assertThat().statusCode(200);

        //date validate
        String expires = json.getString("expires").substring(0, 10).replace("-", "");
        System.out.println(expires);
        int expiresNumber = Integer.parseInt(expires);

        String today = DateUtil.todaysDate4().substring(0, 10).replace("-", "");
        System.out.println(today);
        int todayNumber = Integer.parseInt(today);

        Assert.assertTrue(expiresNumber > todayNumber);

        //status key validate
        String statusKey = json.getString("status");
        System.out.println(statusKey);
        Assert.assertEquals(statusKey, "Success");

        //result key validate
        String resultKey = json.getString("result");
        System.out.println(resultKey);
        Assert.assertEquals(resultKey, "User authorized successfully.");
    }

    @Test
    public void TC0202() {
        String endpointAutorized = "https://demoqa.com/Account/v1/Authorized";

        getTokenResponse(username, password);

        json = response.jsonPath();
        String token = json.getString("token");


        Response response2 = given().
                contentType(ContentType.JSON).
                auth().oauth2(token).
                body(jsonBody).
                when().
                post(endpointAutorized);

        response2.prettyPrint();
      //  String body = response2.asString();  //
        Assert.assertEquals(response2.asString(),"true"); //uste de string yapilabilir
    }

    @Test
    public void TC0203() {
        password="123";
        getTokenResponse(username, password);
        json=response.jsonPath();
        //response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).body("token", equalTo(null),
                "expires",equalTo(null),
                "status",equalTo("Failed"),"result",equalTo("User authorization failed."));

    }

    @Test
    public void TC0204() {
        username="";
        password="";
        getTokenResponse(username, password);
        json=response.jsonPath();
        response.prettyPrint();
        String code = json.getString("code");
        String message = json.getString("message");
      //  Assert.assertEquals(code, "1200");
     //   Assert.assertEquals(message, "UserName and Password required.");
        Assert.assertTrue(code.equals("1200") && message.equals("UserName and Password required."));

    }
}
