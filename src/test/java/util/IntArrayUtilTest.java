package util;

import org.junit.Test;

import java.util.Arrays;

import static util.IntArrayUtil.parse1DIntArray;
import static util.IntArrayUtil.parse2DIntArray;

/**
 * @author qiubaisen
 * @date 2020/4/8
 */
public class IntArrayUtilTest {

    @Test
    public void test1D() {
        System.out.println(Arrays.toString(parse1DIntArray("[0,1,0,3,12]")));
    }

    @Test
    public void test2D() {
        String input = "[\n" +
                       "[15,13, 2, 5],\n" +
                       "[14, 3, 4, 1],\n" +
                       "[12, 6, 8, 9],\n" +
                       "[16, 7,10,11]\n" +
                       "]";
        System.out.println(Arrays.deepToString(parse2DIntArray(input)));

    }
}