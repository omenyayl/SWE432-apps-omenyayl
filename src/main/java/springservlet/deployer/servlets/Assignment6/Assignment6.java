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

    private void printMainPage(PrintWriter out) {
        out.print("<!doctype html>\n");
        out.print("<html class=\"no-js\" lang=\"en\">\n");
        out.print("\n");
        out.print("<head>\n");
        out.print("    <meta charset=\"utf-8\">\n");
        out.print("    <title>Assignment 6</title>\n");
        out.print("    <meta name=\"description\" content=\"Review of classrooms at George Mason University.\">\n");
        out.print("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        out.print("\n");
        out.print("    <style>\n");
        out.print("        .question-title {\n");
        out.print("            display: block;\n");
        out.print("        }\n");
        out.print("\n");
        out.print("        .question-option {\n");
        out.print("            display: block;\n");
        out.print("        }\n");
        out.print("\n");
        out.print("        #submit-error {\n");
        out.print("            padding-left: 1em;\n");
        out.print("            color: #EE5A24;\n");
        out.print("        }\n");
        out.print("\n");
        out.print("        label.question-option {\n");
        out.print("            color: #3d3d3d;\n");
        out.print("        }\n");
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
        out.print("    <h1>Review of GMU Classrooms <a href=\"https://github.com/omenyayl/SWE432-apps-omenyayl/tree/master/src/main/java/springservlet/deployer/servlets/Assignment6\">(source)</a></h1>\n");
        out.print("    <form id=\"survey\" method=\"post\" action=\"/assignment6\">\n");
        out.print("        <div class=\"questions\">\n");
        out.print("            <!-- Questions fill up here from JS-->\n");
        out.print("        </div>\n");
        out.print("\n");
        out.print("        <button type=\"button\" class=\"btn waves-effect waves-light\" onclick=\"onClickButtonSubmit(this)\">Submit\n");
        out.print("        </button>\n");
        out.print("        <span id=\"submit-error\"></span>\n");
        out.print("    </form>\n");
        out.print("</div>\n");
        out.print("\n");
        out.print("\n");
        out.print("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
        out.print("<script>window.jQuery || document.write('<script src=\"js/vendor/jquery-3.4.1.min.js\"><\\/script>')</script>\n");
        out.print("\n");
        out.print("<script>\n");
        out.print("\n");
        out.print("    const questions = [\n");
        out.print("        {\n");
        out.print("            title: 'What is the most important quality of a classroom?',\n");
        out.print("            optionsType: 'multipleChoice',\n");
        out.print("            options: [\n");
        out.print("                'Air quality',\n");
        out.print("                'Space',\n");
        out.print("                'Sound projection',\n");
        out.print("                'Cleanliness'\n");
        out.print("            ]\n");
        out.print("        },\n");
        out.print("        {\n");
        out.print("            title: 'Which building has the best classrooms?',\n");
        out.print("            optionsType: 'multipleChoice',\n");
        out.print("            options: [\n");
        out.print("                'Engineering',\n");
        out.print("                'JC',\n");
        out.print("                'Innovations',\n");
        out.print("                'Fenwick Library'\n");
        out.print("            ]\n");
        out.print("        },\n");
        out.print("        {\n");
        out.print("            title: 'How important is a classroom for your learning experience?',\n");
        out.print("            optionsType: 'multipleChoice',\n");
        out.print("            options: [\n");
        out.print("                'Not so much',\n");
        out.print("                'A bit',\n");
        out.print("                'A decent amount',\n");
        out.print("                'Very important'\n");
        out.print("            ]\n");
        out.print("        },\n");
        out.print("        {\n");
        out.print("            title: 'On a scale of 1-5, how nice is our SWE 432 classroom?',\n");
        out.print("            optionsType: 'multipleChoice',\n");
        out.print("            options: [\n");
        out.print("                '1',\n");
        out.print("                '2',\n");
        out.print("                '3',\n");
        out.print("                '4',\n");
        out.print("                '5'\n");
        out.print("            ]\n");
        out.print("        },\n");
        out.print("        {\n");
        out.print("            title: 'How would you describe your experience of our SWE 432 classroom?',\n");
        out.print("            optionsType: 'textBox'\n");
        out.print("        },\n");
        out.print("        {\n");
        out.print("            title: 'What is your major at GMU?',\n");
        out.print("            optionsType: 'textBox'\n");
        out.print("        }\n");
        out.print("    ];\n");
        out.print("\n");
        out.print("    const answeredQuestions = {};\n");
        out.print("    for (let i = 0; i < questions.length; i++) {\n");
        out.print("        answeredQuestions[i] = false;\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    function onQuestionAnswer(questionNumber) {\n");
        out.print("        answeredQuestions[questionNumber] = true;\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    function getMultipleChoiceOptionsHTML(questionNumber, options) {\n");
        out.print("        let ret = \"\";\n");
        out.print("        for (let j = 0; j < options.length; j++) {\n");
        out.print("            let option = options[j];\n");
        out.print("            ret += `\n");
        out.print("            <label onclick=\"onQuestionAnswer(${questionNumber})\" class=\"question-option\">\n");
        out.print("              <input name=\"q${questionNumber}\" type=\"radio\" value=\"${option}\" />\n");
        out.print("              <span>${option}</span>\n");
        out.print("            </label>\n");
        out.print("          `\n");
        out.print("        }\n");
        out.print("        return ret;\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    function getTextBoxHTML(questionNumber) {\n");
        out.print("        return `\n");
        out.print("      <div class=\"row\">\n");
        out.print("        <div class=\"input-field\">\n");
        out.print("            <textarea oninput=\"onQuestionAnswer(${questionNumber})\" name=\"q${questionNumber}\" id=\"q${questionNumber}\" class=\"materialize-textarea\"></textarea>\n");
        out.print("        </div>\n");
        out.print("      </div>\n");
        out.print("      `\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    function generateQuestionHTML(questions) {\n");
        out.print("        let ret = \"\";\n");
        out.print("        for (let i = 0; i < questions.length; i++) {\n");
        out.print("            let question = questions[i];\n");
        out.print("            let options = \"\";\n");
        out.print("\n");
        out.print("            switch (question.optionsType) {\n");
        out.print("                case 'multipleChoice':\n");
        out.print("                    options = getMultipleChoiceOptionsHTML(i, question.options);\n");
        out.print("                    break;\n");
        out.print("                case 'textBox':\n");
        out.print("                    options = getTextBoxHTML(i);\n");
        out.print("                    break;\n");
        out.print("                default:\n");
        out.print("                    options = \"\";\n");
        out.print("                    break;\n");
        out.print("            }\n");
        out.print("\n");
        out.print("            ret += `\n");
        out.print("        <div class=\"question\">\n");
        out.print("          <h5 class=\"question-title\">${question.title}</h5>\n");
        out.print("          <p>\n");
        out.print("            ${options}\n");
        out.print("          </p>\n");
        out.print("        </div>\n");
        out.print("        `\n");
        out.print("        }\n");
        out.print("        return ret;\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    function isFormValid() {\n");
        out.print("        let isValid = true;\n");
        out.print("        const questions = $('.questions .question');\n");
        out.print("        for (let i in answeredQuestions) {\n");
        out.print("            if (!answeredQuestions[i]) {\n");
        out.print("                questions.get(i).style.color = '#EE5A24';\n");
        out.print("                isValid = false;\n");
        out.print("            } else {\n");
        out.print("                questions.get(i).style.color = '';\n");
        out.print("            }\n");
        out.print("        }\n");
        out.print("        return isValid;\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    function onClickButtonSubmit(b) {\n");
        out.print("        let submitError = $('#submit-error');\n");
        out.print("        if (isFormValid()) {\n");
        out.print("            $('#survey').submit();\n");
        out.print("            submitError.text('');\n");
        out.print("        } else {\n");
        out.print("            submitError.text('Please answer the highlighted questions above.');\n");
        out.print("        }\n");
        out.print("    }\n");
        out.print("\n");
        out.print("    $(document).ready(() => {\n");
        out.print("        $('.questions').html(\n");
        out.print("            generateQuestionHTML(questions)\n");
        out.print("        )\n");
        out.print("    });\n");
        out.print("\n");
        out.print("</script>\n");
        out.print("\n");
        out.print("</body>\n");
        out.print("\n");
        out.print("</html>\n");
    }
}
