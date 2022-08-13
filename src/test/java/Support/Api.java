package Support;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Map;

public class Api {
    public static JsonSerializer<Date> serializer = (src, typeOfSrc, context) -> new JsonPrimitive(src.toInstant().toString());


// use static in class level, we dont have create new object when calling it.
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

    public static Response postApi(String jsonBody, String baseUri, String basePath) {
        RequestSpecification requestSpecification = RestAssured.given().config(RestAssured.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()));
        requestSpecification
                .baseUri(baseUri)
                .basePath(basePath);
        return requestSpecification
                // .header(getAuthorizationHeader)
                .contentType("application/json")
                .body(jsonBody)
                .post();
    }

    public static Response postApiWithObject(Object object, String baseUri, String basePath) {
        return postApi(customGson.toJson(object), baseUri, basePath);
    }

    public static Gson customGson = new GsonBuilder()
            .registerTypeAdapter(Date.class, serializer)
            //.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter())
            .create();

}



