package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private String baseURI;
    private static final String USER_CREATION_API = "/api/auth/register";
    private static final String DELETE_USER = "/api/auth/user";

    public UserSteps(String baseURI) {
        this.baseURI = baseURI;
    }

    @Step("Отправляем POST запрос на ручку /api/auth/register")
    public Response createUser(String email, String password, String name) {
        UserData user = new UserData(email, password, name);
        Response creation = given()
                .baseUri(baseURI)
                .log().all()
                .header("Content-type","application/json")
                .and()
                .body(user)
                .when()
                .post(USER_CREATION_API);
        return creation;
    }

    @Step("Получаем Access Token и удаляем пользователя")
    public void getTokenAndDeleteUser(Response creation) {
        String token = creation.then().extract().jsonPath().getString("accessToken");

        Response delete = given()
                .baseUri(baseURI)
                .log().all()
                .header("Authorization",token)
                .when()
                .delete(DELETE_USER);
    }

}
