package springservlet.deployer.servlets.Assignment7;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@CrossOrigin
@WebServlet(
        name = "Assignment7",
        urlPatterns = {"/assignment7"}
)
public class Assignment7 extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("http://swe432-assignment7.s3-website-us-east-1.amazonaws.com");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        printParameterBody(out, req);
        out.close();
    }

    private void printParameterBody(PrintWriter out, HttpServletRequest req) {
        out.print("<!doctype html>\n");
        out.print("<html class=\"no-js\" lang=\"en\">\n");
        out.print("\n");
        out.print("<head>\n");
        out.print("    <meta charset=\"utf-8\">\n");
        out.print("    <title>Assignment 6 Parameters</title>\n");
        out.print("    <meta name=\"description\" content=\"Review of classrooms at George Mason University.\">\n");
        out.print("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        out.print("\n");
        out.print("    <style>\n");
        out.print("\n");
        out.print("    </style>\n");
        out.print("\n");
        out.print("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
        out.print("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
        out.print("\n");
        out.print("    <meta name=\"theme-color\" content=\"#fafafa\">\n");
        out.print("</head>\n");
        out.print("\n");
        out.print("<body>\n");
        out.print("<!--[if IE]>\n");
        out.print("<p class=\"browserupgrade\">You are using an <strong>outdated</strong> browser. Please <a href=\"https://browsehappy.com/\">upgrade your browser</a> to improve your experience and security.</p>\n");
        out.print("<![endif]-->\n");
        out.print("\n");
        out.print("<div class=\"container\" style=\"margin-bottom: 10em\">\n");
        out.print("    <h1>Your responses</h1>\n");
        out.print("    <table>\n");
        out.print("        <thead>\n");
        out.print("            <tr>\n");
        out.print("                <th>Question</th>\n");
        out.print("                <th>Response</th>\n");
        out.print("            </tr>\n");
        out.print("        </thead>\n");
        out.print("        <tbody>\n");
        Map<String, String[]> pm = req.getParameterMap();
        for (String key: pm.keySet()) {
            String param = pm.get(key)[0];
            out.print(String.format(
                    "            <tr>\n" +
                            "                <td>%s</td>\n" +
                            "                <td>%s</td>\n" +
                            "            </tr>\n", key, Jsoup.clean(param, Whitelist.basic()))
            ); // clean untrusted text
        }
        out.print("        </tbody>\n");
        out.print("    </table>\n");
        out.print("</div>\n");
        out.print("\n");
        out.print("\n");
        out.print("<script src=\"js/vendor/modernizr-3.8.0.min.js\"></script>\n");
        out.print("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
        out.print("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-3.4.1.min.js\"><\\/script>')</script>\n");
        out.print("<script src=\"js/plugins.js\"></script>\n");
        out.print("<script src=\"js/main.js\"></script>\n");
        out.print("\n");
        out.print("\n");
        out.print("<script>\n");
        out.print("\n");
        out.print("</script>\n");
        out.print("\n");
        out.print("</body>\n");
        out.print("\n");
        out.print("</html>\n");
    }
}
