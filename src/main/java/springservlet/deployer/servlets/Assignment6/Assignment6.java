package springservlet.deployer.servlets.Assignment6;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(
        name = "Assignment6",
        urlPatterns = {"/assignment6"}
)
public class Assignment6 extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter(); // Make it appear as if we're "writing" to the browser window
        printMainPage(out);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        printParameterBody(out, req);
        out.close();
    }

    private void printParameterBody(PrintWriter out, HttpServletRequest req) {
        out.println("<!doctype html>\n");
        out.println("<html class=\"no-js\" lang=\"en\">\n");
        out.println("\n");
        out.println("<head>\n");
        out.println("    <meta charset=\"utf-8\">\n");
        out.println("    <title>Assignment 6 Parameters</title>\n");
        out.println("    <meta name=\"description\" content=\"Review of classrooms at George Mason University.\">\n");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        out.println("\n");
        out.println("    <style>\n");
        out.println("\n");
        out.println("    </style>\n");
        out.println("\n");
        out.println("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
        out.println("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
        out.println("\n");
        out.println("    <meta name=\"theme-color\" content=\"#fafafa\">\n");
        out.println("</head>\n");
        out.println("\n");
        out.println("<body>\n");
        out.println("<!--[if IE]>\n");
        out.println("<p class=\"browserupgrade\">You are using an <strong>outdated</strong> browser. Please <a href=\"https://browsehappy.com/\">upgrade your browser</a> to improve your experience and security.</p>\n");
        out.println("<![endif]-->\n");
        out.println("\n");
        out.println("<div class=\"container\" style=\"margin-bottom: 10em\">\n");
        out.println("    <h1>Your responses</h1>\n");
        out.println("    <table>\n");
        out.println("        <thead>\n");
        out.println("            <tr>\n");
        out.println("                <th>Question</th>\n");
        out.println("                <th>Response</th>\n");
        out.println("            </tr>\n");
        out.println("        </thead>\n");
        out.println("        <tbody>\n");
        Map<String, String[]> pm = req.getParameterMap();
        for (String key: pm.keySet()) {
            String param = pm.get(key)[0];
            out.println(String.format(
                "            <tr>\n" +
                "                <td>%s</td>\n" +
                "                <td>%s</td>\n" +
                "            </tr>\n", key, Jsoup.clean(param, Whitelist.basic()))
            ); // clean untrusted text
        }
        out.println("        </tbody>\n");
        out.println("    </table>\n");
        out.println("</div>\n");
        out.println("\n");
        out.println("\n");
        out.println("<script src=\"js/vendor/modernizr-3.8.0.min.js\"></script>\n");
        out.println("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
        out.println("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-3.4.1.min.js\"><\\/script>')</script>\n");
        out.println("<script src=\"js/plugins.js\"></script>\n");
        out.println("<script src=\"js/main.js\"></script>\n");
        out.println("\n");
        out.println("\n");
        out.println("<script>\n");
        out.println("\n");
        out.println("</script>\n");
        out.println("\n");
        out.println("</body>\n");
        out.println("\n");
        out.println("</html>\n");
    }

    private void printMainPage(PrintWriter out) {
        out.println("<!doctype html>\n");
        out.println("<html class=\"no-js\" lang=\"en\">\n");
        out.println("\n");
        out.println("<head>\n");
        out.println("    <meta charset=\"utf-8\">\n");
        out.println("    <title>Assignment 6</title>\n");
        out.println("    <meta name=\"description\" content=\"Review of classrooms at George Mason University.\">\n");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        out.println("\n");
        out.println("    <style>\n");
        out.println("        .question-title {\n");
        out.println("            display: block;\n");
        out.println("        }\n");
        out.println("\n");
        out.println("        .question-option {\n");
        out.println("            display: block;\n");
        out.println("        }\n");
        out.println("\n");
        out.println("        #submit-error {\n");
        out.println("            padding-left: 1em;\n");
        out.println("            color: #EE5A24;\n");
        out.println("        }\n");
        out.println("\n");
        out.println("        label.question-option {\n");
        out.println("            color: #3d3d3d;\n");
        out.println("        }\n");
        out.println("    </style>\n");
        out.println("\n");
        out.println("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
        out.println("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
        out.println("\n");
        out.println("    <meta name=\"theme-color\" content=\"#fafafa\">\n");
        out.println("</head>\n");
        out.println("\n");
        out.println("<body>\n");
        out.println("<!--[if IE]>\n");
        out.println("<p class=\"browserupgrade\">You are using an <strong>outdated</strong> browser. Please <a href=\"https://browsehappy.com/\">upgrade your browser</a> to improve your experience and security.</p>\n");
        out.println("<![endif]-->\n");
        out.println("\n");
        out.println("<div class=\"container\" style=\"margin-bottom: 10em\">\n");
        out.println("    <h1>Review of GMU Classrooms <a href=\"https://github.com/omenyayl/SWE432-apps-omenyayl/tree/master/src/main/java/springservlet/deployer/servlets/Assignment6\">(source)</a></h1>\n");
        out.println("    <form id=\"survey\" method=\"post\" action=\"/assignment6\">\n");
        out.println("        <div class=\"questions\">\n");
        out.println("            <!-- Questions fill up here from JS-->\n");
        out.println("        </div>\n");
        out.println("\n");
        out.println("        <button type=\"button\" class=\"btn waves-effect waves-light\" onclick=\"onClickButtonSubmit(this)\">Submit\n");
        out.println("        </button>\n");
        out.println("        <span id=\"submit-error\"></span>\n");
        out.println("    </form>\n");
        out.println("</div>\n");
        out.println("\n");
        out.println("\n");
        out.println("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
        out.println("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-3.4.1.min.js\"><\\/script>')</script>\n");
        out.println("\n");
        out.println("<script>\n");
        out.println("\n");
        out.println("    const questions = [\n");
        out.println("        {\n");
        out.println("            title: 'What is the most important quality of a classroom?',\n");
        out.println("            optionsType: 'multipleChoice',\n");
        out.println("            options: [\n");
        out.println("                'Air quality',\n");
        out.println("                'Space',\n");
        out.println("                'Sound projection',\n");
        out.println("                'Cleanliness'\n");
        out.println("            ]\n");
        out.println("        },\n");
        out.println("        {\n");
        out.println("            title: 'Which building has the best classrooms?',\n");
        out.println("            optionsType: 'multipleChoice',\n");
        out.println("            options: [\n");
        out.println("                'Engineering',\n");
        out.println("                'JC',\n");
        out.println("                'Innovations',\n");
        out.println("                'Fenwick Library'\n");
        out.println("            ]\n");
        out.println("        },\n");
        out.println("        {\n");
        out.println("            title: 'How important is a classroom for your learning experience?',\n");
        out.println("            optionsType: 'multipleChoice',\n");
        out.println("            options: [\n");
        out.println("                'Not so much',\n");
        out.println("                'A bit',\n");
        out.println("                'A decent amount',\n");
        out.println("                'Very important'\n");
        out.println("            ]\n");
        out.println("        },\n");
        out.println("        {\n");
        out.println("            title: 'On a scale of 1-5, how nice is our SWE 432 classroom?',\n");
        out.println("            optionsType: 'multipleChoice',\n");
        out.println("            options: [\n");
        out.println("                '1',\n");
        out.println("                '2',\n");
        out.println("                '3',\n");
        out.println("                '4',\n");
        out.println("                '5'\n");
        out.println("            ]\n");
        out.println("        },\n");
        out.println("        {\n");
        out.println("            title: 'How would you describe your experience of our SWE 432 classroom?',\n");
        out.println("            optionsType: 'textBox'\n");
        out.println("        },\n");
        out.println("        {\n");
        out.println("            title: 'What is your major at GMU?',\n");
        out.println("            optionsType: 'textBox'\n");
        out.println("        }\n");
        out.println("    ];\n");
        out.println("\n");
        out.println("    const answeredQuestions = {};\n");
        out.println("    for (let i = 0; i < questions.length; i++) {\n");
        out.println("        answeredQuestions[i] = false;\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    function onQuestionAnswer(questionNumber) {\n");
        out.println("        answeredQuestions[questionNumber] = true;\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    function getMultipleChoiceOptionsHTML(questionNumber, options) {\n");
        out.println("        let ret = \"\";\n");
        out.println("        for (let j = 0; j < options.length; j++) {\n");
        out.println("            let option = options[j];\n");
        out.println("            ret += `\n");
        out.println("            <label onclick=\"onQuestionAnswer(${questionNumber})\" class=\"question-option\">\n");
        out.println("              <input name=\"q${questionNumber}\" type=\"radio\" value=\"${option}\" />\n");
        out.println("              <span>${option}</span>\n");
        out.println("            </label>\n");
        out.println("          `\n");
        out.println("        }\n");
        out.println("        return ret;\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    function getTextBoxHTML(questionNumber) {\n");
        out.println("        return `\n");
        out.println("      <div class=\"row\">\n");
        out.println("        <div class=\"input-field\">\n");
        out.println("            <textarea oninput=\"onQuestionAnswer(${questionNumber})\" name=\"q${questionNumber}\" id=\"q${questionNumber}\" class=\"materialize-textarea\"></textarea>\n");
        out.println("        </div>\n");
        out.println("      </div>\n");
        out.println("      `\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    function generateQuestionHTML(questions) {\n");
        out.println("        let ret = \"\";\n");
        out.println("        for (let i = 0; i < questions.length; i++) {\n");
        out.println("            let question = questions[i];\n");
        out.println("            let options = \"\";\n");
        out.println("\n");
        out.println("            switch (question.optionsType) {\n");
        out.println("                case 'multipleChoice':\n");
        out.println("                    options = getMultipleChoiceOptionsHTML(i, question.options);\n");
        out.println("                    break;\n");
        out.println("                case 'textBox':\n");
        out.println("                    options = getTextBoxHTML(i);\n");
        out.println("                    break;\n");
        out.println("                default:\n");
        out.println("                    options = \"\";\n");
        out.println("                    break;\n");
        out.println("            }\n");
        out.println("\n");
        out.println("            ret += `\n");
        out.println("        <div class=\"question\">\n");
        out.println("          <h5 class=\"question-title\">${question.title}</h5>\n");
        out.println("          <p>\n");
        out.println("            ${options}\n");
        out.println("          </p>\n");
        out.println("        </div>\n");
        out.println("        `\n");
        out.println("        }\n");
        out.println("        return ret;\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    function isFormValid() {\n");
        out.println("        let isValid = true;\n");
        out.println("        const questions = $('.questions .question');\n");
        out.println("        for (let i in answeredQuestions) {\n");
        out.println("            if (!answeredQuestions[i]) {\n");
        out.println("                questions.get(i).style.color = '#EE5A24';\n");
        out.println("                isValid = false;\n");
        out.println("            } else {\n");
        out.println("                questions.get(i).style.color = '';\n");
        out.println("            }\n");
        out.println("        }\n");
        out.println("        return isValid;\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    function onClickButtonSubmit(b) {\n");
        out.println("        let submitError = $('#submit-error');\n");
        out.println("        if (isFormValid()) {\n");
        out.println("            $('#survey').submit();\n");
        out.println("            submitError.text('');\n");
        out.println("        } else {\n");
        out.println("            submitError.text('Please answer the highlighted questions above.');\n");
        out.println("        }\n");
        out.println("    }\n");
        out.println("\n");
        out.println("    $(document).ready(() => {\n");
        out.println("        $('.questions').html(\n");
        out.println("            generateQuestionHTML(questions)\n");
        out.println("        )\n");
        out.println("    });\n");
        out.println("\n");
        out.println("</script>\n");
        out.println("\n");
        out.println("</body>\n");
        out.println("\n");
        out.println("</html>\n");
    }
}
