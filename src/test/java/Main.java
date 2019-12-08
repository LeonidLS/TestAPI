import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main implements Pojo{
    public static void main(String[] args) {
        Fields fields = new Fields();
        fields.setProject("10000");
        fields.setAssignee("webinar5");
        fields.setIssueType("Bug");
        fields.setSummary("Test");

        String resultingJSON = extractPOJO(fields);

        System.out.println("RESULT: " + resultingJSON);
    }

    public static String extractPOJO(Pojo pojo) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;

        try {
            result = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
