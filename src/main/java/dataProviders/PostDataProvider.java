package dataProviders;
import objects.Post;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class PostDataProvider {

    @DataProvider(name= "PostsVariations")
    public static Object[][] getPostsVariations() {
        List<Object[]> data = new ArrayList<>();
        String scenario;
        Post post;

        //---------------
        scenario = "create a post";
        //---------------
        post = new Post().createNewPost(1,1, "testing tittle 123", "testing body 123");

        data.add(new Object[]{scenario, post});

        return data.toArray(new Object[][]{});
    }
}
