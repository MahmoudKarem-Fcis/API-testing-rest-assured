package tests;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.*;
import utils.ApiUtils;

import java.util.HashMap;
import java.util.Map;

public class UserTests {
    private String baseUrl;
    private String userId;

    @BeforeClass
    public void setup() {
        baseUrl = ConfigManager.get("base_url");
        RestAssured.baseURI = baseUrl;
    }


    @Test(priority = 1)
    public void createUser() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Mahmoud");
        requestBody.put("job", "QA Engineer");

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json").header("x-api-key","reqres-free-v1")  //this header is used for solving 401 authorization error
                .body(requestBody)
                .post("/api/users");  //https://reqres.in/api/users

        response.then().log().all();
        ApiUtils.validateStatusCode(response, 201);

        userId = response.jsonPath().getString("id");
        ApiUtils.validateJsonField(response, "name", "Mahmoud");
        System.out.println("User ID: " + userId);
    }

    @Test(priority = 2, dependsOnMethods = "createUser")
    public void getUser() {
        Response response = RestAssured
                .given()
                .header("x-api-key","reqres-free-v1")
                .get("/api/users/" + userId);
        System.out.println("User ID: " + userId);


        response.then().log().all();
        // Asserting expected status code is 404 as the newly created user is not available in the database
        ApiUtils.validateStatusCode(response, 200);

    }

    @Test(priority = 3, dependsOnMethods = "createUser")
    public void updateUser() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Mahmoud");
        requestBody.put("job", "Senior QA");

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json").header("x-api-key","reqres-free-v1")
                .body(requestBody)
                .put("/api/users/" + userId);

        response.then().log().all();
        ApiUtils.validateStatusCode(response, 200);
        ApiUtils.validateJsonField(response, "job", "Senior QA");
    }
}