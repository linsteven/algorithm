package BinaryTree;

import BinaryTree.ListNode;

/**
 * 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author yuanlin.yyl
 * @date 2020/02/02
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = (p2 != null) ? p2.next : null;
            if (p2 != null && p1 == p2) {
                return true;
            }
        }

        return false;
    }

}
