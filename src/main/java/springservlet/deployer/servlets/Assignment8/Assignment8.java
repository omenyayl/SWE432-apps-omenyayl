package springservlet.deployer.servlets.Assignment8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/assignment8")
public class Assignment8 {

    private SubmissionService submissionService;

    @Autowired
    public Assignment8(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("")
    public List<Submission> getSubmissions() {
        return this.submissionService.getSubmissions();
    }

    @PostMapping(value = "", consumes = "application/json")
    public Submission addSubmission(@RequestBody Submission submission) {
        return this.submissionService.addSubmission(submission);
    }

}
