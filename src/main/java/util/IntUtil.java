package util;

import struct.ListNode;

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
        for (int value :  parse1DIntArray(input)) {
            ListNode node = new ListNode(value);
            prev.next = node;
            prev = node;
        }
        return dummy.next;
    }
}
