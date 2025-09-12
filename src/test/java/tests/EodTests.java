package tests;

import dataProviders.eodTestPositiveFlowDataProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import model.HTTP_METHORD;
import model.TestDataModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Slf4j
public class EodTests extends BaseTest {
    @Test(priority = 1, testName = "Basic eod api positive tests", dataProvider = "eodTestPositiveFlowDataProvider", dataProviderClass = eodTestPositiveFlowDataProvider.class)
    public void eodTestPositiveFlow(TestDataModel testData){
        log.info("Running test case: {}", testData.getDescription());

        // Use the HTTP method from the TestDataModel
        Response response;
        if (testData.getHttpMethord().equals(HTTP_METHORD.POST)) {
            response = given()
                    .contentType(ContentType.JSON)
                    .body(testData.getPayload())
                    .when()
                    .post(testData.getEndpoint());
        } else if (testData.getHttpMethord().equals(HTTP_METHORD.GET)) {
            response = given()
                    .contentType(ContentType.JSON)
                    .params(testData.getParam())
                    .when()
                    .get(testData.getEndpoint());
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method: " + testData.getHttpMethord());
        }

        response.then().log().body();

        // Use the expected status code from the TestDataModel
        Assert.assertEquals(response.getStatusCode(), testData.getResponseTest().getExpectedStatusCode(),
                "Status code assertion failed for: " + testData.getDescription());

        // Assert specific JSON paths dynamically
        testData.getResponseTest().getJsonPathAssertions().forEach((key, value) -> {
            String actualValue = response.jsonPath().getString(key);
            Assert.assertEquals(actualValue, value,
                    "JSON path assertion failed for key '" + key + "' in test case: " + testData.getDescription());
        });

        log.info("Test case '{}' passed successfully.", testData.getDescription());
    }
    }

