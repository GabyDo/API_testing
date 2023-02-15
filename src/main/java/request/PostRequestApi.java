package request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class PostRequestApi extends ApiBase{
    private static String baseUrl = "https://jsonplaceholder.typicode.com";
    private static String basePath = "posts";
    private static String pathParameter = "{id}";


    private static RequestSpecification getBookingsApi() {
        return getBaseRequestSpecification( baseUrl, basePath);
    }

    private static RequestSpecification getBookingApi() {
        return getBaseRequestSpecification( baseUrl, String.format("%s/%s", basePath, pathParameter));
    }



    /////////////////////////
    public static  Response getPosts(Map<String, String> parameterQuery){
        return getBookingsApi()
                .queryParams(parameterQuery)
                .get();
    }

    public static Response getPost( String id){
        return getBookingApi()
                .pathParam("id" , id)
                .get();
    }




    /***
     * abstract implementation
     */
//    public class BookingRequestApi extends ApiBase{
//        String basePath = "booking";
//
//        @Override
//        RequestSpecification getURL() {
//            return getBaseRequestSpecification(baseUrl, basePath);
//        }

}
