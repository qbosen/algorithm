package top.abosen.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//[301] 删除无效的括号
/* "()())()" */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] arr;
        Set<String> result = new HashSet<>();

        public List<String> removeInvalidParentheses(String s) {
            int leftRemove = 0, rightRemove = 0;
            arr = s.toCharArray();
            for (char c : arr) {
                if (c == '(') {
                    leftRemove++;
                } else if (c == ')') {
                    if (leftRemove > 0) {
                        leftRemove--;
                    } else {
                        rightRemove++;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            backtrack(0, 0, 0, leftRemove, rightRemove, sb);
            return new ArrayList<>(result);
        }

        void backtrack(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder path) {
            if (index >= arr.length) {
                if (leftRemove == 0 && rightRemove == 0) {
                    result.add(path.toString());
                }
                return;
            }
            char c = arr[index];
            // 1. 删除
            if (c == '(' && leftRemove > 0) {
                backtrack(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path);
            }
            if (c == ')' && rightRemove > 0) {
                backtrack(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path);
            }
            // 2. 保留
            path.append(c);
            if (c != '(' && c != ')') {
                // 原样保留
                backtrack(index + 1, leftCount, rightCount, leftRemove, rightRemove, path);
            } else if (c == '(') {
                backtrack(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path);
            } else if (c == ')' && leftCount > rightCount) {
                backtrack(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path);
            }
            path.deleteCharAt(path.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}