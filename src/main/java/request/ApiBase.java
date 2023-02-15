package request;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

import io.restassured.specification.RequestSpecification;

public class ApiBase {

    protected static RequestSpecification getBaseRequestSpecification(String baseUrl, String basePath) {
        assert baseUrl != null : "The baseUrl is required for RequestSpecification";
        assert basePath != null : "The base path is required for RequestSpecification";

        if (basePath.startsWith("/")) {
            basePath = basePath.substring(1);
        }

        LogConfig logConfig = LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails();
        return RestAssured.given()
                .config(RestAssured.config().logConfig(logConfig))
                .basePath(basePath)
                .baseUri(baseUrl);
    }

    /*** abstract implementation
     *
     */
//    public abstract class ApiBase {
//        String baseUrl = "https://restful-booker.herokuapp.com";
//
//        abstract RequestSpecification getURL();
//
//    }
}
