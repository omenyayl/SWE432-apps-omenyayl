package springservlet.deployer.servlets.Assignment6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

@WebServlet(
        name = "Assignment6",
        urlPatterns = {"/assignment6"}
)
public class Assignment6 extends HttpServlet {

    private static String servletPath;
    private static String templatesPath;

    static {
        servletPath = System.getProperty("user.dir") + "/src/main/java/springservlet/deployer/servlets/Assignment6";
        templatesPath = servletPath + "/templates";
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter(); // Make it appear as if we're "writing" to the browser window
        out.print(getTemplate("main.html")); // print the main.html page in response to the GET request
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String postResponseHTML = getTemplate("post-response.html");
        StringBuilder sb = new StringBuilder();

        // table body
        Map<String, String[]> pm = req.getParameterMap();
        for (String key: pm.keySet()) {
            String param = pm.get(key)[0];
            sb.append(String.format(
                    "<tr>\n" +
                        "<td>%s</td>\n" +
                        "<td>%s</td>\n" +
                    "</tr>\n", key, param));
        }
        out.print(postResponseHTML.replace("$[params-table-body]", sb.toString()));
        out.close();
    }

    private String getTemplate(String templateName) {
        try {
            return new Scanner(new File(templatesPath + "/" + templateName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
