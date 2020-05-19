package springservlet.deployer.servlets.Final;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Utils {

    /**
     * Accepts expression i.e. A && B || C && Apple
     * @param expression
     * @return truth table
     */
    public static List<List<String>> getTruthTable(String expression) {
        HashSet<String> elements = new HashSet<>();
        String cleanedExpression = expression.replaceAll("(\\s+)|(\\()|(\\))|(&&)|(\\|\\|)", " ").replaceAll("\\s+", " ");
        String[] elementsSplit = cleanedExpression.split(" ");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine javascript = manager.getEngineByName("JavaScript");

        List<List<String>> table = new ArrayList<>();
        for (String element: elementsSplit) {
            elements.add(element.trim());
        }

        List<String> header = new ArrayList<>(elements);

        header.add("Evaluation");
        table.add(header);

        int rows = 1 << elements.size();
        int bits = elements.size();

        for (int i = 0; i < rows; i++) {
            String binaryRepresentation = Integer.toBinaryString(i);
            String rep = String.format("%"+ bits +"s", binaryRepresentation).replace(' ', '0');
            List<String> row = new ArrayList<>();
            for (int j = 0; j < rep.length(); j++) {
                row.add(rep.charAt(j) + "");
            }
            table.add(row);
        }

        for (int i = 1; i < table.size(); i++) {
            List<String> row = table.get(i);
            StringBuilder script = new StringBuilder();
            for (int j = 0; j < row.size(); j++) {
                String truthValue = row.get(j).equals("1") ? "true" : "false";
                script.append(header.get(j)).append(" = ").append(truthValue).append(";\n");
            }
            script.append(expression).append(";");
            try {
                Object evaluation = javascript.eval(script.toString());
                table.get(i).add(evaluation.toString().contains("true") ? "1" : "0");
            } catch (ScriptException e) {
                return null;
            }
        }

        return table;
    }

    public static void main(String[] args) {
        System.out.println(getTruthTable("B && (B || C)"));
    }
}
