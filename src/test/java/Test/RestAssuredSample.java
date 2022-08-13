package Test;

import dataProviders.PostDataProvider;
import objects.Post;
import Support.Api;
import enums.StatusCode;
import io.restassured.response.Response;
import objects.Comment;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestAssuredSample extends TestBase {
    private static final  String baseUrl = "https://jsonplaceholder.typicode.com/";

    //https://jsonplaceholder.typicode.com/guide/
    @Test
    public void testGetRequestExample() {
        //prepare query parameters:
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("postId", "1");

        // call get https://jsonplaceholder.typicode.com/comments?postId=1 with status check
        String basePath = "/comments";
        Response response = Api.getApiWithParameters(queryParameters, baseUrl, basePath)
                .then().assertThat().statusCode(StatusCode.OK.value())
                .extract().response();
        response.prettyPrint();

        // verification
        String jsonPath = ",";
        List<Comment> comments = response.getBody().jsonPath().getList(jsonPath, Comment.class);

//        String id;
//        for (Comment eachComment : comments) {
//            assert id : eachComment.getId()
//        }

        //       Comment commentWithWrongPostId = comments.stream().filter(item -> item.getPostId()!= 1).findAny().orElse(null);
        List<Integer> postId = comments.stream()
                .filter(item -> item.getPostId() != 1)
                .map(item -> item.getPostId())
                .collect(Collectors.toList());
        assertThat(comments.size()).as("expected number of record with").isEqualTo(0);
    }

    @Test( dataProvider = "PostsVariations", dataProviderClass = PostDataProvider.class)
    public void testPostRequestExample( String scenario, Post post) {
    //https://jsonplaceholder.typicode.com/posts
        String basePath = "/posts";

        Response response = Api.postApiWithObject(post, baseUrl, basePath)
                .then().assertThat().statusCode(StatusCode.RESOURCE_CREATED.value())
                .extract().response();
        response.prettyPrint();
    }
}

