package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.List;

//[301] 删除无效的括号
/* "()())()" */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] arr;
        int resLen;
        List<String> result = new ArrayList<>();

        public List<String> removeInvalidParentheses(String s) {
            arr = s.toCharArray();
            int l = 0, r = 0;
            for (char c : arr) {
                if (c == '(') {
                    l++;
                } else if (c == ')') {
                    if (l > 0) {
                        l--;
                    } else {
                        r++;
                    }
                }
            }
            resLen = arr.length - l - r;
            StringBuilder sb = new StringBuilder();
            dfs(0, sb, 0);
            return result;
        }

        private void dfs(int index, StringBuilder path, int count) {
            if (count < 0 || arr.length - index + path.length() < resLen) {
                return;
            }
            if (index == arr.length) {
                if (count == 0 && path.length() == resLen) {
                    result.add(path.toString());
                }
                return;
            }
            char c = arr[index];

            int length = path.length();
            if (c != '(' && c != ')') {
                dfs(index + 1, path.append(c), count);
                path.deleteCharAt(path.length() - 1);
                return;
            }
            dfs(index + 1, path.append(c), c == '(' ? count + 1 : count - 1);
            path.deleteCharAt(path.length() - 1);

            if ((length == 0 || path.charAt(length - 1) != c)) {
                dfs(index + 1, path, count);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}