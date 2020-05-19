package springservlet.deployer.servlets.Final;

public class Submission {
    String expression;

    public Submission() {
    }

    public Submission(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
