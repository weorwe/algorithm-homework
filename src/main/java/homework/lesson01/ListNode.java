package homework.lesson01;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x,ListNode head) {
        val = x;
        next = head;
    }

    public static final ListNode createTestData(){
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
