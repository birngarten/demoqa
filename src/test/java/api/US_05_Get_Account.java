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
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US_05_Get_Account {

    Response response;
    JsonPath json;
    DemoqaGetPojo demoqaGetPojo;
    Book book;
    ObjectMapper objectMapper = new ObjectMapper();



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
                  when().
                        get(endpoint);
//        response.prettyPrint();
        json = response.jsonPath();

        response.
                then().
                assertThat().
                statusCode(HttpStatus.SC_UNAUTHORIZED).
                contentType("application/JSON");
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
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFzbGluZmRkZGFhIiwicGFzc3dvcmQiOi" +
                "JBU0xpbmRhMTIzISIsImlhdCI6MTYxMTk1NDc3Mn0.TzxIvi7OM-HUPOC04NFL7jg84DwcYNZKKhHOYtoq618";

        response = given().
                        contentType(ContentType.JSON).auth().oauth2(token).
                   when().
                        get(endpoint);
//        response.prettyPrint();
        json = response.jsonPath();

        response.
                then().
                assertThat().
                statusCode(401).
                contentType("application/JSON");
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
        String endpoint = "https://demoqa.com/Account/v1/User/ee45e996-0a24-4a32-847d-aa7533f32de9";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlZlcmdpbGVyIiwicGFzc3dvcmQiOi" +
                        "IxMjM0IU5hbWUiLCJpYXQiOjE2MTE3NzY1MTV9.2xJkmuRiGVZDZWOfp_v3gcfvNLyvzY8X5XYxXg4UhR4";

        response = given().
                        accept(ContentType.JSON).
                        auth().oauth2(token).
                   when().
                        get(endpoint);
//        response.prettyPrint();
        json = response.jsonPath();

        response.
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType("application/JSON");
        assertEquals(json.getString("userId"),"ee45e996-0a24-4a32-847d-aa7533f32de9");
        assertEquals(json.getString("username"),"Vergiler");
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
                      version control system. It provides a compact, readable introduction to Git for new users,
                      as well as a reference to common commands and procedures for those of you with Git exp"",
            ""website"": ""http://chimera.labs.oreilly.com/books/1230000000561/index.html""
        }   */
        String endpoint = "https://demoqa.com/Account/v1/User/71a98051-8e31-4949-a311-eda781a1f4d0";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ik5hbWUiLCJwYXNzd29yZCI6IjEyMzQhTmFtZ" +
                        "SIsImlhdCI6MTYxMTk1NjM3OX0.96Bakdv_QWzIvCzvdJJKTjupoW1mpUUujkHb3GxrgJs";

        response = given().
                        contentType(ContentType.JSON).
                        auth().oauth2(token).
                    when().
                        get(endpoint);
        response.prettyPrint();
        json = response.jsonPath();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/JSON");
        assertEquals(json.getString("username"),"Name");
        List<String> books = json.getList("books");
        assertTrue(books.size()==2);

        demoqaGetPojo = objectMapper.readValue(response.asString(),DemoqaGetPojo.class);
        assertEquals(demoqaGetPojo.getBooks().get(0).getIsbn(),"9781449325862");
        assertEquals(demoqaGetPojo.getBooks().get(0).getTitle(),"Git Pocket Guide");
        assertEquals(demoqaGetPojo.getBooks().get(0).getSubTitle(),"A Working Introduction");
        assertEquals(demoqaGetPojo.getBooks().get(0).getAuthor(),"Richard E. Silverman");
        assertEquals(demoqaGetPojo.getBooks().get(0).getPublishDate(),"2020-06-04T08:48:39.000Z");
        assertEquals(demoqaGetPojo.getBooks().get(0).getPublisher(),"O'Reilly Media");
        assertTrue(demoqaGetPojo.getBooks().get(0).getPages()== 234);
        assertTrue(demoqaGetPojo.getBooks().get(0).getDescription().startsWith("This pocket guide is the"));
        String website = "http://chimera.labs.oreilly.com/books/1230000000561/index.html";
        assertEquals(demoqaGetPojo.getBooks().get(0).getWebsite(),website);

}

}
