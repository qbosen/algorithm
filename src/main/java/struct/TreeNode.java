package struct;

import util.TreePrinter;

/**
 * @author qiubaisen
 * @date 2020/4/22
 */
public class TreeNode implements TreePrinter.PrintableNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return String.valueOf(val);
    }
}