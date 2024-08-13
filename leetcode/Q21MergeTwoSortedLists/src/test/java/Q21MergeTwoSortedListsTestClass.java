import org.example.Q21MergeTwoSortedLists;

import java.util.LinkedList;

public class Q21MergeTwoSortedListsTestClass {
    public static void main(String[] args) {
        var mainClass = new Q21MergeTwoSortedListsTestClass();
        LinkedList<Integer> list1 = new LinkedList<>() {{
           add(1);
           add(2);
           add(4);
        }};
        LinkedList<Integer> list2 = new LinkedList<>() {{
            add(1);
            add(3);
            add(4);
        }};
        LinkedList<Integer> sortedLists = mainClass.testMergeTwoSortedLists(list1, list2);
        System.out.println(sortedLists);
    }

    public LinkedList<Integer> testMergeTwoSortedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Q21MergeTwoSortedLists testClass = new Q21MergeTwoSortedLists();
        return  testClass.mergeTwoLists(list1, list2);
    }
}
