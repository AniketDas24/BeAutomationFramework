package tests;

import dataProviders.eodTestPositiveFlowDataProvider;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import model.TestDataModel;
import org.testng.annotations.Test;
import utils.RestUtil;
import utils.RetryAnalyser;
import utils.ValidationUtil;

@Slf4j
public class EodTests extends BaseTest {
    @Test(priority = 1, testName = "Basic eod api positive tests", dataProvider = "eodTestPositiveFlowDataProvider", dataProviderClass = eodTestPositiveFlowDataProvider.class, retryAnalyzer = RetryAnalyser.class)
    public void eodTestPositiveFlow(TestDataModel testData){
        log.info("Running test case: {}", testData.getDescription());
        Response response = RestUtil.makeRestCall(testData.getRequestData(), requestSpecification);
        response.then().log().body();
        log.info("Response validation started for testcase : {}", testData.getDescription());
        ValidationUtil.validateResponse(response, testData.getResponseData());
        log.info("Test case '{}' passed successfully.", testData.getDescription());
    }
    }

