package utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";
    private static final String REGISTER_ENDPOINT = "/register";
    private static final String LOGIN_ENDPOINT = "/login";
    private static final String USER_ENDPOINT = "/user";

    public static Response createUser(String email, String password, String name) {
        User user = new User(email, password, name);
        return given()
                .header("content-type", "application/json")
                .body(user)
                .when()
                .post(BASE_URL + REGISTER_ENDPOINT);
    }

    public static String getToken(String email, String password) {
        User user = new User(email, password);
        return given()
                .header("content-type", "application/json")
                .body(user)
                .when()
                .post(BASE_URL + LOGIN_ENDPOINT)
                .then()
                .extract().path("accessToken");
    }

    public static void deleteUser(String token) {
        given()
                .header("authorization", token)
                .when()
                .delete(BASE_URL + USER_ENDPOINT)
                .then()
                .assertThat()
                .statusCode(202);
    }
}
