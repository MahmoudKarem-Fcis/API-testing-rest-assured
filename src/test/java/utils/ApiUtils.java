package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiUtils {

    public static void validateStatusCode(Response response, int expectedStatus) {
        Assert.assertEquals(response.getStatusCode(), expectedStatus, "Status code mismatch.");
    }

    public static void validateJsonField(Response response, String field, String expectedValue) {
        String actualValue = response.jsonPath().getString(field);
        Assert.assertEquals(actualValue, expectedValue, "Field value mismatch for: " + field);
    }
}