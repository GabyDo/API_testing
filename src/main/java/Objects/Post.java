package Objects;

public class Post {
    Integer userId;
    Integer id;
    String tittle;
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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post createNewPost( Integer userId, Integer id, String tittle, String body) {
        this.userId = userId;
        this.id = id;
        this.tittle = tittle;
        this.body = body;

        return this;
    }
}
