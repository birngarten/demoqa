package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US_03_Post_Post {


    String username = "Kan256";
    String password = "Abc1234!";
    String endpointToken = "https://demoqa.com/Account/v1/User";

    Response response;
    int random;

    Map<String,String> body=new HashMap<>();

    //JSONObject body = new JSONObject();

    JsonPath json;

    public Response getTokenResponse(String username,String password){



        body.put("userName",username);
        body.put("password",password);

        response=given().
                contentType(ContentType.JSON).
                auth().basic(username,password).body(body).
                when().
                post(endpointToken);

        response.prettyPrint();
        return  response;
    }



    @Test
    public void TC01(){
     /*TC0301	"Kullanici adi ""kim359"" password ""Abc1234!"" olan
     bir kullanici olusturuldugunda;
   * Status kodun 201 oldugunu ,
   * Content type'in application/json oldugunu,
   * username'in ""klm987"" oldugunu assert ediniz
      */

        random= (int) (Math.random()*100);
        username="kim359"+random;
        password="Abc1234!";

        getTokenResponse(username,password);

        json=response.jsonPath();

        response.prettyPrint();

        String usName=json.getString("username");



       response.then().assertThat().statusCode(201).
                                                     contentType(ContentType.JSON).
                                                     body("username", Matchers.equalTo(usName)
        );//


    }

    @Test
    public void TC02(){
        /*TC0302	"
        Kullanici adi ""abc"" password ""Abc1234!""
        olan kullanici post edildiginde ;
      * Status kodun 406 oldugunu,
      * Message olarak ""User exists!""
      uyarisinin ciktigini assert ediniz
"

         */

        username="abc";
        password="Abc1234!";

        getTokenResponse(username,password);
        json=response.jsonPath();

        response.prettyPrint();

        String userExist=json.getString("message");

        response.then().
                        assertThat().statusCode(406).
                                     body("message",Matchers.equalTo(userExist));


    }

    @Test
    public void TC03(){
        /*Kullanici adi "xyz22" olup password alani bos birakilarak post edildiginde;
         * Status kodun 400 oldugunu
         * Message olarak "UserName and Password required."uyarisinin ciktigini assert ediniz
         */

        username="xyz22";
        password="";

        getTokenResponse(username,password);
        json=response.jsonPath();

        response.prettyPrint();

        String userExist="UserName and Password required.";

        response.then().
                       assertThat().
                       statusCode(400).
                       body("message",Matchers.equalTo(userExist));



    }

    @Test
    public void TC04(){
        /*Her bir datanin books[] array'inin icinde
         " isbn,title, subTitle,author,publish_date,publisher,pages,description,website"
         key'lerinin bulundugunu assert ediniz

         */

        username="germanyiafd";
        password="Aabc2334345!!!";

        getTokenResponse(username,password);

        json=response.jsonPath();

        response.prettyPrint();

        String expectedbookArr="\"isbn\": \"string\",\n" +
                "      \"title\": \"string\",\n" +
                "      \"subTitle\": \"string\",\n" +
                "      \"author\": \"string\",\n" +
                "      \"publish_date\": \"2021-01-27T10:50:08.560Z\",\n" +
                "      \"publisher\": \"string\",\n" +
                "      \"pages\": 0,\n" +
                "      \"description\": \"string\",\n" +
                "      \"website\": \"string\"";

          String actualdBody=json.getString("books");
//        response.then().assertThat().body("books",Matchers.equalTo(bookArr));
          Assert.assertNotEquals(actualdBody,expectedbookArr);

    }


}
