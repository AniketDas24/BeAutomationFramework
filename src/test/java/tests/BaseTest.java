package tests;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static model.Constants.configPropertiesFilePath;

@Slf4j
public class BaseTest {
    @BeforeSuite
    public void setup(){
        log.info("SetUp method called!");
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(configPropertiesFilePath);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = properties.getProperty("api.baseUrl");
        log.info("Base Url is set as {}", RestAssured.baseURI);
    }
}
