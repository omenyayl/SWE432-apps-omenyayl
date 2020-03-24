package springservlet.deployer.servlets.Assignment6;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

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

    private static String templateMain;
    private static String templatePostReponse;

    static {
        servletPath = System.getProperty("user.dir") + "/src/main/java/springservlet/deployer/servlets/Assignment6";
        templatesPath = servletPath + "/templates";

        templateMain = getTemplate("main.html");
        templatePostReponse = getTemplate("post-response.html");
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter(); // Make it appear as if we're "writing" to the browser window
        out.print(templateMain); // print the main.html page in response to the GET request
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        StringBuilder sb = new StringBuilder();

        // table body
        Map<String, String[]> pm = req.getParameterMap();
        for (String key: pm.keySet()) {
            String param = pm.get(key)[0];
            sb.append(String.format(
                    "<tr>\n" +
                        "<td>%s</td>\n" +
                        "<td>%s</td>\n" +
                    "</tr>\n", key, Jsoup.clean(param, Whitelist.basic()))); // clean untrusted text
        }
        String processedHTML = templatePostReponse.replace("$[params-table-body]", sb.toString());
        out.print(processedHTML);
        out.close();
    }

    private static String getTemplate(String templateName) {
        try {
            return new Scanner(new File(templatesPath + "/" + templateName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
