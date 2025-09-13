package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static model.Constants.configPropertiesFilePath;

@Slf4j
public class BaseTest {
    public static final Properties config = new Properties();
    protected static RequestSpecification requestSpecification;
    @BeforeSuite
    public void setup(){
        log.info("SetUp method called!");
        try {
            FileInputStream fis = new FileInputStream(configPropertiesFilePath);
            config.load(fis);
            log.info("Base Url is set as {}", RestAssured.baseURI);
            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(config.getProperty("api.baseUrl"))
                    .addParam("access_key", config.getProperty("api.accessKey"))
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
