package Test;

import dataprovider.PostDataProvider;
import org.assertj.core.api.Assertions;
import payload.Post;
import enums.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import request.PostRequestApi;



import static org.testng.Assert.assertEquals;

public class PostApiTest extends TestBase {

    @Test
    public void testGetSinglePostRequest() {
        String id = "1";
        Response response = PostRequestApi.getPost(id);
        response.prettyPrint();

        //verify status and response
        assertEquals(response.getStatusCode(), 200);

        Post expectedPost = new Post(1, 1, "abc", "abc");
        Post actualResult = response.getBody().as(Post.class);
        Assertions.assertThat(actualResult)
                .as("")
                .usingRecursiveComparison()
                .isEqualTo(expectedPost);


//
//        // verification
//        String jsonPath = ",";
//        List<Comment> comments = response.getBody().jsonPath().getList(jsonPath, Comment.class);
//
////        String id;
//        for (Comment eachComment : comments) {
//            assert id : eachComment.getId()
//        }

        //       Comment commentWithWrongPostId = comments.stream().filter(item -> item.getPostId()!= 1).findAny().orElse(null);
//        List<Integer> postId = comments.stream()
//                .filter(item -> item.getPostId() != 1)
//                .map(item -> item.getPostId())
//                .collect(Collectors.toList());
//        assertThat(comments.size()).as("expected number of record with").isEqualTo(0);
    }


    @Test( dataProvider = "PostsVariations", dataProviderClass = PostDataProvider.class)
    public void testPostRequestWithDataDriven( String scenario, Post post) {
        //        Map<String, Object> queryParameters = new HashMap<>();
//        queryParameters.put("postId", "1");
    }
}

