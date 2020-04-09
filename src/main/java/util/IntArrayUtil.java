package util;

import static util.CommonUtil.parse;

/**
 * @author qiubaisen
 * @date 2020/3/31
 */
public class IntArrayUtil {

    public static int[] parse1DIntArray(String input) {
        return parse(input, int[].class);
    }

    public static int[][] parse2DIntArray(String input) {
        return parse(input, int[][].class);
    }


}
