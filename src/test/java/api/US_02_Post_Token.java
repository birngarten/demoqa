package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateUtil;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class US_02_Post_Token {

    String username = "Maria";
    String password = "Maria123!";
    String endpointToken = "https://demoqa.com/Account/v1/GenerateToken";
    Response response;

    Map<String,String> body=new HashMap<>();
    JsonPath json;

    public Response getTokenResponse(String username,String password){
        body.put("userName",username);
        body.put("password",password);

        response=given().
                contentType(ContentType.JSON).
                auth().basic(username,password).body(body).
                when().
                post(endpointToken);

        return  response;
    }




    //Kullanıcı adı ve şifresi doğru olan credentials ile bir token oluşturunuz.+
    // Response status 200 code olduğunu doğrulayınız.
    // Response body.de token geçerlilik süresi olduğunu doğrulayınız.
    // Status "key" degerinin "Success" olduğunu doğrulayınız.
    // "Result" key.inin "User authorized successfully." olduğunu doğrulayınız.
    @Test
    public void TC0201() {
    getTokenResponse(username,password);
    json=response.jsonPath();
   // response.prettyPrint();

    response.then().assertThat().statusCode(200);

        String expires=json.getString("expires").substring(0,10).replace("-","");
        System.out.println(expires);
        int expiresNum=Integer.parseInt(expires);

        String today= DateUtil.todaysDate4().substring(0,10).replace("-","");
        System.out.println(today);
        int todayNum=Integer.parseInt(today);

        Assert.assertTrue(expiresNum>todayNum);


    }

    ///Kullanıcı adı ve şifresi doğru olan credentials ile bir token oluşturunuz.
    // Oluşturulan token'i PostAuthorised API'ında kullanarak teken'ın geçerliliğini assert ediniz.

    @Test
    public void TC0202() {
        String endPointAutorized="https://demoqa.com/Account/v1/Authorized";
        getTokenResponse(username,password);
        json=response.jsonPath();

        String token=json.getString("token");
      //  System.out.println(token);

        response=given().
                contentType(ContentType.JSON).
                auth().oauth2(token).body(body).when().post(endPointAutorized);

        response.prettyPrint();
        Assert.assertEquals(response,"true");


    }

    //Doğru kullanıcı adi ve yanlış şifre ile teken oluşturmaya çalışınız.
    // Response status code 200 olduğunu doğrulayınız.
    // Response body'in  "token": null,
    //                     "expires": null,
    //                     "status": "Failed",
    //                     "result": "User authorization failed." olduğunu verify ediniz.
    @Test
    public void TC0203() {
        password="123";
        getTokenResponse(username,password);
        json=response.jsonPath();
        //response.prettyPrint();

        response.then().assertThat().statusCode(200).
                body("token", equalTo(null),
                "expires", equalTo(null),
                        "status",equalTo("Failed"),
                "result",equalTo("User authorization failed."));

    }

    //Kullanıcı adı ve şifresi "null" olan credentials ile token oluşturmaya çalışınız.
    //Response status code 200 olduğunu verify ediniz.
    //Response body'nin         "code": "1200",
    // "message": "UserName and Password required." olduğunu verify ediniz.
    @Test
    public void TC0204() {
        username="";
        password="";
        getTokenResponse(username,password);
        json=response.jsonPath();
        response.prettyPrint();

        String code=json.getString("code");
        String message=json.getString("message");

        Assert.assertTrue(code.equals("1200") && message.equals("UserName and Password required."));



    }
}