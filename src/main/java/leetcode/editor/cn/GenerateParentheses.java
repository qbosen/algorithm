package leetcode.editor.cn;
// 括号生成
// 22
// 3

import org.junit.Assert;
import util.StringListUtil;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void run(Solution solution, List<String> expect, int n) {
        List<String> result = solution.generateParenthesis(n);
        Assert.assertTrue(StringListUtil.unOrderEquals1DList(result, expect));
    }

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> expect = StringListUtil.parse1DList("[\n" +
                                                         "       \"((()))\",\n" +
                                                         "       \"(()())\",\n" +
                                                         "       \"(())()\",\n" +
                                                         "       \"()(())\",\n" +
                                                         "       \"()()()\"\n" +
                                                         "     ]");
        run(solution, expect, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            make(list, "", n, n);
            return list;
        }

        private void make(List<String> list, String s, int l, int r) {
            if (l < 0 || r < 0 || l > r)
                return;
            if (l == 0 && r == 0) {
                list.add(s);
            }
            make(list, s + "(", l - 1, r);
            make(list, s + ")", l, r - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}