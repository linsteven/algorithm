package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author yuanlin.yyl
 * @date 2020/05/10
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            List<Integer> orderList = new ArrayList<>();
            List<TreeNode> curList = new ArrayList<>();
            for (TreeNode node : list) {
                orderList.add(node.val);
                if (node.left != null) {
                    curList.add(node.left);
                }
                if (node.right != null) {
                    curList.add(node.right);
                }
            }

            list.clear();;
            list = curList;
            levelOrderList.add(orderList);
        }

        Collections.reverse(levelOrderList);
        return levelOrderList;
    }

}
