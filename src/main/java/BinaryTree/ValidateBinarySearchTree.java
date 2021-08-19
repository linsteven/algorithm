package BinaryTree;

import BinaryTree.TreeNode;

/**
 *
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *   节点的左子树只包含小于当前节点的数。
 *   节点的右子树只包含大于当前节点的数。
 *   所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author yuanlin.yyl
 * @date 2020/01/26
 */
public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidTree(root.left, null, root.val) && isValidTree(root.right, root.val, null);
    }

    private boolean isValidTree(TreeNode root, Integer minnum, Integer maxnum) {
        if (root == null) {
            return true;
        }

        if (maxnum != null && root.val >= maxnum) {
            return false;
        }

        if (minnum != null &&  root.val <= minnum) {
            return false;
        }

        return isValidTree(root.left, minnum, root.val) && isValidTree(root.right, root.val, maxnum);
    }

}
