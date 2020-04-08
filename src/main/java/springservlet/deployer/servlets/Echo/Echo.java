package springservlet.deployer.servlets.Echo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static springservlet.deployer.util.CORS.setCORS;

@WebServlet(
        name = "Echo",
        urlPatterns = {"/echo"}
)
public class Echo extends HttpServlet {
    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setCORS(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        setCORS(res);
        res.setContentType("application/json;charset=UTF-8");

        PrintWriter out = res.getWriter();

        Map<String, String[]> pm = req.getParameterMap();
        Map<String, String> pm2 = new HashMap<>();
        for (String key: pm.keySet()) {
            String param = pm.get(key)[0];
            pm2.put(key, param);
        }

        // map the parameter map to json
        ObjectMapper mapper = new ObjectMapper();
        String pm2JSON = mapper.writeValueAsString(pm2);

        out.print(pm2JSON);
    }
}
