package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author yuanlin.yyl
 * @date 2020/05/10
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        findNode(root, p, pList);
        if (pList.contains(q)) {
            return q;
        }
        List<TreeNode> qList = new ArrayList<>();
        findNode(root, q, qList);
        int len = pList.size() < qList.size() ? pList.size() : qList.size();
        TreeNode retNode = root;
        for (int i = 0 ; i < len; i++) {
            if (!pList.get(i).equals(qList.get(i))) {
                break;
            }
            retNode = pList.get(i);
        }
        return retNode;
    }

    private boolean findNode(TreeNode root, TreeNode p, List<TreeNode> pathList) {
        if (root == null) {
            return false;
        }
        pathList.add(root);
        if (root == p) {
            return true;
        }
        boolean bolLeftFind = findNode(root.left, p, pathList);
        if (bolLeftFind) {
            return true;
        }
        boolean bolRightFind = findNode(root.right, p, pathList);
        if (bolRightFind) {
            return true;
        }
        pathList.remove(root);
        return false;
    }

}
