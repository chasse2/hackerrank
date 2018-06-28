package alg.linkedlist;

public class PrintReverseViaRecursion {
    public void printReverse(final ListNode node) {
        if (null == node) {
            return;
        }

        printReverse(node.next);

        System.out.println(node.val);
    }
}
