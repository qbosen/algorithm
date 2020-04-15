package util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author qiubaisen
 * @date 2020/4/9
 */
public class StringUtilTest {

    @Test
    public void parse1DList() {
        System.out.println(StringUtil.parse1DList("""
                [
                       "((()))",
                       "(()())",
                       "(())()",
                       "()(())",
                       "()()()"
                     ]"""));
    }

    @Test
    public void unOrderEquals1DList() {
        assertTrue(StringUtil.unOrderEquals1DList(Arrays.asList("a", "b"), Arrays.asList("b", "a")));
        assertTrue(StringUtil.unOrderEquals1DList(Arrays.asList("a", "b", "a"), Arrays.asList("b", "a", "a")));
        assertFalse(StringUtil.unOrderEquals1DList(Arrays.asList("a", "b", "a"), Arrays.asList("b", "a", "b")));
    }
}