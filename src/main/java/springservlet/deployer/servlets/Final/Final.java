package springservlet.deployer.servlets.Final;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/final")
public class Final {

    @Autowired
    public Final() {

    }

    @PostMapping(value = "", consumes = "application/json")
    public List<List<String>> getSubmissions(@RequestBody Submission submission) {
        return Utils.getTruthTable(submission.expression);
    }

}
