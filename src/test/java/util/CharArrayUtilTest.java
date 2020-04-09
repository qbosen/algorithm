package util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author qiubaisen
 * @date 2020/4/9
 */
public class CharArrayUtilTest {

    @Test
    public void parse2D4String() {
        String input = "[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]";
        System.out.println(Arrays.deepToString(CharArrayUtil.parse2D4String(input)));
    }
}