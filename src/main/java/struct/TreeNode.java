package struct;

import org.jetbrains.annotations.Nullable;
import util.TreePrinter;

import java.util.Objects;

/**
 * @author qiubaisen
 * @date 2020/4/22
 */
public class TreeNode implements TreePrinter.PrintableNode {
    public int val;
    @Nullable
    public TreeNode left;
    @Nullable
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        if (val != treeNode.val) return false;
        if (!Objects.equals(left, treeNode.left)) return false;
        return Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
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