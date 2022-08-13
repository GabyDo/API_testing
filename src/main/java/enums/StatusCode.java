package enums;

public enum StatusCode {
    OK(200),
    RESOURCE_CREATED(201),
    BAD_REQUEST(400),
    UNAUTHORIZED (401),
    FORBIDDEN(403),
    RESOURCE_NOT_FOUND(404),
    SERVER_ERROR(500);

    private Integer code;

    StatusCode(Integer code) {
        this.code = code;
    }

    public Integer value() {return code; }
}
