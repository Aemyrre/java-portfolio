import org.example.Q14LongestCommonPrefix;

public class Q14LongestCommonPrefixTestClass {

    public static void main(String[] args) {
        var mainClass = new Q14LongestCommonPrefixTestClass();
        mainClass.testLongestCommonPrefix(new String[] {"flower", "florist", "flour"});
    }

    public void testLongestCommonPrefix(String[] strs) {
        Q14LongestCommonPrefix testClass = new Q14LongestCommonPrefix();
        String commonPrefix = testClass.longestCommonPrefix(strs);
        System.out.println("Common Prefix: " + commonPrefix);
    }
}
