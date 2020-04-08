package springservlet.deployer.servlets.Assignment7;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import static springservlet.deployer.util.CORS.setCORS;

@WebServlet(
        name = "Assignment7",
        urlPatterns = {"/assignment7"}
)
public class Assignment7 extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        setCORS(res);
        res.sendRedirect("http://swe432-assignment7.s3-website-us-east-1.amazonaws.com");
    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setCORS(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        setCORS(res);
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ObjectMapper mapper = new ObjectMapper();
        Response[] responses = mapper.readValue(body, Response[].class);
        processResponses(responses);
        out.print(mapper.writeValueAsString(responses));
        out.close();
    }

    private void processResponses(Response[] responses) {
        for (Response r: responses) {
            // filter some bad words
            r.setResponse(r.getResponse().replaceAll("(fuck)|(shit)|(damn)", "*"));
        }
    }
}
