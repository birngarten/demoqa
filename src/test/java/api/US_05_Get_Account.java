package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojos.Book;
import pojos.DemoqaGetPojo;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US_05_Get_Account {



    Response response;
    JsonPath json;
    ObjectMapper objectMapper = new ObjectMapper();
    DemoqaGetPojo demoqaGetPojo = new DemoqaGetPojo();
    Book book = new Book();

    @Test
    public void TC0501(){
    /*"When I send a GET request to REST API URL with basic authorization Username=Name and password=1234!Name
            https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9
            Then HTTP Status Code should be 401
             And response content type is “application/JSON”
            And take the mesage :""User not authorized!"";"   */

        String endpoint = "https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9";

        response = given().
                contentType(ContentType.JSON).
                auth().basic("Name","1234!Name").
                when().get(endpoint);
//        response.prettyPrint();

        json = response.jsonPath();
        System.out.println(response.contentType());
        System.out.println(response.statusCode());
        System.out.println(json.getString("message"));

        response.
                then().
                assertThat().
                statusCode(HttpStatus.SC_UNAUTHORIZED).
                contentType("application/json");
        assertEquals(json.getString("message"),"User not authorized!");
    }

    @Test
    public void TC0502(){
        /*  "When I send a GET request to REST API URL
             https://demoqa.com/Account/v1/User/ff45e996-1a00-4a32-847d-aa7533f32de9
             Then HTTP Status Code should be 401
             And response content type is “application/JSON”
             And take the mesage :""User not found!"";"    */

        String endpoint = "https://demoqa.com/Account/v1/User/ff45e996-1a00-4a32-847d-aa7533f32de9";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ik5hbWUiLCJwYXNzd29yZCI6IjEyMzQh" +
                "TmFtZSIsImlhdCI6MTYxMTgzMjU3M30.kWlx0OLjcD26g90aH_eH2CPB9hRocrK36RKpNcKrELo";
        response = given().
                contentType(ContentType.JSON).
                auth().oauth2(token).
                when().
                get(endpoint);
//        response.prettyPrint();

        json = response.jsonPath();
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(json.getString("message"));
        response.then().assertThat().statusCode(401).contentType("application/json");
        assertEquals(json.getString("message"),"User not found!");
    }
    @Test
    public void TC0503(){
        /*"When I send a GET request to REST API URL
            https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9
            Then HTTP Status Code should be 200
            And response content type is “application/JSON”
            And response body should be like;
           {
    ""userId"": ""ee45e996-0a24-4a32-847d-aa7533f32de9"",
    ""username"": ""Vergiler"",
    ""books"": []
          }  }"         */
//        getResponse().prettyPrint();
        String endpoint03 = "https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlZlcmdpbGVyIiwicGFzc3dvcmQiOiIxM" +
                "jM0IU5hbWUiLCJpYXQiOjE2MTE3NzY1MTV9.2xJkmuRiGVZDZWOfp_v3gcfvNLyvzY8X5XYxXg4UhR4";

        response = given().
                auth().oauth2(token).
                when().
                get(endpoint03);
        response.prettyPrint();

        json = response.jsonPath();
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(json.getString("userId")+" - "
                + json.getString("username")+" - " + json.getString("books"));

        response.
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                body("userId", equalTo("ee45e996-0a24-4a32-847d-aa7533f32de9"),
                        "username",equalTo("Vergiler"));
        assertEquals(json.getString("books"),"[]");

    }

    @Test
    public void TC0504() throws IOException {
    /*"When I send a GET request to REST API URL
            https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9
            Then HTTP Status Code should be 200
            And response content type is “application/JSON”
            And ""username""  schould be ""Name"",  And user has two books
            And first book data should be like;
         {
            ""isbn"": ""9781449325862"",
            ""title"": ""Git Pocket Guide"",
            ""subTitle"": ""A Working Introduction"",
            ""author"": ""Richard E. Silverman"",
            ""publish_date"": ""2020-06-04T08:48:39.000Z"",
            ""publisher"": ""O'Reilly Media"",
            ""pages"": 234,
            ""description"": ""This pocket guide is the perfect on-the-job companion to Git, the distributed
                            version control system. It provides a compact, readable introduction to Git for new
                  users, as well as a reference to common commands and procedures for those of you with Git exp"",
            ""website"": ""http://chimera.labs.oreilly.com/books/1230000000561/index.html""
        }
   " */

        String endpoint = "https://demoqa.com/Account/v1/User/71a98051-8e31-4949-a311-eda781a1f4d0";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ik5hbWUiLCJwYXNzd29yZCI6IjEyMzQhT" +
                "mFtZSIsImlhdCI6MTYxMTg2NjcyMn0.kQj9sryhAKUKDCFYvijuups7k2kaXE4MKWQa7Pd2zUs";
        response = given().
                accept(ContentType.JSON).
                auth().oauth2(token).
                when().
                get(endpoint);
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/JSON");

        json = response.jsonPath();

        System.out.println(json.getString("username"));

//        System.out.println(demoqaGetPojo.getUsername()); //*** goruldugu gibi null verdi. Cunku ici bos.
//
//        demoqaGetPojo = objectMapper.readValue(response.asString(),DemoqaGetPojo.class);
//        System.out.println(demoqaGetPojo.getUsername());
//        assertEquals(demoqaGetPojo.getUsername(),"Name");
//        assertEquals(demoqaGetPojo.getBooks().get(0).getIsbn(),"9781449325862");
//        assertEquals(demoqaGetPojo.getBooks().get(0).getTitle(),"Git Pocket Guide");
//        assertEquals(demoqaGetPojo.getBooks().get(0).getSubTitle(),"A Working Introduction");
//        assertEquals(demoqaGetPojo.getBooks().get(0).getAuthor(),"Richard E. Silverman");
//        assertEquals(demoqaGetPojo.getBooks().get(0).getPublishDate(),"2020-06-04T08:48:39.000Z");
//        assertEquals(demoqaGetPojo.getBooks().get(0).getPublisher(),"O'Reilly Media");
//        assertTrue(demoqaGetPojo.getBooks().get(0).getPages()==234);
//        assertTrue(demoqaGetPojo.getBooks().get(0).getDescription().startsWith("This pocket guide is the perfect"));
//        String website = "http://chimera.labs.oreilly.com/books/1230000000561/index.html";
//        assertEquals(demoqaGetPojo.getBooks().get(0).getWebsite(),website);

//    }
}

}
