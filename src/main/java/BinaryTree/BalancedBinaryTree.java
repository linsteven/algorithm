package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * @author yuanlin.yyl
 * @date 2020/01/26
 */
public class BalancedBinaryTree {

    private Map<TreeNode, Integer> maxDepthMap = new HashMap<>();
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (!isBalanced) {
            return false;
        }

        if (root == null) {
            return true;
        }

        int maxLeftVal = maxDepth(root.left);
        int maxRightVal = maxDepth(root.right);
        if (Math.abs(maxLeftVal - maxRightVal) > 1) {
            isBalanced = false;
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (maxDepthMap.containsKey(root)) {
            return maxDepthMap.get(root);
        }

        int val = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        maxDepthMap.put(root, val);
        return val;
    }

}
