package homework.lesson01;



/**
 * leetcode 25 K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 1：将一个链表按照K进行分组
 * 2：将组内的链表数据翻转
 * 3：上一组跟本组的新开始（旧end）建立联系
 * 4：本组的新结尾（head）跟下一组的建立联系
 *
 *
 * 学习到知识点：保护点的运用可以直接返回结果。protect
 *
 */
public class Solution_25 {

    public ListNode reverseListNode(ListNode head, int k) {
        ListNode protect = new ListNode(-1, head);
        //记录上一组的结尾
        ListNode last = protect;
        while (head != null) {
            //分组
            ListNode endNode = getEndNode(head, k);
            if (endNode == null) {
                break;
            }
            // 记录下一组的head
            ListNode nextGroupHead = endNode.next;
            // 分组后组内翻转
            reverseList(head, endNode);
            //上一组跟本组的新开始（旧end）建立联系
            last.next = endNode;
            //本组的新结尾（head）跟下一组的建立联系
            head.next = nextGroupHead;

            //遍历分组
            last = head;
            head = nextGroupHead;
        }
        return protect.next;
    }


    public ListNode getEndNode(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return head;
    }


    public void reverseList(ListNode head, ListNode end) {
        ListNode last = null;
        while (head != end) {
            ListNode nextListNode = head.next;
            head.next = last;
            last = head;
            head = nextListNode;
        }
        end.next = last;
    }


    public static void main(String[] args) {
        ListNode testData = ListNode.createTestData();
        Solution_25 solution_25 = new Solution_25();
        ListNode listNode = solution_25.reverseListNode(testData, 2);
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }

    }
}
