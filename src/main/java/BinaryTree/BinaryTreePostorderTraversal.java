package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanlin.yyl
 * @date 2020/04/20
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();



        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postordet(root, list);
        return list;
    }

    private void postordet(TreeNode node, List<Integer> list ) {
        if (null == node) {
            return;
        }
        postordet(node.left, list);
        postordet(node.right, list);
        list.add(node.val);
    }

}
