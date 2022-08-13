package Test;

import Support.Api;
import io.restassured.response.Response;
import Objects.Comment;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestAssuredSample extends TestBase {
    //https://jsonplaceholder.typicode.com/guide/
    @Test
    public void testResAssuredExample() {
        //prepare query parameters:
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("postId", "1");

        // call get https://jsonplaceholder.typicode.com/comments?postId=1 with status check
        String baseUrl = "https://jsonplaceholder.typicode.com/";
        String basePath = "/comments";
        Response response = Api.getApiWithParameters(queryParameters, baseUrl, basePath)
                .then().assertThat().statusCode(200)
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

        assertThat(comments.size()).as("expecte number of record with").isEqualTo(0);
    }
}

