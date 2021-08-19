package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuanlin.yyl
 * @date 2020/04/19
 */
public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children == null) {
                continue;
            }
            int len = node.children.size();
            for (int i = len -1; i >= 0; i --) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

}
