package homework.lesson01;

/**
 * leetcode 206 反转链表
 * <p>
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution_206 {

    public static ListNode reverseList(ListNode head){
        ListNode last = null;
        while (head!=null){
            ListNode nextListNode = head.next;
            head.next = last;
            last = head;
            head = nextListNode;
        }
        return last;
    }



    public static final ListNode createTestData(){
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        return listNode;
    }


    public static void main(String[] args) {
        ListNode listNode = reverseList(createTestData());
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
