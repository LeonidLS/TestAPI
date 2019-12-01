
import org.json.simple.JSONObject;

public class JiraJSONObjects {
    public static String newIssueJSON() {
        JSONObject newIssueJSON = new JSONObject();

        JSONObject fields = new JSONObject();

        JSONObject issueType = new JSONObject();

        JSONObject project = new JSONObject();

        JSONObject assignee = new JSONObject();

        project.put("key", "WEBINAR");


        issueType.put("name", "Bug");
        assignee.put("name", "webinar5");

        fields.put("project", project);
        fields.put("summary", "REST from the code");
        fields.put("issuetype", issueType);

        fields.put("assignee", assignee);

        newIssueJSON.put("fields", fields);

        return newIssueJSON.toJSONString();


        /*JSONObject newIssueJSON = new JSONObject();
        JSONObject fields = new JSONObject();
        fields.put("summary", "Artur Test Summary");
        JSONObject issueType = new JSONObject();
        issueType.put("id", "10107");
        JSONObject project = new JSONObject();
        project.put("id", "11400");
        JSONObject assignee = new JSONObject();
        assignee.put("name", "webinar5");

        fields.put("issueType", issueType);
        fields.put("project", project);
        fields.put("assignee", assignee);

        newIssueJSON.put("fields", fields);
        return newIssueJSON.toJSONString();*/
    }
}
