package apiTestAndPojos;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DemoqaDers1Post {

    Response response;
    String endpoint = "https://demoqa.com/Account/v1/Authorized";
    DemoqaDers1PostPojo obj = new DemoqaDers1PostPojo();
    Map<String,Object> myTestBody = new HashMap<>();
    JsonPath myJason;
    @Test
    public void TC0101Old(){
        //1. yol
//        String body = "{\n" +
//                "  \"userName\": \"ttrycatch\",\n" +
//                "  \"password\": \"JQ3iPpTEKTLjSQJ!\"\n" +
//                "}";

        //2.yol
//        Map<String,String> myTestBody = new HashMap<>();
//        myTestBody.put("userName","ttrycatch");
//        myTestBody.put("password","JQ3iPpTEKTLjSQJ!");
        //3. yol
        //DemoqaDers1PostPojo objem = new DemoqaDers1PostPojo("ttrycatch","JQ3iPpTEKTLjSQJ!");

        //4. yol
        DemoqaDers1PostPojo yeniobjem = new DemoqaDers1PostPojo();
        yeniobjem.setUserName("ttrycatch");
        yeniobjem.setPassword(12346);

        response = given()
                    .contentType(ContentType.JSON)
                    .auth().basic("samet1","ABCabc987+%&")
                    .body(yeniobjem)
                    .when()
                    .post(endpoint);
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
    }
    public Response myPostResponse(Object myBody){
        response = given()
                .contentType(ContentType.JSON)
                .auth().basic("samet1","ABCabc987+%&")
                .body(myBody)
                .when()
                .post(endpoint);
        return response;
    }
    @Test
    public void TC0101(){
        DemoqaDers1PostPojo obj = new DemoqaDers1PostPojo();
        obj.setUserName("ttrycatch");
        obj.setPassword("JQ3iPpTEKTLjSQJ!");
        Assert.assertEquals(myPostResponse(obj).prettyPrint(),"true");
        //Assert.assertEquals(myPostResponse(obj).getStatusCode(),200);
        myPostResponse(obj).then().assertThat().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
    }
    @Test
    public void TC0102(){
        obj.setUserName("123456");
        obj.setPassword("JQ3iPpTEKTLjSQJ!");
        Assert.assertEquals(myPostResponse(obj).prettyPrint(),"false");
    }
    @Test
    public void TC0103(){
        obj.setUserName("123456");
        obj.setPassword("Abcd");
        myPostResponse(obj).then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
        myJason = myPostResponse(obj).jsonPath();
        Assert.assertEquals(myJason.getString("message"),"User not found!");
    }
    @Test
    public void TC0104(){
        myTestBody.put("userName","123456");
        myTestBody.put("password","");
        myPostResponse(myTestBody).then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
        myJason = myPostResponse(myTestBody).jsonPath();
        assertEquals(myJason.getString("message"),"UserName and Password required.");
    }
}
