package BinaryTree;

/**
 * @author yuanlin.yyl
 * @date 2020/02/02
 */
public class BinaryTreeMaximumPathSum {

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode p) {
        if (p == null) {
            return 0;
        }

        int maxLeft = findMax(p.left);
        int maxRight = findMax(p.right);

        maxSum = Math.max(maxSum, maxLeft + maxRight + p.val);
        int ret =  p.val + Math.max(maxLeft, maxRight);
        return ret > 0 ? ret : 0;
    }

}
