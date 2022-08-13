package Support;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Api {
// use static in class leve, we dont have create new object when calling it.
    public static Response getApiWithParameters(Map<String, Object> queryParameters , String baseUri, String basePath) {
        RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()));
        requestSpecification
                .baseUri(baseUri)
                .basePath(basePath);
        return requestSpecification
                .header("accept", "*/*")
               // .header(getAuthorizationHeader)
                .queryParams(queryParameters)
                .get();
    }

//    protected static Header getAuthorizationHeader(){
//        return new Header("Authorization", String.format())
//
//    }
}
