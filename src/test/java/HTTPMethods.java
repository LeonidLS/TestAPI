import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HTTPMethods {
    public static Response get(String issueId) {

        Response response =
                given().
                        auth().preemptive().basic(BasicConsts.USER_LOGIN, BasicConsts.USER_PSWD).
                        when().
                        get(APIPath.baseURL + APIPath.issuesURL + issueId).
                        then().
                        extract().response();
        return response;
    }
}
