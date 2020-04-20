package springservlet.deployer.servlets.Assignment8;

import org.springframework.data.mongodb.core.mapping.Document;
import springservlet.deployer.servlets.Assignment7.Response;

import java.util.List;

@Document (collection = "submissions")
public class Submission {

    private List<Response> responses;

    public Submission() {
    }

    public Submission(int id, List<Response> responses) {
        this.responses = responses;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
