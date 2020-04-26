package util;

import org.junit.Assert;
import org.junit.Test;
import struct.ListNode;

import java.util.Arrays;

import static util.IntUtil.parse1DIntArray;
import static util.IntUtil.parse2DIntArray;

/**
 * @author qiubaisen
 * @date 2020/4/8
 */
public class IntUtilTest {

    @Test
    public void test1D() {
        System.out.println(Arrays.toString(parse1DIntArray("[0,1,0,3,12]")));
    }

    @Test
    public void test2D() {
        String input = """
                [
                [15,13, 2, 5],
                [14, 3, 4, 1],
                [12, 6, 8, 9],
                [16, 7,10,11]
                ]""";
        System.out.println(Arrays.deepToString(parse2DIntArray(input)));
    }

    @Test
    public void parse1DInt2ListNode() {
        ListNode listNode = IntUtil.parse1DInt2ListNode("[7,2,4,3]");
        System.out.println(listNode);
    }

    @Test
    public void parse1DInt2TreeNode() {
        String[] testCase = {
                "[1,2,3,null,5,null,4]",
                "[3,1,4,null,null,2]",
                "[3,1,null,null,2]",
                "[5,3,6,2,4,null,null,1]"
        };

        for (String input : testCase) {
            TreePrinter.print(IntUtil.parse1DInt2TreeNode(input));
        }
    }

    @Test
    public void parse2DInt2ListNodeArray() {
        ListNode[] listNodes = IntUtil.parse2DInt2ListNodeArray("[[1,4,5],[1,3,4],[2,6]]");
        System.out.println(Arrays.deepToString(listNodes));
    }

    @Test
    public void testListNodeEquals() {
        ListNode listNode1 = IntUtil.parse1DInt2ListNode("[7,2,4,3]");
        ListNode listNode2 = IntUtil.parse1DInt2ListNode("[7,2,4,3]");
        Assert.assertEquals(listNode1, listNode2);
    }
}