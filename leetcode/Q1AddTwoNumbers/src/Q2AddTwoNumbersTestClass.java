import java.util.ArrayList;
import java.util.Arrays;

public class Q2AddTwoNumbersTestClass {

    public static void main(String[] args) {
        var test = new Q2AddTwoNumbersTestClass();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(5);
        l2.add(6);
        l2.add(4);
        test.addTwoNumber(l1, l2);
//        int remainder = (11/10) % 10;
//        System.out.println(remainder);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    private void addTwoNumber(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        Q2AddTwoNumbers q2AddTwoNumbers = new Q2AddTwoNumbers(l1, l2);
        ArrayList<Integer> sum = q2AddTwoNumbers.addTwoNumber();
        System.out.println(sum);
    }
}
