package util;

import struct.ListNode;
import struct.TreeNode;

import static util.CommonUtil.parse;

/**
 * @author qiubaisen
 * @date 2020/3/31
 */
public class IntUtil {

    public static int[] parse1DIntArray(String input) {
        return parse(input, int[].class);
    }

    public static int[][] parse2DIntArray(String input) {
        return parse(input, int[][].class);
    }

    public static ListNode parse1DInt2ListNode(String input) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for (int value : parse1DIntArray(input)) {
            ListNode node = new ListNode(value);
            prev.next = node;
            prev = node;
        }
        return dummy.next;
    }

    public static TreeNode parse1DInt2TreeNode(String input) {
        Integer[] data = parse(input, Integer[].class);
        if (data.length == 0 || data[0] == null) return null;
        TreeNode root = new TreeNode(data[0]);
        fillChildTree(data, root, 0);
        return root;
    }

    private static void fillChildTree(Integer[] data, TreeNode node, int idx) {
        int l = 1 + (idx << 1);
        int r = l + 1;
        if (l < data.length && data[l] != null) {
            node.left = new TreeNode(data[l]);
            fillChildTree(data, node.left, l);
        }
        if (r < data.length && data[r] != null) {
            node.right = new TreeNode(data[r]);
            fillChildTree(data, node.right, r);
        }
    }
}
