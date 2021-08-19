package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author yuanlin.yyl
 * @date 2020/04/13
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while(!nodeList.isEmpty()) {
            List<TreeNode> newNodeList = new ArrayList<>();
            List<Integer> oneLevenList = new ArrayList<>();
            for (TreeNode node : nodeList) {
                oneLevenList.add(node.val);
                if (node.left != null) {
                    newNodeList.add(node.left);
                }
                if (node.right != null) {
                    newNodeList.add(node.right);
                }
            }
            levelOrderList.add(oneLevenList);
            nodeList = newNodeList;
        }

        return levelOrderList;
    }

}
