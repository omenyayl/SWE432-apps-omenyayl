package springservlet.deployer.servlets.Assignment8;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import springservlet.deployer.servlets.Assignment7.Response;

import java.util.List;

@Document (collection = "submissions")
public class Submission {

    @Id
    private long id;

    private List<Response> responses;

    public Submission() {
    }

    public Submission(int id, List<Response> responses) {
        this.id = id;
        this.responses = responses;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
