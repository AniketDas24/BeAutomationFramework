package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.RequestData;
import model.httpMethord;
import static io.restassured.RestAssured.given;

public class RestUtil {
    public static Response makeRestCall(RequestData requestData, RequestSpecification requestSpecification){
        Response response;
        if (requestData.getHttpMethord().equals(httpMethord.POST)) {
            response = given(requestSpecification)
                    .contentType(ContentType.JSON)
                    .body(requestData.getPayload())
                    .when()
                    .post(requestData.getEndpoint());
        } else if (requestData.getHttpMethord().equals(httpMethord.GET)) {
            response = given(requestSpecification)
                    .contentType(ContentType.JSON)
                    .params(requestData.getParam())
                    .when()
                    .get(requestData.getEndpoint());
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method: " + requestData.getHttpMethord());
        }
        return response;
    }
}
