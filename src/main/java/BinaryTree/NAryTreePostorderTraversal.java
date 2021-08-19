package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanlin.yyl
 * @date 2020/04/20
 */
public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfsPostorder(root, list);
        return list;
    }

    private void dfsPostorder(Node node, List<Integer> list) {
        if (null == node) {
            return;
        }
        if (null != node.children) {
            for (Node childNode : node.children) {
                dfsPostorder(childNode, list);
            }
        }
        list.add(node.val);
    }

}
