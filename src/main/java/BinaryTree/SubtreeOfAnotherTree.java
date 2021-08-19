package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author yuanlin.yyl
 * @date 2020/05/11
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return findSub(s, t);
    }

    private boolean findSub(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            if (bolTreeEqual(s, t)) {
                return true;
            }
        }
        return findSub(s.left, t) || findSub(s.right, t);
    }



    private boolean bolTreeEqual(TreeNode a, TreeNode b) {
        if (null == a || b == null) {
            return !(a != null || b != null);
        }
        if (a.val != b.val) {
            return false;
        }

        return bolTreeEqual(a.left, b.left) && bolTreeEqual(a.right, b.right);
    }

}
