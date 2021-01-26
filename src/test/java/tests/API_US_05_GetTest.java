package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;

public class API_US_05_GetTest {

    String entpoint = "https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9";
    Response response;



    public Response getResponse(){
        response = given().
                contentType(ContentType.JSON).
                auth().basic("API_us_05_username","API_us_05_password").
                when().
                get(entpoint);
//        response.prettyPrint();

        return response;

    }

    @Test
    public void TC0501(){
        /*"When I send a GET request to REST API URL with basic authorization Username=Name and password=1234!Name
            demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9
            Then HTTP Status Code should be 401
             And response content type is “application/JSON”
            And take the mesage :""User not authorized!"";"   */
        getResponse();
        JsonPath json = response.jsonPath();
//        System.out.println(getResponse().getContentType());
//        System.out.println(getResponse().statusCode());
//        System.out.println(json.getString("message"));
        response.then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED).contentType("application/json");
        Assert.assertEquals(json.getString("message"),"User not authorized!");
    }

    @Test
    public void TC0502(){
        /*"When I send a GET request to REST API URL
            demoqa.com/Account/v1/User/ff45e996-1a00-4a32-847d-aa7533f32de9
            Then HTTP Status Code should be 401
             And response content type is “application/JSON”
            And take the mesage :""User not found!"";"         */
//        String epoint = "https://demoqa.com/Account/v1/User/{UUID}";
        String epoint = "https://demoqa.com/Account/v1/User/ff45e996-1a00-4a32-847d-aa7533f32de9";
        response = given().
                contentType(ContentType.JSON).
                when().
                get(epoint);
        response.prettyPrint();


    }
    @Test
    public void TC0503(){
        /*"When I send a GET request to REST API URL
                demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9
            Then HTTP Status Code should be 200
            And response content type is “application/JSON”
            And response body should be like;
           {
    ""userId"": ""ee45e996-0a24-4a32-847d-aa7533f32de9"",
    ""username"": ""Vergiler"",
    ""books"": []
          }  }"         */
//        getResponse().prettyPrint();
        getResponse().prettyPeek();


    }
}
