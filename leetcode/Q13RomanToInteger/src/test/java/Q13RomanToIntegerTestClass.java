import org.example.Q13RomanToInteger;

public class Q13RomanToIntegerTestClass {
    private Q13RomanToInteger mainClass = new Q13RomanToInteger();

    public static void main(String[] args) {
        var testClass = new Q13RomanToIntegerTestClass();
        testClass.convertRomanNumbersToIntegers("MCMXCIV");
    }

    public void convertRomanNumbersToIntegers(String romanNumeral) {
        int convertedNumber = mainClass.romanToInt(romanNumeral);
        System.out.println(convertedNumber);
    }


}
