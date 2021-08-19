package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuanlin.yyl
 * @date 2020/04/19
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            list.add(curNode.val);
            curNode = curNode.right;
        }

        return list;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            inorder(node.left, list);
        }
        list.add(node.val);
        if (null != node.right) {
            inorder(node.right, list);
        }
    }

}
