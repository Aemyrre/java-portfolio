import org.example.Q20ValidParentheses;

public class Q20ValidParenthesesTestClass {
    public static void main(String[] args) {
        var mainClass = new Q20ValidParenthesesTestClass();
        boolean isValid = mainClass.parenthesisIsValid("){");
        System.out.println("Is Valid? " + isValid);
    }

    public boolean parenthesisIsValid(String s) {
        Q20ValidParentheses testMethod = new Q20ValidParentheses();
        return testMethod.isValid(s);
    }
}
