package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author qiubaisen
 * @date 2020/4/9
 */
public class StringListUtil {
    public static List<String> parse1DList(String input) {
        String[] array = CommonUtil.parse(input, String[].class);
        return Arrays.asList(array);
    }

    public static boolean unOrderEquals1DList(List<String> a, List<String> b) {
        if (a.size() != b.size()) return false;
        Map<String, Integer> aMap = a.stream().collect(Collectors.toMap(Function.identity(), x -> 1, Integer::sum));
        for (String bs : b) {
            aMap.compute(bs, (k, v) -> v == null ? -1 : v - 1);
        }
        return aMap.values().stream().allMatch(Predicate.isEqual(0));
    }
}
