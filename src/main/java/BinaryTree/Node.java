package BinaryTree;

import java.util.List;

/**
 * @author yuanlin.yyl
 * @date 2020/04/19
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
