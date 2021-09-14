package top.abosen.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

//[524] 通过删除字母匹配到字典里最长单词
/* "abpcplea",["ale","apple","monkey","plea"] */
public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            dictionary.sort(Comparator.comparing(String::length).reversed().thenComparing(Function.identity()));
            for (String word : dictionary) {
                int i = 0, j = 0;
                while (i < s.length() && j < word.length()) {
                    if (word.charAt(j) == s.charAt(i)) {
                        i++;
                        j++;
                    } else {
                        i++;
                    }
                }
                if (j == word.length()) return word;
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}