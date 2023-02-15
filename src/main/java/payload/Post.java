package payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    @JsonProperty("userId") //if userId in json return is not match with userId inside this class.
    Integer userId;
    Integer id;
    String title;
    String body;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post() { } //no Creators, like default constructor for jackson purpost

    public Post (Integer userId, Integer id, String tittle, String body) {
        this.userId = userId;
        this.id = id;
        this.title = tittle;
        this.body = body;
    }


}
