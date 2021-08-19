package BinaryTree;

/**
 *
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author yuanlin.yyl
 * @date 2020/02/02
 */
public class ConvertSortedListToBinarySearchTree {

    private ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
        ListNode node  = head;
        int listSize = 0;
        while (node != null) {
            listSize ++;
            node = node.next;
        }
        list = head;
        return recursionToBST2(0, listSize - 1);
        //return recursionToBST(head, 0, listSize - 1);
    }

    private TreeNode recursionToBST2(int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            TreeNode node = new TreeNode(list.val);
            list = list.next;
            return node;
        }

        int mid = (start + end) / 2;
        TreeNode leftChild = recursionToBST2(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        TreeNode rightChild = recursionToBST2(mid + 1, end);
        parent.right = rightChild;
        return parent;
    }

    private TreeNode recursionToBST(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(head.val);
        }

        int mid = (start + end + 1) / 2;
        ListNode midNode = head;
        int pos = start;
        while (pos < mid) {
            midNode = midNode.next;
            pos ++;
        }

        TreeNode root = new TreeNode(midNode.val);
        root.left = recursionToBST(head, start, mid - 1);
        root.right = recursionToBST(midNode.next, mid + 1, end);
        return root;
    }

}
