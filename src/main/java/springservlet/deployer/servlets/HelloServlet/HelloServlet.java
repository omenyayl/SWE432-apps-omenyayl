package springservlet.deployer.servlets.HelloServlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = {"/hello-servlet"}
)
public class HelloServlet extends HttpServlet
{

    private static String servletPath;
    private static String templatesPath;

    static {
         servletPath = System.getProperty("user.dir") + "/src/main/java/springservlet/deployer/servlets/HelloServlet";
         templatesPath = servletPath + "/templates";
    }

    @Override
    protected void doGet  (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setContentType("text/html"); // Tells the web container what we're sending back
        PrintWriter out = res.getWriter(); // Make it appear as if we're "writing" to the browser window
        out.print(getTemplate("main.html"));
        out.close();
    }  // end doGet()

    private String getTemplate(String templateName) {
        try {
            return new Scanner(new File(templatesPath + "/" + templateName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}