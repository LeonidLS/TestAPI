
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
    }
}
