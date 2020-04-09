package util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author qiubaisen
 * @date 2020/4/9
 */
public class StringListUtilTest {

    @Test
    public void parse1DList() {
        System.out.println(StringListUtil.parse1DList("[\n" +
                                                      "       \"((()))\",\n" +
                                                      "       \"(()())\",\n" +
                                                      "       \"(())()\",\n" +
                                                      "       \"()(())\",\n" +
                                                      "       \"()()()\"\n" +
                                                      "     ]"));
    }

    @Test
    public void unOrderEquals1DList() {
        assertTrue(StringListUtil.unOrderEquals1DList(Arrays.asList("a", "b"), Arrays.asList("b", "a")));
        assertTrue(StringListUtil.unOrderEquals1DList(Arrays.asList("a", "b", "a"), Arrays.asList("b", "a", "a")));
        assertFalse(StringListUtil.unOrderEquals1DList(Arrays.asList("a", "b", "a"), Arrays.asList("b", "a", "b")));
    }
}