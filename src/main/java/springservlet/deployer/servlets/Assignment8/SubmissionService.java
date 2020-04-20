package springservlet.deployer.servlets.Assignment8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionService {

    private SubmissionRepository repository;

    @Autowired
    public SubmissionService(SubmissionRepository repository) {
        this.repository = repository;
    }

    List<Submission> getSubmissions() {
        List<Submission> submissions = new ArrayList<>();
        this.repository.findAll().forEach(submissions::add);
        return submissions;
    }

    Submission addSubmission(Submission submission) {
        return this.repository.save(submission);
    }

}
