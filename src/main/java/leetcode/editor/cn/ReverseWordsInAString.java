package leetcode.editor.cn;
// 翻转字符串里的单词
// 151
// "the sky is blue"

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
    public static void run(Solution solution, String expect, String s) {
        String s_ = s;
        String result = solution.reverseWords(s_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        run(solution,"blue is sky the" ,"the sky is blue");
        run(solution,"world! hello" ,"  hello world!  ");
        run(solution,"example good a" ,"a good   example"
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            List<String> list = Arrays.asList(s.trim().split("\\s+"));
            Collections.reverse(list);
            return String.join(" ",list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}