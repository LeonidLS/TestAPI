import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JIRAApiTest {

    public String issueId = "/WEBINAR-11667";
    public String userLogin = "webinar5";
    public String userPswd = "webinar5";
    public String jiraIssueUrl = "http://jira.hillel.it/rest/api/2/issue/";

    public static String createdIssueId;


    public String getIssueGetResponse(String issueId) {
        Response response =

                given().
                        auth().preemptive().basic(userLogin, userPswd).
                        when().
                        get(jiraIssueUrl + issueId).
                        then().
                        extract().response();
        return Integer.toString(response.statusCode());
    }

    public String deleteIssueGetResponse(String issueId) {
        Response response =

                given().
                        auth().preemptive().basic(userLogin, userPswd).
                        when().
                        delete("https://jira.hillel.it/rest/api/2/issue" + issueId).
                        then().
                        extract().response();
        return Integer.toString(response.statusCode());
    }


    @Test
    public void getExistingIssue() {

        Response response =

                given().
                        auth().preemptive().basic("webinar5", "webinar5").
                        when().
                        get("https://jira.hillel.it/rest/api/2/issue" + issueId).
                        then().
                        extract().response();

        assertEquals(response.statusCode(), 200);

        assertEquals(issueId, response.path("key"));

        final Matcher<String> matcher = new MatchesPattern(Pattern.compile("[A-Z]+-[0-9]+"));
        assertTrue(matcher.matches(issueId));
    }

    @Test
    public static void createIssue() {

        String issueJSON = JiraJSONObjects.newIssueJSON();

        Response response = given().
                auth().preemptive().basic("webinar5", "webinar5").
                header("Content-Type", "application/json").
                body(issueJSON).
                when().
                post("https://jira.hillel.it/rest/api/2/issue").
                then().
                extract().response();

        assertEquals(response.statusCode(), 201);
        createdIssueId = response.then().extract().path("id");
    }

    @Test
    public void createAndDeleteIssue() {
        createIssue();
        assertTrue(deleteIssueGetResponse(createdIssueId).equals("204"));
        assertEquals(getIssueGetResponse(createdIssueId), "404");
    }


    @Test
    public void getJiraIssueAPISteps(){
        Response response = HTTPMethods.get(issueId);
        assertEquals(200, response.statusCode());
    }
}
