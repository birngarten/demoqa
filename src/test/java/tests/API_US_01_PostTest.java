package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.DemoqaPostPojo;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class API_US_01_PostTest {

    private String username;
    private String password;

    String entpoint = "https://demoqa.com/Account/v1/Authorized";
    Response response;
    DemoqaPostPojo obj = new DemoqaPostPojo();
    Map<String,Object> mapbody = new HashMap<>();

    @Test
    public void TC0101_Old(){
//        1.YOL ==> String ile
//        String body = "{\n" +
//                "  \"userName\": \"ttrycatch\",\n" +
//                "  \"password\": \"JQ3iPpTEKTLjSQJ!\"\n" +
//                "}";

//        2.YOL ==> Map ile
//        Map<String,String> mapbody = new HashMap<>();
//        mapbody.put("userName","ttrycatch");
//        mapbody.put("password","JQ3iPpTEKTLjSQJ!");

//         3.1. YOL POJO parametre ile
//        DemoqaPostPojo demoqaPostPojo = new DemoqaPostPojo("ttrycatch","JQ3iPpTEKTLjSQJ!"); -- A --

//        3.2. YOL POJO obje ile
        DemoqaPostPojo demoqaPostPojo1 = new DemoqaPostPojo(); // -- B --
        demoqaPostPojo1.setUserName("ttrycatch");
        demoqaPostPojo1.setPassword("JQ3iPpTEKTLjSQJ!");


        response = given().
                        contentType(ContentType.JSON).
                        auth().basic("API_us_01_userNmae","API_us_01_password").
                        body(demoqaPostPojo1).
                   when().
                        post(entpoint);
//        response.prettyPrint();
//        System.out.println(response.getContentType());
        response.
                then().
                contentType("application/json").
                statusCode(200).assertThat();
    }
    public Response myPostResponse(Object myBody){ // Tum data bunun icinde artik baska method'larda kullanabilirim
        response = given().
                contentType(ContentType.JSON).
                auth().basic("API_us_01_userNmae","API_us_01_password").
                body(myBody).
                when().
                post(entpoint);
        return response;
    }
    @Test       // 4.YOL ==> Method ile ==> myPostResponse
    public void TC0101(){
//         DemoqaPostPojo obj = new DemoqaPostPojo(); yukarida instance olark var
        obj.setUserName("ttrycatch");
        obj.setPassword("JQ3iPpTEKTLjSQJ!");
//        myPostResponse(obj).prettyPrint();

        Assert.assertEquals(myPostResponse(obj).prettyPrint(),"true");
        myPostResponse(obj).then().assertThat().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON); //statusCode(200)

    }

    @Test
    public void TC0102(){
        obj.setUserName("123456");
        obj.setPassword("JQ3iPpTEKTLjSQJ!");
        myPostResponse(obj).prettyPrint();
        Assert.assertEquals(myPostResponse(obj).prettyPrint(),"false");

    }

    @Test
    public void TC0103(){
        obj.setUserName("123456");
        obj.setPassword("Abcd");
//        myPostResponse(obj).prettyPrint();
        System.out.println(myPostResponse(obj).statusCode());

        myPostResponse(obj).then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);

        JsonPath json = myPostResponse(obj).jsonPath();
        Assert.assertEquals(json.getString("message"),"User not found!");

    }

    @Test
    public void TC0104(){ // Bu methodu Map ile yaptik
        mapbody.put("userName","123456");
        mapbody.put("password","");
//        myPostResponse(mapbody).prettyPrint();
        myPostResponse(mapbody).then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);

        JsonPath json = myPostResponse(mapbody).jsonPath();
        Assert.assertEquals(json.getString("message"),"UserName and Password required.");

    }
}
