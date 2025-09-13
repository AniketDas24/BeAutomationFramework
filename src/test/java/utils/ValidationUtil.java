package utils;

import io.restassured.response.Response;
import model.ResponseData;
import org.testng.Assert;

public class ValidationUtil {
    public static void validateResponse(Response actualResponse , ResponseData expectedResponse){
        Assert.assertEquals(actualResponse.getStatusCode(), expectedResponse.getExpectedStatusCode(),
                "Status code assertion failed! " );
        expectedResponse.getJsonPathAssertions().forEach((key, value) -> {
            String actualValue = actualResponse.jsonPath().getString(key);
            Assert.assertEquals(actualValue, value,
                    "JSON path assertion failed for key : "+  key);
        });
    }
}
