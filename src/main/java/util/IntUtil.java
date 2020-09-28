package util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import struct.LinkedTreeNode;
import struct.ListNode;
import struct.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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

    public static List<List<Integer>> parse2DIntList(String input) {
        return Arrays.stream(parse2DIntArray(input))
                .map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public static ListNode parse1DInt2ListNode(String input) {
        return convert2ListNode(parse1DIntArray(input));
    }

    private static ListNode convert2ListNode(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for (int value : arr) {
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

    public static TreeNode parse1DInt2TreeNode2(String input) {
        Integer[] data = parse(input, Integer[].class);
        if (data.length == 0 || data[0] == null) return null;
        Queue<TreeNode> currentLayer = new LinkedList<>();
        TreeNode root = new TreeNode(data[0]);
        currentLayer.offer(root);

        fillChildTree2(data, currentLayer, 1);
        return root;
    }

    private static void fillChildTree2(Integer[] data, Queue<TreeNode> currentLayer, int idx) {
        if (currentLayer.isEmpty()) return;
        Queue<TreeNode> nextLayer = new LinkedList<>();
        for (; idx < data.length && !currentLayer.isEmpty(); idx += 2) {
            TreeNode node = currentLayer.poll();
            if (data[idx] != null) {
                TreeNode left = new TreeNode(data[idx]);
                nextLayer.offer(left);
                node.left = left;
            }
            if (idx + 1 < data.length && data[idx + 1] != null) {
                TreeNode right = new TreeNode(data[idx + 1]);
                nextLayer.offer(right);
                node.right = right;
            }
        }
        fillChildTree2(data, nextLayer, idx);
    }

    public static ListNode[] parse2DInt2ListNodeArray(String input) {
        int[][] data = parse2DIntArray(input);
        ListNode[] res = new ListNode[data.length];
        for (int i = 0; i < data.length; i++) {
            res[i] = convert2ListNode(data[i]);
        }
        return res;
    }
}
