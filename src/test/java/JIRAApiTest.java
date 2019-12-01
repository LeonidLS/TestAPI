import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JIRAApiTest {

    public String issueId = "WEBINAR-11010";

    @Test
    public void getExistingIssue() {

        Response response =

                given().
                        auth().preemptive().basic("webinar5", "webinar5").
                        when().
                        get("http://jira.hillel.it/rest/api/2/issue/" + issueId).
                        then().
                        extract().response();

        assertEquals(response.statusCode(), 200);

        assertEquals(issueId, response.path("key"));

        final Matcher<String> matcher = new MatchesPattern(Pattern.compile("[A-Z]+-[0-9]+"));
        assertTrue(matcher.matches(issueId));
    }

}
